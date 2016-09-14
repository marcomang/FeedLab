package com.mm;

import twitter4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by marcomanglaviti on 16-09-13.
 */
public class Feed {

    public Feed() {
        Twitter twitter = new TwitterFactory().getInstance();
        String search = searchPrompt();
        Query query = new Query(search);
        QueryResult result = null;

        do {
            List<Status> tweets = new ArrayList<Status>();

            try {
                result = twitter.search(query);
                tweets = result.getTweets();
            } catch (TwitterException e) {
                e.printStackTrace();
            }

            for (Status tweet : tweets) {
                System.err.println("\t["+tweet.getCreatedAt()+" ("+ (tweet.getGeoLocation() != null ? tweet.getGeoLocation().getLatitude() : 0.0)+")] -- @"
                                        +tweet.getUser().getScreenName() + " - " + tweet.getText());
            }
        } while ((query = result.nextQuery()) != null);

    }

    private static String searchPrompt(){
        System.out.print("Enter text to search: ");
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public static void main(String [] args){
        System.out.println("\tStarting Twitter Feed...");
        new Feed();

    }
}
