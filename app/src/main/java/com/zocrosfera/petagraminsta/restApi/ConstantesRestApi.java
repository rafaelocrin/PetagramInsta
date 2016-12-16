package com.zocrosfera.petagraminsta.restApi;

/**
 * Created by rafaelocrin on 12/12/16.
 */

public class ConstantesRestApi {


    // Url base
    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN = "4234338535.6610010.ee89de992426461bbf3e4a9b7c8d2e14";
    public static final String KEY_ACCESS_TOKEN = "?access_token=";

    // Media Recent
    public static final String KEY_GET_INFORMATION_USER = "users/self/media/recent/";
    public static final String URL_GET_RECENT_MEDIA_USER = KEY_GET_INFORMATION_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN ;

    // Followers
    public static final String KEY_GET_INFORMATION_FOLLOWERS = "users/self/followed-by";
    public static final String URL_GET_FOLLOWERS = KEY_GET_INFORMATION_FOLLOWERS + KEY_ACCESS_TOKEN + ACCESS_TOKEN ;

    // Media Recent
    public static final String USERS = "users/";
    public static final String USER = "users/";
    public static final String KEY_GET_INFORMATION_USER_BY_ID = "users/3639431388/media/recent";
    public static final String URL_GET_RECENT_MEDIA_USER_BY_ID = KEY_GET_INFORMATION_USER_BY_ID + KEY_ACCESS_TOKEN + ACCESS_TOKEN ;

    // Followers
    //https://api.instagram.com/v1/users/self/followed-by?access_token=4234338535.6610010.ee89de992426461bbf3e4a9b7c8d2e14

    // Media Recent
    //https://api.instagram.com/v1/users/self/media/recent/?access_token=4234338535.6610010.ee89de992426461bbf3e4a9b7c8d2e14

    // Media Recent by Id
    //https://api.instagram.com/v1/users/188676266/media/recent/?access_token=4234338535.6610010.ee89de992426461bbf3e4a9b7c8d2e14


}
