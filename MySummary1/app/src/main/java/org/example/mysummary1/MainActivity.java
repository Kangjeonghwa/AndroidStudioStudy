package org.example.mysummary1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button likeButton, hateButton, writeButton, viewAllButton;
    TextView likeCountView, hateCountView;
    int likeCount=0,hateCount=0;
    RatingBar ratingBar;
    TextView outputView;

    boolean likeState=false;
    boolean hateState=false;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(likeState){
                    decrLikeCount();
                }else {
                    incrLikeCount();
                }

                likeState=!likeState;
            }
        });
        likeCountView = (TextView) findViewById(R.id.likeCountView);
        hateButton = (Button) findViewById(R.id.hateButton);
        hateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hateState){
                    decrHateCount();
                }else {
                    incrHateCount();
                }

                hateState=!hateState;
            }
        });
        hateCountView = (TextView) findViewById(R.id.hateCountView);

        listView=(ListView) findViewById(R.id.listView);
        CommentAdapter adapter=new CommentAdapter();
        adapter.addItem(new CommentItem("kym71**", "적당히 재미있었다. 오랜만에 잠 안오는 영화 봤네요."));
        adapter.addItem(new CommentItem("qhak****", "최고에요 강동원 하정우 최고"));
        adapter.addItem(new CommentItem("fhte****", "넘 만족했던 영화였어요~~배우들도 굿~~!!"));


        listView.setAdapter(adapter);

        writeButton = (Button) findViewById(R.id.writingComent);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "작성하기", Toast.LENGTH_SHORT).show();
                showCommentWriteActivity();
            }
        });
        viewAllButton =(Button) findViewById(R.id.viewAllButton);
        viewAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "모두보기", Toast.LENGTH_SHORT).show();
            }
        });
    }
    class CommentAdapter extends BaseAdapter{
        ArrayList<CommentItem> items=new ArrayList<CommentItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(CommentItem item){
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
            CommentitemView view=null;
            if(convertView==null){
               view= new CommentitemView(getApplicationContext());
            }else{
                view=(CommentitemView) view;
            }


            CommentItem item=items.get(position);

            view.setName(item.getName());
            view.setComment(item.getComment());


            return view;
        }
    }

    public void incrLikeCount(){
        likeCount+=1;
        likeCountView.setText(String.valueOf(likeCount));
        if(hateCount>0){
            hateCount-=1;
            hateCountView.setText(String.valueOf(hateCount));
            hateState=!hateState;
        }

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);
    }
    public void decrLikeCount(){
        likeCount-=1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.thumbs_up_selector);
    }
    public void incrHateCount(){
        hateCount+=1;
        hateCountView.setText(String.valueOf(hateCount));
        if(likeCount>0){
            likeCount-=1;
            likeCountView.setText(String.valueOf(likeCount));
            likeState=!likeState;
        }

        hateButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);
    }
    public void decrHateCount(){
        hateCount-=1;
        hateCountView.setText(String.valueOf(hateCount));

        hateButton.setBackgroundResource(R.drawable.thumbs_down_selector);
    }
    public void showCommentWriteActivity(){
        //float rating=ratingBar.getRating();

        Intent intent = new Intent(getApplicationContext(),CommentWriteActivity.class);
        //intent.putExtra("rating",rating);
        startActivityForResult(intent, 101);

    }
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if(requestCode==101){
            if(intent!=null){
                String contents=intent.getStringExtra("contents");
                outputView.setText(contents);
            }
        }

    }
}