package com.zocrosfera.petagraminsta.restApi;

import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.restApi.model.ContactoResponse;
import com.zocrosfera.petagraminsta.restApi.model.FollowerResponse;
import com.zocrosfera.petagraminsta.restApi.model.PhotoProfileFollowerResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rafaelocrin on 12/12/16.
 */

public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<ContactoResponse> getRecentMedia();

//    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
//    Call<ContactoResponse> getRecentMedia(@Query("id") String id);

    @GET(ConstantesRestApi.URL_GET_FOLLOWERS)
    Call<FollowerResponse> getFollowers();

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER_BY_ID)
    Call<PhotoProfileFollowerResponse> getRecentMediaById();
}
