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
import android.widget.TextView;
import android.widget.Toast;

public class kuis3 extends AppCompatActivity {

    String name;
    String kelas;
    String nim;
    String soal1;
    String soal2;
    private int score = 0;
    int score2;
    RadioButton select;
    RadioButton btn1;
    RadioButton btn2;
    RadioButton btn3;
    RadioButton btn4;
    RadioGroup Group;
    Button next;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK) {

            Toast.makeText(getApplicationContext(),"Kamu tak bisa kembali ke soal 2",Toast.LENGTH_SHORT).show();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuis3);
        getSupportActionBar().setTitle("Soal 3");

        Initial();
        getValue();
        splash();

        Bundle bundle = getIntent().getExtras();
        if ( bundle != null) {
            int value = bundle.getInt("Score");
            score2 = score + value;
        }
        Group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // TODO Auto-generated method stub
                if (btn1.isChecked() || btn2.isChecked() || btn3.isChecked()
                        || btn4.isChecked()) {
                    next.setVisibility(View.VISIBLE);

                }
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(kuis3.this, kuis4.class);
                switch (Group.getCheckedRadioButtonId()) {
                    case R.id.btn1_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1",soal1);
                        intent.putExtra("Soal2",soal2);
                        intent.putExtra("Soal3","A (Salah)(-1)");
                        intent.putExtra("Score", score2 -1 );
                        break;
                    case R.id.btn2_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1",soal1);
                        intent.putExtra("Soal2",soal2);
                        intent.putExtra("Soal3","B (Salah)(-1)");
                        intent.putExtra("Score", score2 -1);
                        break;
                    case R.id.btn3_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1",soal1);
                        intent.putExtra("Soal2",soal2);
                        intent.putExtra("Soal3","C (Benar)(+4)");
                        intent.putExtra("Score", score2 +4);
                        break;
                    case R.id.btn4_soal1:
                        intent.putExtra("Name", name);
                        intent.putExtra("Soal1",soal1);
                        intent.putExtra("Soal2",soal2);
                        intent.putExtra("Soal3","D (Salah)(-1)");
                        intent.putExtra("Score", score2 -1);
                        break;

                    default:
                        break;



                }
                Toast.makeText(getApplicationContext(),"Masuk ke soal 4",Toast.LENGTH_SHORT).show();
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


    }
    public void Initial()
    {
        btn1 = (RadioButton) findViewById(R.id.btn1_soal1);
        btn2 = (RadioButton) findViewById(R.id.btn2_soal1);
        btn3 = (RadioButton) findViewById(R.id.btn3_soal1);
        btn4 = (RadioButton) findViewById(R.id.btn4_soal1);
        Group = (RadioGroup) findViewById(R.id.group);
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
