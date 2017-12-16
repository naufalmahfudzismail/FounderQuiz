package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class kuis4 extends AppCompatActivity {

    String name;
    String kelas;
    String nim, text;
    String soal1, soal2, soal3;
    private int score = 0;
    int score2;

    CheckBox btn1;
    CheckBox btn2;
    CheckBox btn3;
    CheckBox btn4;

    Button next;


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali ke soal 3",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis4);
        getSupportActionBar().setTitle("Soal 4");

        getValue();
        initial();

        splash();
        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int value = bundle.getInt("Score");
            score2 = score + value;
        }




        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(kuis4.this, kuis5.class);
                intent.putExtra("Name", name);
                intent.putExtra("Soal1", soal1);
                intent.putExtra("Soal2", soal2);
                intent.putExtra("Soal3", soal3);
                Toast.makeText(getApplicationContext(), "Masuk ke soal 5", Toast.LENGTH_SHORT).show();
                if (btn1.isChecked() && btn3.isChecked())
                {
                    if(btn2.isChecked())
                    {
                        score2 -= 1;
                        intent.putExtra("Soal4","1,2,3,4  (Salah)(-1)");
                    }
                    
                    else if (btn4.isChecked())
                    {
                        score2 -= 1;
                        intent.putExtra("Soal4","1,2,3,4  (Salah)(-1)");
                    }

                    else
                    {
                        score2 += 4;
                        intent.putExtra("Soal4","1,3,4 (Benar)(+4)");
                    }
                }
                else if (btn2.isChecked())
                {

                    score2 -= 1;
                    intent.putExtra("Soal4","2 (Salah)(-1)");
                }
                else
                {
                    score2 -= 1;
                    intent.putExtra("Soal4","(Salah)(-1)");
                }

                intent.putExtra("Score",score2);

            startActivity(intent);
        }
        });
    }

    public void getValue()
    {

        Intent a = getIntent();
        name  = a.getStringExtra("Name");
        soal1 = a.getStringExtra("Soal1");
        soal2 = a.getStringExtra("Soal2");
        soal3 = a.getStringExtra("Soal3");

    }

    public void initial()
    {
        btn1 = (CheckBox) findViewById(R.id.btn1_soal1);
        btn2 = (CheckBox) findViewById(R.id.btn2_soal1);
        btn3 = (CheckBox) findViewById(R.id.btn3_soal1);
        btn4 = (CheckBox) findViewById(R.id.btn4_soal1);
        next = (Button) findViewById(R.id.next);
    }

    public void splash() {
        initial();
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(1000);

        btn1.setAnimation(animation);
        btn2.setAnimation(animation);
        btn3.setAnimation(animation);
        btn4.setAnimation(animation);
        next.setAnimation(animation);


        Thread timerThread = new Thread()
        {

            public void run()
            {
                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        };
        timerThread.start();

    }
}
