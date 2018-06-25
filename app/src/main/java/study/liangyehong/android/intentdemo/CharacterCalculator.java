package study.liangyehong.android.intentdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CharacterCalculator extends AppCompatActivity {

    private EditText et_name;
    private RadioGroup rg_group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_calculator);

        et_name = (EditText)findViewById(R.id.et_name);
        rg_group = (RadioGroup)findViewById(R.id.radioGroup1);
    }

    //点击事件
    public void click(View view){
        //获取用户名
        String name = et_name.getText().toString().trim();
        //判断用户名是否为空
        if (TextUtils.isEmpty(name)){
            Toast.makeText(this,"请输入用户名",Toast.LENGTH_SHORT).show();
            return;
        }

        //判断用户选择的性别
        int radioButtonId = rg_group.getCheckedRadioButtonId();
        //给性别设置一个初始值，用来判断用户是否有选择性别
        int sex = 0;

        switch (radioButtonId){
            //代表选的是男
            case R.id.rb_male:
                sex = 1;
                break;
            //代表选的是女
            case R.id.rb_female:
                sex = 2;
                break;
        }

        if (sex == 0){
            Toast.makeText(this,"请选择性别",Toast.LENGTH_SHORT).show();
            //这里的return功能类似于break
            return;
        }
        //跳转页面，并传递数据
        Intent intent = new Intent(this,ResultActiviyt.class);
        //传递姓名
        intent.putExtra("name",name);
        //传递性别
        intent.putExtra("sex",sex);
        startActivity(intent);
    }
}
