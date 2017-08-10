package com.codepath.apps.mysimpletweets.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ListView;

import com.codepath.apps.mysimpletweets.R;
import com.codepath.apps.mysimpletweets.TweetsArrayAdapter;
import com.codepath.apps.mysimpletweets.models.Tweet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AHTT - V P-FEMININ on 8/9/2017.
 */

public class TweetsListFragment extends Fragment {
    private ArrayList<Tweet> tweets;
    private TweetsArrayAdapter aTweets;
    private ListView lvTweets;

    //Inflate
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup parent, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tweets_list, parent, false);
        lvTweets = (ListView) v.findViewById(R.id.lvTweets);
        lvTweets.setAdapter(aTweets);
        return v;
    }
        //Creation lifecycle

        @Override
       public void onCreate(Bundle savedInstanceState){
             super.onCreate(savedInstanceState);
            tweets = new ArrayList<>();
            aTweets = new TweetsArrayAdapter(getActivity(), tweets);

        }
        public void addAll(List<Tweet> tweets){
            aTweets.addAll(tweets);
        }


    }

