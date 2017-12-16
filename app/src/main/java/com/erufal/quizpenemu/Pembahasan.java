package com.erufal.quizpenemu;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Pembahasan extends AppCompatActivity {


    String name;
    String kelas;
    String nim;
    String soal1, soal2, soal3, soal4, soal5, soal6, soal7, soal8, soal9, soal10;
    TextView txt1, txt2, txt3, txt4, txt5, txt6, txt7, txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15,
    txt16, txt17;
    Button menu, ulang, detail;

    int score2 = 0;
    private int score  = 0;

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
                System.exit(1);
            }
        }, 2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembahasan);
        getSupportActionBar().setTitle("Result");
        getSupportActionBar().setIcon(R.mipmap.founder);

        getValue();
        initial();
        splash();
        splash2();

        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int value = bundle.getInt("Score");
            score2 = score + value;
        }
        int score = bundle.getInt("Score");
        String values = String.valueOf(score);

            if (score >= 25)
            {
                txt5.setText(" A ");
                txt6.setText("Dengan Score : " +values);
                txt7.setText("Wow Keren, Kamu sudah menguasai Materi dengan sempurna");
            }
            else if(score >= 15)
            {
                txt5.setText(" B ");
                txt6.setText("Dengan Score : " +values);
                txt7.setText("Selamat , Kamu sudah menguasai Materi dengan baik");
            }
            else if(score >= 5)
            {
                txt5.setText(" C ");
                txt6.setText("Dengan Score : " +values);
                txt7.setText("Setidak nya kamu sudah mencoba , Kamu perlu belajar lagi");
            }

            else if(score >= 1)
            {
                txt5.setText(" D ");
                txt6.setText("Dengan Score : " +values);
                txt7.setTextColor(Color.RED);
                txt7.setText("Nilai kamu kurang, kamu harus belajar lagi");

            }
            else
            {
                txt5.setText(" E ");
                txt6.setText("Dengan Score : " +values);
                txt7.setTextColor(Color.RED);
                txt7.setText("Kamu gagal dalam Quiz ini, Seharus nya sekarang kamu sedang belajar");
            }

            txt1.setText(name);


        ulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();

                intent.setClass(Pembahasan.this, rule.class);

                intent.putExtra("Name", name);
                intent.putExtra("Kelas", kelas);
                intent.putExtra("NIM", nim);
                Toast.makeText(getApplicationContext(),"Rules",Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent();

                intent.setClass(Pembahasan.this, Menu1.class);
                Toast.makeText(getApplicationContext(),"Main Menu",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });

        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Pembahasan.this, Detail.class);
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
                intent.putExtra("Soal10",soal10);
                intent.putExtra("Score", score2);
                Toast.makeText(getApplicationContext(),"Detail Your Answer",Toast.LENGTH_SHORT).show();
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
        soal4 = a.getStringExtra("Soal4");
        soal5 = a.getStringExtra("Soal5");
        soal6 = a.getStringExtra("Soal6");
        soal7 = a.getStringExtra("Soal7");
        soal8 = a.getStringExtra("Soal8");
        soal9 = a.getStringExtra("Soal9");
        soal10 = a.getStringExtra("Soal10");

    }

    public void initial ()
    {
        txt1 = (TextView) findViewById(R.id.txt1);
        txt2 = (TextView) findViewById(R.id.txt2);
        txt3 = (TextView) findViewById(R.id.txt3);
        txt4 = (TextView) findViewById(R.id.txt4);
        txt5 = (TextView) findViewById(R.id.txt5);
        txt6 = (TextView) findViewById(R.id.txt6);
        txt7 = (TextView) findViewById(R.id.txt7);
        menu = (Button) findViewById(R.id.menu);
        ulang = (Button) findViewById(R.id.ulang);
        detail  = (Button) findViewById(R.id.detail);

    }

    public void splash() {
        getValue();
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(1000);

        txt5.startAnimation(animation);
        txt6.startAnimation(animation);
        txt7.startAnimation(animation);
        menu.setAnimation(animation);
        ulang.setAnimation(animation);

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
    public void splash2()
    {

        getValue();
        AlphaAnimation animation2 = new AlphaAnimation(0.0f, 1.0f);
        animation2.setDuration(2000);
        animation2.setStartOffset(2000);
        detail.startAnimation(animation2);

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
