package xyz.aungpyaephyo.padc.myanmarattractions.data.agents.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import xyz.aungpyaephyo.padc.myanmarattractions.data.responses.UserListResponse;
import xyz.aungpyaephyo.padc.myanmarattractions.utils.MyanmarAttractionsConstants;

/**
 * Created by windows on 7/15/2016.
 */
public interface UserApi {
    @FormUrlEncoded
    @POST(MyanmarAttractionsConstants.API_GET_REGISTER)
    Call<UserListResponse> loadRegister(
            @Field(MyanmarAttractionsConstants.PARAM_NAME) String paramname,@Field(MyanmarAttractionsConstants.PARAM_EMAIL) String paramemail,@Field(MyanmarAttractionsConstants.PARAM_PASSWORD) String parampassword,@Field(MyanmarAttractionsConstants.PARAM_DATE_OF_BIRTH) String paramdateofbirth,@Field(MyanmarAttractionsConstants.PARAM_COUNTRY_OF_ORIGIN) String paramcountry);

    @FormUrlEncoded
    @POST(MyanmarAttractionsConstants.API_GET_LOGIN)
    Call<UserListResponse> loadLogin(
            @Field(MyanmarAttractionsConstants.PARAM_EMAIL) String param,@Field(MyanmarAttractionsConstants.PARAM_PASSWORD) String parampassword);
}
