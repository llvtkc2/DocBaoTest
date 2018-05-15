package com.hdpsolutions.docbaotest.utils;

import android.app.Activity;
import android.util.DisplayMetrics;

public class ScreenUtils {

    public static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics displaymetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        return displaymetrics;
    }
}
