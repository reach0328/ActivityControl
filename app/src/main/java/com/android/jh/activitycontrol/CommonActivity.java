package com.android.jh.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CommonActivity extends AppCompatActivity {
    private  static final String TAG = "CommonActivity";
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        tv = (TextView)findViewById(R.id.textview123);
        // intent 꺼내기
        Intent intent = getIntent();
        // intent 에서 extra 꾸러미 꺼내기
        Bundle bundle = intent.getExtras();
        // bundle에서 변수 직접(타입에 맞추어) 꺼내기
        String string =  bundle.getString("var");
        tv.setText(string)  ;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Logger.print("onStatrt 시작",TAG);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.print("onResume 시작",TAG);
    }

    //Running
    @Override
    protected void onPause() {
        super.onPause();
        Logger.print("onPause 시작",TAG);
    }
    @Override
    protected void onStop() {
        super.onStop();
        Logger.print("onStop 시작",TAG);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Logger.print("onRestart 시작",TAG);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.print("onDtestroy 시작",TAG);
    }
}
