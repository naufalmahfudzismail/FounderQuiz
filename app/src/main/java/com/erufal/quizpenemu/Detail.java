package com.erufal.quizpenemu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Detail extends AppCompatActivity {

    TextView txt8, txt9, txt10, txt11, txt12, txt13, txt14, txt15, txt16, txt17, txtscore;
    String soal1, soal2, soal3, soal4, soal5, soal6, soal7, soal8, soal9, soal10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setTitle("Detail Answers");

        initial();
        getValue();

        Bundle bundle = getIntent().getExtras();
        int score = bundle.getInt("Score");

        String values  = String.valueOf(score);

        txt8.setText("Soal 1 dengan Jawaban = "+soal1);
        txt9.setText("Soal 2 dengan Jawaban = "+soal2);
        txt10.setText("Soal 3 dengan Jawaban = "+soal3);
        txt11.setText("Soal 4  = "+soal4);
        txt12.setText("Soal 5 dengan Jawaban = "+soal5);
        txt13.setText("Soal 6 dengan Jawaban = "+soal6);
        txt14.setText("Soal 7 dengan Jawaban = "+soal7);
        txt15.setText("Soal 8 dengan Jawaban = "+soal8);
        txt16.setText("Soal 9 = "+soal9);
        txt17.setText("Soal 10 dengan Jawaban = "+soal10);
        txtscore.setText("Score Total  = "+values);
    }

    public void initial()
    {
        txt8 = (TextView) findViewById(R.id.txt8);
        txt9 = (TextView) findViewById(R.id.txt9);
        txt10 = (TextView) findViewById(R.id.txt10);
        txt11 = (TextView) findViewById(R.id.txt11);
        txt12 = (TextView) findViewById(R.id.txt12);
        txt13 = (TextView) findViewById(R.id.txt13);
        txt14 = (TextView) findViewById(R.id.txt14);
        txt15 = (TextView) findViewById(R.id.txt15);
        txt16 = (TextView) findViewById(R.id.txt16);
        txt17 = (TextView) findViewById(R.id.txt17);
        txtscore = (TextView)findViewById(R.id.txtscore);
    }

    public void getValue()
    {
        Intent a = getIntent();
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
}
