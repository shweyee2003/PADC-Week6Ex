package xyz.aungpyaephyo.padc.myanmarattractions.data.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by windows on 7/16/2016.
 */
public class UserDBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "users.db";

    private static final String SQL_CREATE_USER_TABLE = "CREATE TABLE " + UsersContract.UserEntry.TABLE_NAME + " (" +
            UsersContract.UserEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            UsersContract.UserEntry.COLUMN_NAME + " TEXT NOT NULL, "+
            UsersContract.UserEntry.COLUMN_EMAIL + " TEXT NOT NULL, "+
            UsersContract.UserEntry.COLUMN_PASSWORD + " TEXT NOT NULL, "+
            UsersContract.UserEntry.COLUMN_DATE_OF_BIRTH + " TEXT NOT NULL, "+
            UsersContract.UserEntry.COLUMN_COUNTRY_OF_ORIGIN + " TEXT NOT NULL, "+

            " UNIQUE (" + UsersContract.UserEntry.COLUMN_EMAIL + ") ON CONFLICT IGNORE" +
            " );";


    public UserDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_USER_TABLE);

    }

    //based on nature of application  onUpgrade like update
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + UsersContract.UserEntry.TABLE_NAME);

        onCreate(sqLiteDatabase);
    }
}
