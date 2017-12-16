package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class kuis10 extends AppCompatActivity {
    String name;
    String kelas;
    String nim;
    String soal1, soal2, soal3, soal4, soal5, soal6, soal7, soal8, soal9;
    private int score = 0;
    int score2;
    Button next;
    EditText jawaban;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali ke soal 9",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis10);
        getSupportActionBar().setTitle("Soal 10");

        getValue();
        initial();
        splash();

        findViewById(R.id.mainLayout).requestFocus();

        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int value = bundle.getInt("Score");
            score2 = score + value;
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String answer = jawaban.getText().toString();
                if (answer.equalsIgnoreCase("Andy Rubin")|| answer.equalsIgnoreCase(" Andy Rubin "))
                {
                    Intent intent = new Intent();
                    intent.setClass(kuis10.this, Pembahasan.class);
                    intent.putExtra("Name", name);
                    intent.putExtra("Soal1", soal1);
                    intent.putExtra("Soal2", soal2);
                    intent.putExtra("Soal3", soal3);
                    intent.putExtra("Soal4", soal4);
                    intent.putExtra("Soal5", soal5);
                    intent.putExtra("Soal6", soal6);
                    intent.putExtra("Soal7", soal7);
                    intent.putExtra("Soal8", soal8);
                    intent.putExtra("Soal9", soal9);
                    intent.putExtra("Soal10",answer+" (Benar)(+4)");
                    intent.putExtra("Score", score2 + 4);
                    Toast.makeText(getApplicationContext(),"Selesai",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent();
                    intent.setClass(kuis10.this, Pembahasan.class);
                    intent.putExtra("Name", name);
                    intent.putExtra("Soal1", soal1);
                    intent.putExtra("Soal2", soal2);
                    intent.putExtra("Soal3", soal3);
                    intent.putExtra("Soal4", soal4);
                    intent.putExtra("Soal5", soal5);
                    intent.putExtra("Soal6", soal6);
                    intent.putExtra("Soal7", soal7);
                    intent.putExtra("Soal8", soal8);
                    intent.putExtra("Soal9", soal9);
                    intent.putExtra("Soal10",answer+" (Salah)(-1)");
                    intent.putExtra("Score", score2 - 1);
                    Toast.makeText(getApplicationContext(),"Selesai",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
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
        soal4 = a.getStringExtra("Soal4");
        soal5 = a.getStringExtra("Soal5");
        soal6 = a.getStringExtra("Soal6");
        soal7 = a.getStringExtra("Soal7");
        soal8 = a.getStringExtra("Soal8");
        soal9 = a.getStringExtra("Soal9");

    }

    public void initial()
    {
        next = (Button) findViewById(R.id.next);
        jawaban = (EditText) findViewById(R.id.jawaban);
    }
    public void splash() {
        initial();
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(1000);

        jawaban.setAnimation(animation);
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
