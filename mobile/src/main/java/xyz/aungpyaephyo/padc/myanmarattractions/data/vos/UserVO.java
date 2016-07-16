package xyz.aungpyaephyo.padc.myanmarattractions.data.vos;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;
import java.util.List;

import xyz.aungpyaephyo.padc.myanmarattractions.MyanmarAttractionsApp;
import xyz.aungpyaephyo.padc.myanmarattractions.data.persistence.AttractionsContract;

/**
 * Created by windows on 7/14/2016.
 */
public class UserVO {
    @SerializedName("name")
    private String name;

    @SerializedName("email")
    private String email;

    @SerializedName("access_token")
    private String access_token;

    @SerializedName("date_of_birth")
    private Date date_of_birth;

    @SerializedName("country_of_origin")
    private String country_of_origin;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAccess_token() {
        return access_token;
    }

    public Date getDate_of_birth(){
        return date_of_birth;
    }

    public String getCountry_of_origin(){return country_of_origin;}

    public static void saveUsers(List<UserVO> userList) {
        Context context = MyanmarAttractionsApp.getContext();
        ContentValues[] userCVs = new ContentValues[userList.size()];
        for (int index = 0; index < userList.size(); index++) {
            UserVO user = userList.get(index);
            userCVs[index] = user.parseToContentValues();


        }

        //Bulk insert into attractions.
        int insertedCount = context.getContentResolver().bulkInsert(AttractionsContract.AttractionEntry.CONTENT_URI, userCVs);

        Log.d(MyanmarAttractionsApp.TAG, "Bulk inserted into attraction table : " + insertedCount);
    }

    private ContentValues parseToContentValues() {
        ContentValues cv = new ContentValues();
        cv.put(AttractionsContract.AttractionEntry.COLUMN_TITLE, name);
        cv.put(AttractionsContract.AttractionEntry.COLUMN_DESC, email);
        return cv;
    }
}
