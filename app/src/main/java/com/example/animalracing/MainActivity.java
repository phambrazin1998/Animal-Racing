package com.example.animalracing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
SeekBar sk1,sk2,sk3;
CheckBox ck1,ck2,ck3;
Button btnstart;
TextView txt1;
int money=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        sk1.setEnabled(false);
        sk3.setEnabled(false);
        sk2.setEnabled(false);
        txt1.setText(money+"");
        CountDownTimer countDownTimer= new CountDownTimer(60000,300) {
            @Override
            public void onTick(long millisUntilFinished) {
                int num=5;
                Random random=new Random();
                int one=random.nextInt(num);
                int two=random.nextInt(num);
                int three=random.nextInt(num);
                // Kiểm tra WIN
                if(sk1.getProgress()>= sk2.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Cat win",Toast.LENGTH_SHORT).show();
                    btnstart.setVisibility(View.VISIBLE);

                    //Kiểm tra đặt cược
                    if(ck1.isChecked())
                    {
                        money=money+10;
                        Toast.makeText(MainActivity.this,"AHihi",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        money=money-5;
                        Toast.makeText(MainActivity.this,"You Lose",Toast.LENGTH_SHORT).show();
                    }
                    txt1.setText(money+"");
                    EnableCheckBox();
                }
                if(sk2.getProgress()>= sk2.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Fish win",Toast.LENGTH_SHORT).show();
                    btnstart.setVisibility(View.VISIBLE);

                    //Kiểm tra đặt cược
                     if(ck2.isChecked())
                    {
                      money=money+10;
                      Toast.makeText(MainActivity.this,"You Win",Toast.LENGTH_SHORT).show();
                     }
                     else
                     {
                        money=money-5;
                     Toast.makeText(MainActivity.this,"You Lose",Toast.LENGTH_SHORT).show();
                     }
                     txt1.setText(money+"");
                    EnableCheckBox();
                }
                if(sk3.getProgress() >= sk3.getMax())
                {
                    this.cancel();
                    Toast.makeText(MainActivity.this,"Ele win",Toast.LENGTH_SHORT).show();
                    btnstart.setVisibility(View.VISIBLE);
                    //Kiểm tra đặt cược

                     if(ck3.isChecked())
                    {
                      money=money+5;
                      Toast.makeText(MainActivity.this,"You Win",Toast.LENGTH_SHORT).show();
                    }
                     else
                     {
                      money=money-5;
                     Toast.makeText(MainActivity.this,"You Lose",Toast.LENGTH_SHORT).show();
                    }
                     txt1.setText(money+"");
                    EnableCheckBox();
                }
                sk1.setProgress(sk1.getProgress()+one);
                sk2.setProgress(sk2.getProgress()+two);
                sk3.setProgress(sk3.getProgress()+three);
            }

            @Override
            public void onFinish() {

            }
        };
        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ck1.isChecked()||ck2.isChecked()||ck3.isChecked()) {
                    sk1.setProgress(0);
                    sk2.setProgress(0);
                    sk3.setProgress(0);
                    btnstart.setVisibility(View.INVISIBLE);
                    countDownTimer.start();
                    DisableCheckBox();
                }
                else
                {
                    Toast.makeText(MainActivity.this,"Chọn 1 trong e em đêy",Toast.LENGTH_SHORT).show();
                }
            }
        });
        ck1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //hủy checked của ck2,3
                    ck2.setChecked(false);
                    ck3.setChecked(false);
                }
            }
        });
        ck2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //hủy checked của ck1,3
                    ck1.setChecked(false);
                    ck3.setChecked(false);
                }
            }
        });
        ck3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    //hủy checked của ck1,2
                    ck2.setChecked(false);
                    ck1.setChecked(false);
                }
            }
        });
    }
    private void EnableCheckBox()
    {
        ck1.setEnabled(true);
        ck2.setEnabled(true);
        ck3.setEnabled(true);
    }
    private void DisableCheckBox()
    {
        ck1.setEnabled(false);
        ck2.setEnabled(false);
        ck3.setEnabled(false);
    }
    private void Anhxa()
    {
           txt1    =(TextView) findViewById(R.id.txt1);
           ck1     =(CheckBox) findViewById(R.id.ck1);
           ck2     =(CheckBox) findViewById(R.id.ck2);
           ck3     =(CheckBox) findViewById(R.id.ck3);
           sk1     =(SeekBar) findViewById(R.id.sk1);
           sk2     =(SeekBar) findViewById(R.id.sk2);
           sk3     =(SeekBar) findViewById(R.id.sk3);
           btnstart=(Button) findViewById(R.id.btnstart);
    }
}