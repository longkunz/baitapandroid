package com.hovietlong.tonghopbaivenha;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThayDoiHinh extends AppCompatActivity {
    //KHai bao view
    RadioButton rdoPig, droCat, rdoDog, rdoRabbit, rdoTdc;
    ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thay_doi_hinh);
        setControl();
        setEvent();
    }

    private void setEvent() {
        rdoPig.setOnCheckedChangeListener(ktCheck);
        droCat.setOnCheckedChangeListener(ktCheck);
        rdoDog.setOnCheckedChangeListener(ktCheck);
        rdoRabbit.setOnCheckedChangeListener(ktCheck);
        rdoTdc.setOnCheckedChangeListener(ktCheck);
    }

    CompoundButton.OnCheckedChangeListener ktCheck = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            switch (buttonView.getId()) {
                case R.id.rdoPig:
                    if (isChecked)
                        imgResult.setImageResource(R.drawable.pig);
                    break;
                case R.id.rdoCat:
                    if (isChecked)
                        imgResult.setImageResource(R.drawable.cat);
                    break;
                case R.id.rdoDog:
                    if (isChecked)
                        imgResult.setImageResource(R.drawable.dog);
                    break;
                case R.id.rdoRabbit:
                    if (isChecked)
                        imgResult.setImageResource(R.drawable.rabbit);
                    break;
                case R.id.rdoTdc:
                    if (isChecked)
                        imgResult.setImageResource(R.drawable.tdc);
                    break;
                default:
                    break;
            }
        }
    };

    private void setControl() {
        //Set control
        imgResult = findViewById(R.id.imgResult);
        rdoPig = findViewById(R.id.rdoPig);
        droCat = findViewById(R.id.rdoCat);
        rdoDog = findViewById(R.id.rdoDog);
        rdoRabbit = findViewById(R.id.rdoRabbit);
        rdoTdc = findViewById(R.id.rdoTdc);
    }
}