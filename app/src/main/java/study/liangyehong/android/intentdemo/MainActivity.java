package study.liangyehong.android.intentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import study.liangyehong.android.intentdemo.One.CharacterCalculator;
import study.liangyehong.android.intentdemo.Three.SmsMain;
import study.liangyehong.android.intentdemo.Two.SendMess;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1:
                Intent intent1 = new Intent(this,CharacterCalculator.class);
                startActivity(intent1);
                break;
            case R.id.btn2:
                Intent intent2 = new Intent(this,SendMess.class);
                startActivity(intent2);
                break;
            case R.id.btn3:
                Intent intent3 = new Intent(this,SmsMain.class);
                startActivity(intent3);
                break;
        }
    }
}
