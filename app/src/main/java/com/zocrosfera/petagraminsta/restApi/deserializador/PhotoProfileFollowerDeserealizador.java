package com.zocrosfera.petagraminsta.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.pojo.PhotoProfileFollower;
import com.zocrosfera.petagraminsta.restApi.JsonKeys;
import com.zocrosfera.petagraminsta.restApi.model.PhotoProfileFollowerResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rafaelocrin on 16/12/16.
 */

public class PhotoProfileFollowerDeserealizador implements JsonDeserializer<PhotoProfileFollowerResponse> {


    @Override
    public PhotoProfileFollowerResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PhotoProfileFollowerResponse photoProfileFollowerResponse = gson.fromJson(json, PhotoProfileFollowerResponse.class);
        JsonArray photoProfileFollowerResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        photoProfileFollowerResponse.setPhotoProfileFollowers(deserializarPhotoProfileFollowerDeJson(photoProfileFollowerResponseData));

        return photoProfileFollowerResponse;
    }

    private ArrayList<PhotoProfileFollower> deserializarPhotoProfileFollowerDeJson(JsonArray photoProfileFollowerResponseData){
        ArrayList<PhotoProfileFollower> followers = new ArrayList<>();

        for (int i = 0; i < photoProfileFollowerResponseData.size(); i++) {
            JsonObject photoProfileFollowerResponseDataObject = photoProfileFollowerResponseData.get(i).getAsJsonObject();
            //String nombreCompleto = userJson.get(JsonKeys.USER_FULLNAME).getAsString();
            JsonObject imageJson = photoProfileFollowerResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String url = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();
            JsonObject likesJson = photoProfileFollowerResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            PhotoProfileFollower photoProfileFollowerActual = new PhotoProfileFollower();
            photoProfileFollowerActual.setUrlFoto(url);
            photoProfileFollowerActual.setRatings(String.valueOf(likes));

            followers.add(photoProfileFollowerActual);
        }

        return followers;
    }
}
