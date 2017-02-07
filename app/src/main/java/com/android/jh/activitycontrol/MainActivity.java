package com.android.jh.activitycontrol;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * CommonActivity 와 TransActivity를 Strat하고
 * 콘솔에 출력되는 로그를 관찰하세요
 *
 */
public class MainActivity extends AppCompatActivity {
    public  final static int ONE= 1;
    public final static int TWO = 2;
    private  static final String TAG = "MainActivity";
    Intent intent;
    EditText et,et_all ;
    TextView trans1_tv, trans2_tv;
    Button btnCommon,btnTrans,btnTrans2,btnSms,btnDal,btnURL;
    String value ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //액티비디 라이프사이클 체크
        et = (EditText)findViewById(R.id.editText);
        btnCommon = (Button)findViewById(R.id.btncommon);
        btnTrans = (Button)findViewById(R.id.btnTrans);
        trans1_tv = (TextView)findViewById(R.id.tran_tv);
        trans2_tv =(TextView)findViewById(R.id.trans2_tv);
        btnTrans2 =(Button)findViewById(R.id.btntrans2);
        // 묵시적 인텐트 확인

        et_all = (EditText)findViewById(R.id.edit_text);
        btnDal =(Button)findViewById(R.id.btn_dal);
        btnDal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = et_all.getText().toString();
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+value));
                startActivity(intent);
            }
        });
        btnSms = (Button)findViewById(R.id.btn_sms);
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = et_all.getText().toString();
                intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+value));
                startActivity(intent);
            }
        });
        btnURL = (Button)findViewById(R.id.btn_url);
        btnURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value = et_all.getText().toString();
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://"+value));
                startActivity(intent);
            }
        });
        btnCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,CommonActivity.class);
                // putExtra 함수에 전달할 값 설정
                intent.putExtra("var",et.getText().toString());
                // Extra에 담긴 값을 intent로 전달
                startActivity(intent);
            }
        });
        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,TransActivity.class);
                intent.putExtra("var",et.getText().toString());
                startActivityForResult(intent,ONE);
            }
        });
        btnTrans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(MainActivity.this,TransActivity.class);
                intent.putExtra("var",et.getText().toString());
                startActivityForResult(intent,TWO);
            }
        });
    }

    /**
     * startActivityForResult 함수로 호출된 액티비티가 종료되면서 호출
     * @param requestCode   호출시에 메인 액티비티에서 넘긴 구분값
     * @param resultCode    호출된 액티비티의 처리 상태
     * @param data  호출된 액티비티가 돌려주는 데이터
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(resultCode,resultCode,data);
        if(resultCode ==1) {
            Bundle bundle = data.getExtras();
            String result = bundle.getString("result");
            switch (requestCode) {
                case ONE:
                    trans1_tv.setText(result);
                    break;
                case TWO:
                    trans2_tv.setText(result);
                    break;
            }
        }
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
