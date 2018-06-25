package study.liangyehong.android.intentdemo.Three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;

import study.liangyehong.android.intentdemo.R;

public class SmsMain extends AppCompatActivity {

    private EditText et_number;
    private EditText et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_manager);

        et_number = (EditText)findViewById(R.id.et_number);
        et_content = (EditText)findViewById(R.id.et_content);
    }

    //点击按钮跳转到联系人页面
    public void add(View view){
        Intent intent = new Intent(this,ContactActivity.class);
        //第二个参数为请求码
        startActivityForResult(intent,1);
    }

    //点击按钮跳转到短信模板页面
    public void insertsms(View view){
        Intent intent = new Intent(this,SmsTemplate.class);
        //第二个参数为请求码
        startActivityForResult(intent,2);
    }

    //当我们开启的activity页面关闭的时候，这个方法就会被调用

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1) {
            //代表请求ContactActivity这个页面的数据
            String phone = data.getStringExtra("phone");
            et_number.setText(phone);

        }else if (requestCode == 2) {
            //代表请求 短信模板页面的数据

            String smsContent = data.getStringExtra("smsContent");
            et_content.setText(smsContent);
        }


		/*
		if (resultCode == 10) {
			//说明数据是从 ContactActivity 返回
			String phone = data.getStringExtra("phone");
			et_number.setText(phone);

		}else if (resultCode == 20) {
			//说明数据 是从 SmsTempate 返回
			String smsContent = data.getStringExtra("smscontent");
			et_content.setText(smsContent);
		}
		*/
    }

    //点击按钮 发送短信
    public void send(View v){

        //[1]获取发送短信的号码 和 发送的内容
        String number = et_number.getText().toString().trim();
        String content = et_content.getText().toString().trim();
        //[2]获取到smsmanager的实例
        SmsManager smsManager = SmsManager.getDefault();

        ArrayList<String> divideMessages = smsManager.divideMessage(content);
        for (String div : divideMessages) {


            /**
             * destinationAddress  发送给谁
             * scAddress  服务中心号码
             *
             * text 要发送的内容
             */

            smsManager.sendTextMessage(number, null, div, null, null);
        }

    }
}
