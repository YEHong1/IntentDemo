package study.liangyehong.android.intentdemo.Three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import study.liangyehong.android.intentdemo.R;

public class SmsTemplate extends AppCompatActivity {

    String objects[] = {
            "我在吃饭,请稍后联系",
            "我在开会,请稍后联系",
            "我在上课,请稍后联系",
            "我在工作,请稍后联系",
            "我在约会,请稍后联系"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_template);

        ListView lv = (ListView)findViewById(R.id.lv);
        //适配器
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.smstemplate_item,objects);
        //展示数据
        lv.setAdapter(adapter);
        //lv的点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String smsContent = objects[position];
                //把smsContent返回给调用者
                Intent intent = new Intent();
                intent.putExtra("smsContent",smsContent);
                setResult(20,intent);
                //关闭当前界面
                finish();
            }
        });
    }
}
