package org.example.mylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingerAdapter adapter;
    EditText editText;
    EditText editText2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText) findViewById(R.id.editText);
        editText2=(EditText) findViewById(R.id.editText2);

        ListView listView=(ListView) findViewById(R.id.listview);

        adapter=new SingerAdapter();
        adapter.addItem(new SingerItem("소녀시대","010-1000-1000"));
        adapter.addItem(new SingerItem("르세라핌","010-2000-2000"));
        adapter.addItem(new SingerItem("에스파","010-3000-3000"));
        adapter.addItem(new SingerItem("엔믹스","010-4000-4000"));
        adapter.addItem(new SingerItem("여자아이들","010-5000-5000"));

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SingerItem item=(SingerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(), "선택: "+item.getName(), Toast.LENGTH_SHORT).show();

            }
        });

        Button button=(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=editText.getText().toString();
                String mobile=editText2.getText().toString();

                adapter.addItem(new SingerItem(name,mobile));
                adapter.notifyDataSetChanged();
            }
        });
    }

    class SingerAdapter extends BaseAdapter{
        ArrayList<SingerItem> items=new ArrayList<SingerItem>();


        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SingerItemView view=null;
            if(convertView==null){
                view=new SingerItemView(getApplicationContext());
            }else{
                view=(SingerItemView) convertView;
            }

            SingerItem item=items.get(position);

            view.setName(item.getName());
            view.setMobile(item.getMobile());



            return view;
        }
    }
}