package com.zocrosfera.petagraminsta.pojo;

/**
 * Created by rafaelocrin on 14/12/16.
 */

public class Follower {
    private String id;
    private String profilePicture;
    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Follower(){

    }
}
