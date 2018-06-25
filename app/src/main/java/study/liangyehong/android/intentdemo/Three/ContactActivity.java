package study.liangyehong.android.intentdemo.Three;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import study.liangyehong.android.intentdemo.R;

public class ContactActivity extends AppCompatActivity {

    private List<Person> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        ListView lv = (ListView)findViewById(R.id.lv);

        //准备listview要展示的数据 这里模拟点假数据
        lists = new ArrayList<Person>();
        for (int i = 0; i < 10; i++){
            Person person = new Person();
            person.setName("张三" + i);
            person.setPhone("183123" + i);

            lists.add(person);
        }

        //展示数据
        lv.setAdapter(new MyAdapter());
        //给listview设置点击事件
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //获取我点中的条目的数据
                String phone = lists.get(position).getPhone();
                //把数据返回给调用者
                Intent intent = new Intent();
                intent.putExtra("phone",phone);
                //把结果返回给调用者
                setResult(10,intent);
                //关闭当前页面
                finish();
            }
        });
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null){
                view = View.inflate(getApplicationContext(),R.layout.contact_item,null);
            }else {
                view = convertView;
            }

            //找到我们在item 中定义的控件   用来显示数据
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
            //展示数据
            tv_name.setText(lists.get(position).getName());
            tv_phone.setText(lists.get(position).getPhone());
            return view;
        }
    }
}
