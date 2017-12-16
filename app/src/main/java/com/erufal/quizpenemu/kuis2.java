package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class kuis2 extends AppCompatActivity {


    String name;
    String kelas;
    String nim;
    String soal1;
    private int score = 0;
    int score2;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali ke soal 1",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis2);
        getSupportActionBar().setTitle("Soal 2");

        Initial();
        getValue();
        splash();

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int value = bundle.getInt("Score");
            score2 = score + value;
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setClass(kuis2.this, kuis3.class);
                intent.putExtra("Name", name);
                intent.putExtra("Score",score2 -1 );
                intent.putExtra("Soal1",soal1);
                intent.putExtra("Soal2","A (Salah)(-1)");
                Toast.makeText(getApplicationContext(),"Masuk ke soal 3",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis2.this, kuis3.class);
                intent.putExtra("Name", name);
                intent.putExtra("Soal1",soal1);
                intent.putExtra("Soal2","B (Salah)(-1)");
                intent.putExtra("Score",score2-1);
                Toast.makeText(getApplicationContext(),"Masuk ke soal 3",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis2.this, kuis3.class);
                intent.putExtra("Name", name);
                intent.putExtra("Soal1",soal1);
                intent.putExtra("Soal2","C (Salah)(-1)");
                intent.putExtra("Score",score2-1);
                Toast.makeText(getApplicationContext(),"Masuk ke soal 3",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis2.this, kuis3.class);
                intent.putExtra("Name", name);
                intent.putExtra("Soal1",soal1);
                intent.putExtra("Soal2","D (Benar)(+4)");
                intent.putExtra("Score",score2 + 4);
                Toast.makeText(getApplicationContext(),"Masuk ke soal 3",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });


    }

    public void getValue()
    {

        Intent a = getIntent();

        name  = a.getStringExtra("Name");
        soal1 =  a.getStringExtra("Soal1");


    }
    public void Initial()
    {
        btn1 = (Button) findViewById(R.id.btn1_soal1);
        btn2 = (Button) findViewById(R.id.btn2_soal1);
        btn3 = (Button) findViewById(R.id.btn3_soal1);
        btn4 = (Button) findViewById(R.id.btn4_soal1);
    }
    public void splash() {
        Initial();
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(1000);

        btn1.setAnimation(animation);
        btn2.setAnimation(animation);
        btn3.setAnimation(animation);
        btn4.setAnimation(animation);


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
