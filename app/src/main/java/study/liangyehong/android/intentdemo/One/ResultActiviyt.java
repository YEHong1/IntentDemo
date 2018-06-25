package study.liangyehong.android.intentdemo.One;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

import study.liangyehong.android.intentdemo.R;

public class ResultActiviyt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_activiyt);

        TextView tv_name = (TextView) findViewById(R.id.tv_name);
        TextView tv_sex = (TextView) findViewById(R.id.tv_sex);
        TextView tv_result = (TextView) findViewById(R.id.tv_result);

        //获取CharacterCalculator.class传递过来的数据
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        //第二个参数为默认值，但取不到数据时，使用默认值
        int sex = intent.getIntExtra("sex",0);

        tv_name.setText(name);
        byte[] bytes = null;
        switch (sex){
            case 1:

                try {
                    tv_sex.setText("男");
                    bytes = name.getBytes("gbk");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
            case 2:

                try {
                    tv_sex.setText("女");
                    bytes = name.getBytes("utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                break;
        }

        //用随机数带代表人品
        int total = 0;
        //for(元素类型t 元素变量x : 遍历对象obj)
        for (byte b : bytes){
            int number = b&0xff;
            total+=number;
        }
        // 获取得分
        int score =  Math.abs(total)%100;
        if (score > 90) {
            tv_result.setText("您的人品非常好,您家的祖坟都冒青烟啦");
        }else if (score > 80) {
            tv_result.setText("您的人品还可以  ");
        }else if (score > 60) {
            tv_result.setText("您的人品刚及格");
        }else{
            tv_result.setText("您的人品太次了  您需要努力啊");

        }
    }
}
