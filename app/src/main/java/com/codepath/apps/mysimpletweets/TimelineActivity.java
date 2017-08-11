package com.codepath.apps.mysimpletweets;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.astuetz.PagerSlidingTabStrip;
import com.codepath.apps.mysimpletweets.fragment.HomeTimelineFragment;
import com.codepath.apps.mysimpletweets.fragment.MentionsTimelineFragment;
import com.codepath.apps.mysimpletweets.fragment.TweetsListFragment;
import com.codepath.apps.mysimpletweets.models.Tweet;
import com.codepath.apps.mysimpletweets.models.User;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class TimelineActivity extends AppCompatActivity  {



       private SwipeRefreshLayout swipeContainer;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timeline);
        //Get the viewpager
        ViewPager vpPager = (ViewPager) findViewById(R.id.viewpager);
        //Set the viewpager adapter for the pager
        vpPager.setAdapter(new TweetsPagerAdapter(getSupportFragmentManager()));
        //find the sliding tabstrip
        PagerSlidingTabStrip tabStrip = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        //Attach the tabstrip to the viewpager
        tabStrip.setViewPager(vpPager);
    }


      /*  if (savedInstanceState == null) {

        }
        fragmentTweetList = (TweetsListFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_timeline);





        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupSwitchRefreshLayout();*/


        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
           public void onClick(View view) {
                Intent i = new Intent(TimelineActivity.this, ComposeActivity.class);

                startActivityForResult(i, 10);

            }


        });*/


       /* setupSwitchRefreshLayout();
        lvTweets = (ListView) findViewById(R.id.lvTweets);


        tweets = new ArrayList<>();
        aTweets = new TweetsArrayAdapter(this, tweets);
        lvTweets.setAdapter(aTweets);}*/





   /* private void setupSwitchRefreshLayout() {
        swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                populateTimeline();
            }
        });
        swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);


    }*/

    private void loadNextDataFromApi(int page) {


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_timeline, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
       /* if (id == R.id.action_settings) {
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }
    public void onProfileView (MenuItem mi){
        //Launch the activity_profile view
        Intent i = new Intent(this, ProfileActivity.class);
        startActivity(i);


    }

    //return fragment in the view pager
    public class TweetsPagerAdapter extends FragmentPagerAdapter{
        //final int PAGE_COUNT = 2;
        //return the order of the fragment in the view page
        private String tabTitle[] = {"Home", "Mentions"};
        public TweetsPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        //the order and the creation of the fragment within the pager

        @Override
        public Fragment getItem(int position) {
           // return null;
            if (position == 0) {
                return new HomeTimelineFragment();
            }else if (position ==1){
                return new MentionsTimelineFragment();
            }else {
                return null;
            }
        }
        //return the tab title

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle[position];
        }
        //how many fragments there are to swipe between?

        @Override
        public int getCount() {
            return tabTitle.length;
        }
    }
}
