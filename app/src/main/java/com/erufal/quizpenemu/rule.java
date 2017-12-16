package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import android.widget.Toast;

public class rule extends AppCompatActivity {

    String name;
    String kelas;
    String nim;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule);
        getSupportActionBar().setTitle("Peraturan Kuis");
        getValue();
        splash();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(rule.this, kuis1.class);
                intent.putExtra("Name", name);
                intent.putExtra("Kelas", kelas);
                intent.putExtra("NIM", nim);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Mulai KUIS !",Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void getValue()
    {

        Intent a = getIntent();
        name  = a.getStringExtra("Name");
        kelas = a.getStringExtra("Kelas");
        nim = a.getStringExtra("NIM");

    }
    public void splash() {
        next = (Button) findViewById(R.id.next);
        AlphaAnimation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(3000);
        animation.setStartOffset(3000);

        next.setAnimation(animation);

        Thread timerThread = new Thread()
        {

            public void run()
            {
                try
                {
                    sleep(5000);
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
