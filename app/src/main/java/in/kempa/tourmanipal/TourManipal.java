package in.kempa.tourmanipal;

import android.app.Application;
import android.content.Context;

/**
 * Created by Ganesh Poojary on 11/6/2016.
 */

public class TourManipal extends Application {
    //final static String Website="http://192.168.43.229:8080/tourmanipal/?action=near_places";
    final static String Website="http://kempa.in/TourManipal/?action=near_places";
    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static String getWebsite() {
        return Website;
    }
}
