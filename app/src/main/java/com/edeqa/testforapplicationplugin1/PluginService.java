package com.edeqa.testforapplicationplugin1;

import android.content.Intent;
import android.util.Log;

/**
 * Created 8/16/2017.
 */

public class PluginService extends com.edeqa.waytous.PluginService {
    static final String LOG_TAG = "ResPluginService1";

//    @Override
//    public String getType() {
//        return getClass().getSimpleName();
//    }

    @Override
    public boolean onEvent(String s, Object o) {
        switch(s) {
            case "test_event":
                Log.w(LOG_TAG, "TEST_EVENT:" + o);
                break;
            default:
                Log.w(LOG_TAG, s + ":" + o);
                break;
        }
        return true;
    }

    @Override
    public int getViewResId() {
        return R.layout.activity_main;
    }

    @Override
    public void viewClicked(int resId) {
        System.out.println("PLUGIN1:"+resId);

        Intent intent = new Intent(com.edeqa.waytous.PluginService.ACTION_POST_EVENT);
        intent.putExtra(ACTION_POST_EVENT_NAME, "event_name_from_plugin_one");
        intent.putExtra(ACTION_POST_EVENT_OBJECT, "event_object_from_plugin_one");
        getApplicationContext().sendBroadcast(intent);

    }

}


