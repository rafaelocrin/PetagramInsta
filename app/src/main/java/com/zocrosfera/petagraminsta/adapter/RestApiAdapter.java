package com.zocrosfera.petagraminsta.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.restApi.ConstantesRestApi;
import com.zocrosfera.petagraminsta.restApi.EndpointsApi;
import com.zocrosfera.petagraminsta.restApi.deserializador.ContactoDeseralizador;
import com.zocrosfera.petagraminsta.restApi.deserializador.FollowerDeserealizador;
import com.zocrosfera.petagraminsta.restApi.deserializador.PhotoProfileFollowerDeserealizador;
import com.zocrosfera.petagraminsta.restApi.model.ContactoResponse;
import com.zocrosfera.petagraminsta.restApi.model.FollowerResponse;
import com.zocrosfera.petagraminsta.restApi.model.PhotoProfileFollowerResponse;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rafaelocrin on 12/12/16.
 */

public class RestApiAdapter {


//    public EndpointsApi establecerConexionRestApiInstagram(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ConstantesRestApi.ROOT_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        return retrofit.create(EndpointsApi.class);
//    }

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ContactoResponse.class, new ContactoDeseralizador());

        return gsonBuilder.create();
    }


    public Gson construyeGsonDeserializadorFollowers(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(FollowerResponse.class, new FollowerDeserealizador());

        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorPhotoProfileFollowers(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PhotoProfileFollowerResponse.class, new PhotoProfileFollowerDeserealizador());

        return gsonBuilder.create();
    }
}
