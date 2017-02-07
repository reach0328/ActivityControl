package com.android.jh.activitycontrol;


import android.util.Log;


/**
 *
 */
public class Logger {
    public final static boolean DEBUG_MODE = true;   //uildConfig.DEBUG -> 정상동작 안할경우 강제로 세팅

    /** 로그 내용을 콘솔에 출력
     *
     * @param string
     * @param className
     */
    public static void print(String string, String className) {
        if (DEBUG_MODE) {
            Log.d(className, string);
        }
    }
}
