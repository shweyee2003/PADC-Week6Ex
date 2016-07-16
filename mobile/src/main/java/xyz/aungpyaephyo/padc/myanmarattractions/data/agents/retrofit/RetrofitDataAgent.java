package xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.AttractionDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.agents.UserDataAgent;
import xyz.aungpyaephyo.padc.myanmarattractions.data.models.AttractionModel;
import xyz.aungpyaephyo.padc.myanmarattractions.data.models.UserModel;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.AttractionListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.UserListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.CommonInstances;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

/**
 * Created by aung on 7/9/16.
 */
public class RetrofitDataAgent implements AttractionDataAgent,UserDataAgent {

    private static RetrofitDataAgent objInstance;

    private final AttractionApi theApi;
    private final UserApi userApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(MyanmarAttractionsConstants.ATTRACTION_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(CommonInstances.getGsonInstance()))//convert response to type
                .client(okHttpClient)
                .build();

        theApi = retrofit.create(AttractionApi.class);
        userApi = retrofit.create(UserApi.class);
    }

    public static RetrofitDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadAttractions() {
        Call<AttractionListResponse> loadAttractionCall = theApi.loadAttractions(MyanmarAttractionsConstants.ACCESS_TOKEN);
        loadAttractionCall.enqueue(new Callback<AttractionListResponse>() {
            @Override
            public void onResponse(Call<AttractionListResponse> call, Response<AttractionListResponse> response) {
                AttractionListResponse attractionListResponse = response.body();
                if (attractionListResponse == null) {
                    AttractionModel.getInstance().notifyErrorInLoadingAttractions(response.message());
                } else {
                    AttractionModel.getInstance().notifyAttractionsLoaded(attractionListResponse.getAttractionList());
                }
            }

            @Override
            public void onFailure(Call<AttractionListResponse> call, Throwable throwable) {
                AttractionModel.getInstance().notifyErrorInLoadingAttractions(throwable.getMessage());
            }
        });
    }

    @Override
    public void loadRegister() {
        Call<UserListResponse> loadRegisterCall = userApi.loadRegister(MyanmarAttractionsConstants.USER_NAME,MyanmarAttractionsConstants.USER_EMAIL,MyanmarAttractionsConstants.USER_PASSWORD,MyanmarAttractionsConstants.USER_DATE_OF_BIRTH,MyanmarAttractionsConstants.USER_COUNTRY_OF_ORIGIN);
        loadRegisterCall.enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                UserListResponse RegisterListResponse = response.body();
                if (RegisterListResponse == null) {
                    UserModel.getInstance().notifyErrorInLoadingUsers(response.message());
                } else {
                    UserModel.getInstance().notifyUsersLoaded(RegisterListResponse.getUserList());
                }
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable throwable) {
                UserModel.getInstance().notifyErrorInLoadingUsers(throwable.getMessage());
            }
        });
    }

    @Override
    public void loadLogin() {
        Call<UserListResponse> loadLoginCall = userApi.loadLogin(MyanmarAttractionsConstants.USER_EMAIL,MyanmarAttractionsConstants.USER_PASSWORD);
        loadLoginCall.enqueue(new Callback<UserListResponse>() {
            @Override
            public void onResponse(Call<UserListResponse> call, Response<UserListResponse> response) {
                UserListResponse userListResponse = response.body();
                if (userListResponse == null) {
                    UserModel.getInstance().notifyErrorInLoadingUsers(response.message());
                } else {
                    UserModel.getInstance().notifyUsersLoaded(userListResponse.getUserList());
                }
            }

            @Override
            public void onFailure(Call<UserListResponse> call, Throwable throwable) {
                UserModel.getInstance().notifyErrorInLoadingUsers(throwable.getMessage());
            }
        });
    }
}