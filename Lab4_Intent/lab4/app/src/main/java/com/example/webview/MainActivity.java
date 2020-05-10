package com.example.webview;


import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        url= (EditText) findViewById(R.id.url);

    }
    public void toweb(View source){
        Intent intent=new Intent();
        //跳一个系统的视图
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url.getText().toString()));
        Intent choose=Intent.createChooser(intent,"选择浏览器");
        startActivity(choose);
    }
}
