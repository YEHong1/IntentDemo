package study.liangyehong.android.intentdemo.Two;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import study.liangyehong.android.intentdemo.R;

public class SendMess extends AppCompatActivity {

    String objects[] = {
            "海内存知己，天涯若比邻。",
            "有时忽惆怅，匡坐至夜分。",
            "巅峰迎来虚伪的看客，黄昏见证真正的信徒。"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mess);

        ListView lv = (ListView)findViewById(R.id.lv);
        //设置数据
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.message,objects);
        //设置数据适配器
        lv.setAdapter(adapter);
        //给ListView设置点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            //当listview的一个条目被点击时调用
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //把点击条目的数据取出来
                String content = objects[position];

                //[6]跳转到发送短信页面
				/*<intent-filter>
	               <action android:name="android.intent.action.SEND" />
	               <category android:name="android.intent.category.DEFAULT" />
	               <data android:mimeType="text/plain" />
	           </intent-filter>*/
                Intent intent = new Intent();
                //[6.1]设置action
                intent.setAction("android.intent.action.SEND");
                //[6.2]添加category
                intent.addCategory("android.intent.category.DEFAULT");
                //[6.3]设置type
                intent.setType("text/plain");

                //[6.4]传递数据
                intent.putExtra("sms_body", content);


                //[7]跳转到发送短信页面
                startActivity(intent);
            }
        });
    }
}
