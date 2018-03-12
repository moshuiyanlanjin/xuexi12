package com.xuexi1.zz.xuexi1;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-02-28.
 */

public class Activitycollector {
    public static List<Activity> activityies = new ArrayList<Activity>();
    public static void addActivity(Activity activity){
        activityies.add(activity);
    }
    public static void removeActivity(Activity activity){
        activityies.remove(activity);
    }
    public static void finshAll(){
        for (Activity activity:activityies){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}
