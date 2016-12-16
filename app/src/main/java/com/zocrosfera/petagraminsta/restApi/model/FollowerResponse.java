package com.zocrosfera.petagraminsta.restApi.model;

import com.zocrosfera.petagraminsta.pojo.Contacto;
import com.zocrosfera.petagraminsta.pojo.Follower;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 14/12/16.
 */

public class FollowerResponse {
    ArrayList<Follower> followers;

    public ArrayList<Follower> getFollowers() {
        return followers;
    }

    public void setFollowers(ArrayList<Follower> followers) {
        this.followers = followers;
    }
}
