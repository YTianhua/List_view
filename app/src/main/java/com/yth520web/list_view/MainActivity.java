package com.yth520web.list_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuBuilder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Method;

public class MainActivity extends AppCompatActivity {

    EditText editText1;
    EditText editText2;
    EditText editText3;
    String e1;
    String e2;
    String e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public void onActivityResult (int requestCode,int resultCode,Intent data){
                if(requestCode==1 && resultCode==1) {

                    editText1 =(EditText)findViewById(R.id.e1);
                    editText2 =(EditText)findViewById(R.id.e2);
                    editText3 =(EditText)findViewById(R.id.e3);

                    String s1= data.getStringExtra("editText1");
                    String s2= data.getStringExtra("editText2");
                    String s3= data.getStringExtra("editText3");
                    editText1.setText(s1);
                    editText2.setText(s2);
                    editText3.setText(s3);

        }
    }
    public void onClick_main(View view){
        editText1 =(EditText)findViewById(R.id.e1);
        editText2 =(EditText)findViewById(R.id.e2);
        editText3 =(EditText)findViewById(R.id.e3);
        e1=editText1.getText().toString();
        e2= editText2.getText().toString();
        e3=editText3.getText().toString();

        Intent intent= new Intent(MainActivity.this,SecondActivity.class);
        intent.putExtra("e1",e1);
        intent.putExtra("e2",e2);
        intent.putExtra("e3",e3);
        startActivityForResult(intent,1);
    }

//菜单

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
     switch (item.getItemId()){
     }
     return true;
    }


//显示菜单图标的方法！！！！！！！！！
    //利用反射机制调用MenuBuilder的setOptionalIconsVisiable为true，给菜单设置图标
    //同时让菜单显示文字
    //备注：setOptionalIconsVisiable方法无法直接重写
    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        if(menu!=null){
            if(menu.getClass().getSimpleName().equalsIgnoreCase("MenuBuilder")){
                try{
                    Method method = menu.getClass().getDeclaredMethod("setOptionalIconsVisible",Boolean.TYPE);
                    method.setAccessible(true);
                    method.invoke(menu,true);
                }
                catch (Exception e){}
            }
        }
        return super.onMenuOpened(featureId, menu);
    }
    //@Override
    //onOptionItemSelected
}

