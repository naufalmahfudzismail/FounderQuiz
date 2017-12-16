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

public class kuis5 extends AppCompatActivity {

    String name;
    String kelas;
    String nim;
    String soal1, soal2, soal3, soal4;
    private int score = 0;
    int score2;
    Button next;
    EditText jawaban;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali ke soal 4",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis5);
        getSupportActionBar().setTitle("Soal 5");

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
                if (answer.equalsIgnoreCase("Al-Khwarizmi") ||
                        answer.equalsIgnoreCase("Al - Khwarizmi") ||
                        answer.equalsIgnoreCase("Al Khwarizmi") )
                {
                    Intent intent = new Intent();
                    intent.setClass(kuis5.this, kuis6.class);
                    intent.putExtra("Name", name);
                    intent.putExtra("Score", score2 + 4);
                    intent.putExtra("Soal1", soal1);
                    intent.putExtra("Soal2", soal2);
                    intent.putExtra("Soal3", soal3);
                    intent.putExtra("Soal4", soal4);
                    intent.putExtra("Soal5", answer+" (Benar)(+4)");
                    Toast.makeText(getApplicationContext(),"Masuk ke soal 6",Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                 }
                else
                {
                    Intent intent = new Intent();
                    intent.setClass(kuis5.this, kuis6.class);
                    intent.putExtra("Name", name);
                    intent.putExtra("Soal1", soal1);
                    intent.putExtra("Soal2", soal2);
                    intent.putExtra("Soal3", soal3);
                    intent.putExtra("Soal4", soal4);
                    intent.putExtra("Soal5", answer+" (Salah)(-1)");
                    intent.putExtra("Score", score2 - 1);
                    Toast.makeText(getApplicationContext(),"Masuk ke soal 6",Toast.LENGTH_SHORT).show();
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
