package org.example.mytoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast= Toast.makeText(getApplicationContext(), "위치가 바뀐 토스트", Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP| Gravity.LEFT,10,200);
                toast.show();
            }
        });

        Button button2 = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.toastborder,(ViewGroup) findViewById(R.id.toast_layout_root));

                TextView text=(TextView)layout.findViewById(R.id.text);
                text.setText("모양을 바꾼 토스트");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER, 0,-100);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(layout);

                toast.show();
            }
        });
    }
}