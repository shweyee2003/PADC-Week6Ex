package xyz.aungpyaephyo.padc.myanmarattractions.utils;

/**
 * Created by aung on 7/6/16.
 */
public class MyanmarAttractionsConstants {

    public static final String IMAGE_ROOT_DIR = "http://www.aungpyaephyo.xyz/myanmar_attractions/";

    public static final String ATTRACTION_BASE_URL = "http://www.aungpyaephyo.xyz/myanmar_attractions/";
    public static final String API_GET_ATTRACTION_LIST = "getAttractionsList.php";
    public static final String API_GET_REGISTER = "register.php";
    public static final String API_GET_LOGIN = "login.php";

    public static final String PARAM_ACCESS_TOKEN = "access_token";
    public static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    public static final String PARAM_NAME = "name";
    public static  String USER_NAME;

    public static final String PARAM_EMAIL = "email";
    public static  String USER_EMAIL;

    public static final String PARAM_PASSWORD = "password";
    public static  String USER_PASSWORD;

    public static final String PARAM_COUNTRY_OF_ORIGIN = "country_of_origin";
    public static  String USER_COUNTRY_OF_ORIGIN;

    public static final String PARAM_DATE_OF_BIRTH = "date_of_birth";
    public static  String USER_DATE_OF_BIRTH;

    public static  boolean IS_TABLET;
    public static boolean IS_BTNREGISTER;

    public static  final int ATTRACTION_LIST_LOADER=1;
    public static final int ATTRACTION_DETAIL_LOADER=2;
}