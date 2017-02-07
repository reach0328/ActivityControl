package com.android.jh.activitycontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TransActivity extends AppCompatActivity implements View.OnClickListener{
    private  static final String TAG = "TranActivity";
    EditText etValue;
    Button btnOk;
    TextView tvValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trans);
        etValue = (EditText)findViewById(R.id.editText2);
        btnOk = (Button)findViewById(R.id.btnok);
        tvValue = (TextView)findViewById(R.id.backtext);
        btnOk.setOnClickListener(this);
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

    @Override
    public void onClick(View view) {
        returnValue();
        finish();
    }
    private void returnValue(){
        Intent intent = new Intent();
        String result = etValue.getText().toString();
        // 처리상태 설정
        int statusCode = 1;
        //되돌려줄 값이 문제가 있으면 처리상태 변경
        if(result== null || result.equals("")){
            statusCode =0;
        }
        //돌려줄 값을 intent에 세팅
        intent.putExtra("result", result);
        //setresult 함수로 결과값 전송
        setResult(statusCode, intent);
        //액티비티를 종료하여 메인 액티비티를 화면에 나타낸다
    }
    @Override
    public void onBackPressed(){
        returnValue();
        super.onBackPressed();
    }
}
