package com.mm;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by marcomanglaviti on 16-09-13.
 */
public class Feed {

    public Feed(){
        Twitter twitter = TwitterFactory.getSingleton();
        List<Status> statuses = new ArrayList<Status>();
        try {
            statuses = twitter.getHomeTimeline();
        } catch (TwitterException e){
            System.out.println("ERROR: Could not get timeline :(");
        }
        System.out.println("\t\tShowing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }

    }


    public static void main(String [] args){
        System.out.println("\tStarting Twitter Feed...");
        new Feed();

    }
}
