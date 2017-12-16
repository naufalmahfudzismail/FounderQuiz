package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class kuis8 extends AppCompatActivity {
    String name;
    String kelas;
    String nim;
    String soal1, soal2, soal3, soal4, soal5, soal6, soal7;
    private int score = 0;
    int score2;
    RadioButton btn1;
    RadioButton btn2;
    RadioButton btn3;
    RadioButton btn4;
    RadioGroup group;
    Button next;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali ke soal 8",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis8);
        getSupportActionBar().setTitle("Soal 8");

        Initial();
        getValue();
        splash();

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (btn1.isChecked() || btn2.isChecked()
                        || btn3.isChecked() || btn4.isChecked()) {
                    next.setVisibility(View.VISIBLE);
                }
            }
        });

        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int value = bundle.getInt("Score");
            score2 = score + value;
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(kuis8.this, kuis9.class);
                switch (group.getCheckedRadioButtonId()) {
                    case R.id.btn1_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1", soal1);
                        intent.putExtra("Soal2", soal2);
                        intent.putExtra("Soal3", soal3);
                        intent.putExtra("Soal4", soal4);
                        intent.putExtra("Soal5", soal5);
                        intent.putExtra("Soal6", soal6);
                        intent.putExtra("Soal7", soal7);
                        intent.putExtra("Soal8", "A (Salah)(-1)");
                        intent.putExtra("Score", score2 -1 );
                        break;
                    case R.id.btn2_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1", soal1);
                        intent.putExtra("Soal2", soal2);
                        intent.putExtra("Soal3", soal3);
                        intent.putExtra("Soal4", soal4);
                        intent.putExtra("Soal5", soal5);
                        intent.putExtra("Soal6", soal6);
                        intent.putExtra("Soal7", soal7);
                        intent.putExtra("Soal8", "B (Salah)(-1)");
                        intent.putExtra("Score", score2 -1);
                        break;
                    case R.id.btn3_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1", soal1);
                        intent.putExtra("Soal2", soal2);
                        intent.putExtra("Soal3", soal3);
                        intent.putExtra("Soal4", soal4);
                        intent.putExtra("Soal5", soal5);
                        intent.putExtra("Soal6", soal6);
                        intent.putExtra("Soal7", soal7);
                        intent.putExtra("Soal8", "C (Salah)(-1)");
                        intent.putExtra("Score", score2 -1);
                        break;
                    case R.id.btn4_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1", soal1);
                        intent.putExtra("Soal2", soal2);
                        intent.putExtra("Soal3", soal3);
                        intent.putExtra("Soal4", soal4);
                        intent.putExtra("Soal5", soal5);
                        intent.putExtra("Soal6", soal6);
                        intent.putExtra("Soal7", soal7);
                        intent.putExtra("Soal8", "D (Benar)(+4)");
                        intent.putExtra("Score", score2 +4);
                        break;

                    default:
                        break;
                }
                Toast.makeText(getApplicationContext(),"Masuk ke soal 9",Toast.LENGTH_SHORT).show();
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
    }
    public void Initial()
    {
        btn1 = (RadioButton) findViewById(R.id.btn1_soal1);
        btn2 = (RadioButton) findViewById(R.id.btn2_soal1);
        btn3 = (RadioButton) findViewById(R.id.btn3_soal1);
        btn4 = (RadioButton) findViewById(R.id.btn4_soal1);
        group = (RadioGroup) findViewById(R.id.group);
        next = (Button) findViewById(R.id.next);
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
