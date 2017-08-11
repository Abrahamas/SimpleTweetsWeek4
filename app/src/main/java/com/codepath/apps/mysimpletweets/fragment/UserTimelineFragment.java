package com.codepath.apps.mysimpletweets.fragment;

import android.os.Bundle;
import android.util.Log;

import com.codepath.apps.mysimpletweets.TwitterApplication;
import com.codepath.apps.mysimpletweets.TwitterClient;
import com.codepath.apps.mysimpletweets.models.Tweet;
import com.codepath.apps.mysimpletweets.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.codepath.apps.mysimpletweets.EndlessScrollListener;

import org.json.JSONArray;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by AHTT - V P-FEMININ on 8/10/2017.
 */

public class UserTimelineFragment extends TweetsListFragment {
    private TwitterClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        client = TwitterApplication.getRestClient();
        populateTimeline();
    }
    public static UserTimelineFragment newInstance(String screen_name) {
        UserTimelineFragment userFragment = new UserTimelineFragment();
        Bundle args = new Bundle();
        args.putString("screen_name", screen_name);
        userFragment.setArguments(args);
        return userFragment;
    }

    private void populateTimeline() {
        String screenName = getArguments().getString("screen_name");
        client.getUserTimeline(screenName,new JsonHttpResponseHandler() {
            //SUCCESS

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray json) {
                // Log.d("DEBUG", json.toString());
                addAll(Tweet.fromJSONArray(json));
            }


            //FAILURE

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                Log.d("DEBUG", errorResponse.toString());
            }
        });
    }
}
