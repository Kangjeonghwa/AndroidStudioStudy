package org.example.mysummary1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class CommentitemView extends LinearLayout {
    TextView textView;  //name
    TextView textView2; //comment
    public CommentitemView(Context context) {
        super(context);

        init(context);
    }

    public CommentitemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.comment_item_view,this,true);

        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
    }

    public void setName(String name){
        textView.setText(name);
    }
    public void setComment(String comment){
        textView2.setText(comment);
    }
}
