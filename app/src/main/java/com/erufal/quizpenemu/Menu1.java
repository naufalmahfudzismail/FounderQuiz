package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;




public class Menu1 extends AppCompatActivity {



    EditText nama;
    TextView found;
    String names;
    Button quiz, materi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu1);


        initial();
        splash();

        findViewById(R.id.mainLayout).requestFocus();


        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names = nama.getText().toString();

                if(names.length()== 0 || names.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Masukan Nama",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent = new Intent();
                    intent.setClass(Menu1.this, rule.class);
                    intent.putExtra("Name", names);
                    Toast.makeText(getApplicationContext(), "Rules", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
            }
        });

    }

    public void Materi(View view)
    {
        Intent intent = new Intent(view.getContext(), Materi.class);
        Toast.makeText(getApplicationContext(),"Materi Kuis",Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }


    private void initial()
    {
        nama = (EditText) findViewById(R.id.namakamu);
        quiz = (Button) findViewById(R.id.Quiz);
        found = (TextView) findViewById(R.id.found);
       materi = (Button) findViewById(R.id.materi);
    }

    public void splash() {
        initial();
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(1000);

        found.setAnimation(animation);
        quiz.setAnimation(animation);
        materi.setAnimation(animation);


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
