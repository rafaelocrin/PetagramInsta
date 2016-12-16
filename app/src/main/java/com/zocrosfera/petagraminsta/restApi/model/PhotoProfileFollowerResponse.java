package com.zocrosfera.petagraminsta.restApi.model;

import com.zocrosfera.petagraminsta.pojo.Follower;
import com.zocrosfera.petagraminsta.pojo.PhotoProfileFollower;

import java.util.ArrayList;

/**
 * Created by rafaelocrin on 16/12/16.
 */

public class PhotoProfileFollowerResponse {
    ArrayList<PhotoProfileFollower> photoProfileFollowers;

    public ArrayList<PhotoProfileFollower> getPhotoProfileFollowers() {
        return photoProfileFollowers;
    }

    public void setPhotoProfileFollowers(ArrayList<PhotoProfileFollower> photoProfileFollowers) {
        this.photoProfileFollowers = photoProfileFollowers;
    }
}
