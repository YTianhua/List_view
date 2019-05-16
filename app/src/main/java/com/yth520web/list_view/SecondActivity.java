package com.yth520web.list_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {
    EditText t1;
    EditText t2;
    EditText t3;
    String s1;
    String s2;
    String s3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text1_view_layout);
       Intent intent=getIntent();
        t1=(EditText) findViewById(R.id.editText1);
        t2 =(EditText) findViewById(R.id.editText2);
        t3 = (EditText) findViewById(R.id.editText3);
        s1=intent.getStringExtra("e1");
        t1.setText(s1);
        s2=intent.getStringExtra("e2");
        t2.setText(s2);
        s3=intent.getStringExtra("e3");
        t3.setText(s3);
        Button button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=getIntent();
                t1=(EditText) findViewById(R.id.editText1);
                t2 =(EditText) findViewById(R.id.editText2);
                t3 = (EditText) findViewById(R.id.editText3);
                intent.putExtra("editText1",t1.getText().toString());
                intent.putExtra("editText2",t2.getText().toString());
                intent.putExtra("editText3",t3.getText().toString());
                setResult(1,intent);
                finish();
            }
        });

    }

}
