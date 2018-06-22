package com.example.shubham.form;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText etname,etemail,etage;
RadioGroup radioGroup;
    SharedPreferences sharedPreferences;
RadioButton r,r1,r2;
Button disp;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname=findViewById(R.id.etname);
        sharedPreferences=getSharedPreferences("My Shared Preference",MODE_PRIVATE);
        etage=findViewById(R.id.etage);
        etemail=findViewById(R.id.etemail);
        radioGroup=findViewById(R.id.gender);
        disp=findViewById(R.id.disp);
        r1=findViewById(R.id.Bmale);
        r2=findViewById(R.id.Bfemale);
        String name,email,gender;
        int age;
        name=sharedPreferences.getString("name",null);
        email=sharedPreferences.getString("email",null);
        gender=sharedPreferences.getString("gender",null);
        age=sharedPreferences.getInt("age",0);
        if (name!=null)
            etname.setText(name);
        if(email!=null)
            etemail.setText(email);
        if(age!=0)
            etage.setText(""+age);
        if(gender!=null)
        {
            if(gender.equals(r1.getText().toString())){
                r1.setChecked(true);

            }
            else if(gender.equals(r2.getText().toString())){
                r2.setChecked(true);
            }
        }
        disp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r=findViewById(radioGroup.getCheckedRadioButtonId());
                Intent i= new Intent(MainActivity.this,DisplayActivity.class);
                i.putExtra("a",etname.getText().toString());
                i.putExtra("b",etemail.getText().toString());
                i.putExtra("c",r.getText().toString());
                i.putExtra("d",Integer.parseInt(etage.getText().toString()));
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",etname.getText().toString());
                editor.putString("email",etemail.getText().toString());
                editor.putString("gender",r.getText().toString());
                editor.putInt("age",Integer.parseInt(etage.getText().toString()));
                editor.commit();
                startActivity(i);
                finish();
                //add comment
            }
        });


    }



}
