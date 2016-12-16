package com.zocrosfera.petagraminsta.restApi.deserializador;

import android.view.WindowId;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.restApi.JsonKeys;
import com.zocrosfera.petagraminsta.restApi.model.ContactoResponse;
import com.zocrosfera.petagraminsta.restApi.model.FollowerResponse;

import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by rafaelocrin on 15/12/16.
 */

public class FollowerDeserealizador implements JsonDeserializer<FollowerResponse> {
    @Override
    public FollowerResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        FollowerResponse followerResponse = gson.fromJson(json, FollowerResponse.class);
        JsonArray followerResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);
        followerResponse.setFollowers(deserializarFollowerDeJson(followerResponseData));

        return followerResponse;
    }

    private ArrayList<Follower> deserializarFollowerDeJson(JsonArray followerResponseData){
        ArrayList<Follower> followers = new ArrayList<>();

        for (int i = 0; i < followerResponseData.size(); i++) {
            JsonObject followerResponseDataObject = followerResponseData.get(i).getAsJsonObject();
            String id = followerResponseDataObject.get(JsonKeys.ID).getAsString();
            String userName = followerResponseDataObject.get(JsonKeys.USERNAME).getAsString();
            String profilePicture = followerResponseDataObject.get(JsonKeys.PROFILE_PICTURE).getAsString();

            Follower followerActual = new Follower();
            followerActual.setId(id);
            followerActual.setUserName(userName);
            followerActual.setProfilePicture(profilePicture);

            followers.add(followerActual);
        }

        return followers;
    }
}
