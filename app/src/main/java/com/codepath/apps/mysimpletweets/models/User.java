package com.codepath.apps.mysimpletweets.models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by AHTT - V P-FEMININ on 8/4/2017.
 */

public class
User {

    private String name;
    private long uid;
    private String screenName;
    private String profileImageUrl;
    private String tagline;
    private int followersCount;
    private int followingCount;


    public String getName() {
        return name;
    }

    public long getUid() {
        return uid;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getProfileImageUrl() {

        return profileImageUrl;
    }

    public String getTagline() {
        return tagline;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public int getFriendsCount() {
        return followingCount;
    }

    public static User fromJSON(JSONObject json){
        User u = new User();
        try {
            u.name = json.getString("name");
            u.uid = json.getLong("id");
            u.screenName = json.getString("screen_name");
            u.profileImageUrl = json.getString("profile_image_url");
            u.tagline = json.getString("description");
            u.followersCount = json.getInt("followers_count");
            u.followingCount = json.getInt("friends_count");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return u;
    }

}
