package com.hovietlong.tonghopbaivenha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Edit_Player extends AppCompatActivity {
    //Khai bao view
    ImageView ivAvatar;
    EditText etGoal,etCountry;
    TextView tvName;
    Button btnOk, btnCancel;
    static int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit__player);
        setControl();
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        ivAvatar.setImageResource(bundle.getInt("Avatar",R.drawable.hungdung));
        etGoal.setText(bundle.getInt("Goal",0)+"");
        etCountry.setText(bundle.getString("Country",""));
        tvName.setText(bundle.getString("Name",""));
        index=bundle.getInt("index",0);
        setEvent();
    }

    private void setEvent() {
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("longlog", "gia tri index "+index);
                finish();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(Edit_Player.this,MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("Goal", etGoal.getText().toString());
                bundle.putString("Country",etCountry.getText().toString());
                bundle.putInt("index",index);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });
    }

    private void setControl() {
        ivAvatar=findViewById(R.id.ivAvatar);
        etGoal=findViewById(R.id.etGoal);
        etCountry=findViewById(R.id.etCountry);
        tvName=findViewById(R.id.tvTen);
        btnCancel=findViewById(R.id.btnCancel);
        btnOk=findViewById(R.id.btnOk);
    }
}