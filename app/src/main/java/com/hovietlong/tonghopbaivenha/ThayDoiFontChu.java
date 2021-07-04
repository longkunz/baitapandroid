package com.hovietlong.tonghopbaivenha;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static android.view.View.TEXT_ALIGNMENT_CENTER;

public class ThayDoiFontChu extends AppCompatActivity {
    //Khai bao view
    CheckBox chkBg, chkColor;
    RadioGroup rdoGroup;
    Button btnResult;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thay_doi_font_chu);
        setControl();
        setEvent();
    }

    private void setEvent() {
        btnResult.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
            @Override
            public void onClick(View v) {
                textResult.setText("FIT TDC");
                if (chkBg.isChecked())
                    textResult.setBackgroundColor(Color.RED);
                else
                    textResult.setBackgroundColor(Color.WHITE);
                if (chkColor.isChecked())
                    textResult.setTextColor(Color.YELLOW);
                else
                    textResult.setTextColor(Color.BLACK);

                int idRadio = rdoGroup.getCheckedRadioButtonId();
                switch (idRadio) {
                    case R.id.rdoLeft:
                        textResult.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_START);
                        break;
                    case R.id.rdoCenter:
                        textResult.setTextAlignment(TEXT_ALIGNMENT_CENTER);
                        break;
                    case R.id.rdoRight:
                        textResult.setTextAlignment(View.TEXT_ALIGNMENT_VIEW_END);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    private void setControl() {
        chkBg = findViewById(R.id.chkboxBg);
        chkColor = findViewById(R.id.chkboxTextColor);
        rdoGroup = findViewById(R.id.rdoTextAlign);
        btnResult = findViewById(R.id.btnShow);
        textResult = findViewById(R.id.result);
    }
}