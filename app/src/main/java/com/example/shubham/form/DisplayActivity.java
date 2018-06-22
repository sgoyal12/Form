package com.example.shubham.form;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {
TextView tvname,tvemail,tvgender,tvage;
int d;
String a,b,c;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        tvname=findViewById(R.id.dname);
        tvemail=findViewById(R.id.demail);
        tvgender=findViewById(R.id.dgender);
        tvage=findViewById(R.id.dage);
        Intent i=getIntent();


        a=i.getStringExtra("a");
        b=i.getStringExtra("b");
        c=i.getStringExtra("c");
        d=i.getIntExtra("d",0);
        tvname.setText(tvname.getText().toString()+" "+a);
        tvemail.setText(tvemail.getText().toString()+" "+b);
        tvgender.setText(tvgender.getText().toString()+" "+c);
        tvage.setText(tvage.getText().toString()+" "+d);
    }
}
