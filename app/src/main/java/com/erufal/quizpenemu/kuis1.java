package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class kuis1 extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    String name;
    String kelas;
    String nim;
    private int score = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali !",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis1);
        getSupportActionBar().setTitle("Soal 1");
        getSupportActionBar().setIcon(R.mipmap.founder);


        Initial();
        getValue();
        splash();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis1.this, kuis2.class);
                intent.putExtra("Name", name);
                intent.putExtra("Kelas", kelas);
                intent.putExtra("NIM", nim);
                intent.putExtra("Score",score -1 );
                intent.putExtra("Soal1", "A (Salah)(-1)");
                Toast.makeText(getApplicationContext(),"Masuk ke soal 2",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis1.this, kuis2.class);
                intent.putExtra("Name", name);
                intent.putExtra("Kelas", kelas);
                intent.putExtra("NIM", nim);
                intent.putExtra("Score",score + 4 );
                intent.putExtra("Soal1", "B (Benar)(+4)");
                Toast.makeText(getApplicationContext(),"Masuk ke soal 2",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis1.this, kuis2.class);
                intent.putExtra("Name", name);
                intent.putExtra("Kelas", kelas);
                intent.putExtra("NIM", nim);
                intent.putExtra("Score",score -1 );
                intent.putExtra("Soal1", "C (Salah)(-1)");
                Toast.makeText(getApplicationContext(),"Masuk ke soal 2",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(kuis1.this, kuis2.class);
                intent.putExtra("Name", name);
                intent.putExtra("Kelas", kelas);
                intent.putExtra("NIM", nim);
                intent.putExtra("Score", score-1 );
                intent.putExtra("Soal1", "D (Salah)(-1)");
                Toast.makeText(getApplicationContext(),"Masuk ke soal 2",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

    }

    public void getValue()
    {

        Intent a = getIntent();
        name  = a.getStringExtra("Name");
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
