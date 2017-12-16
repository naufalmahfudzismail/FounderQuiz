package com.erufal.quizpenemu;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class IsiMateri extends AppCompatActivity {
    private TextView tvDataReceived;
    private ImageView tvDataReceived1;
    private TextView tvDataReceived2;
    private TextView tvDataReceived3;
    private TextView tvDataReceived4;
    private TextView tvDataReceived5;
    private TextView tvDataReceived6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isi_materi);
        getSupportActionBar().setTitle("Keterangan");



        tvDataReceived = (TextView) findViewById(R.id.tv_data_received);
        tvDataReceived1 = (ImageView) findViewById(R.id.img_item_photo);
        tvDataReceived2 = (TextView) findViewById(R.id.tv_item_remarks);
        tvDataReceived3 = (TextView) findViewById(R.id.tgl);
        tvDataReceived4 = (TextView) findViewById(R.id.cont);
        tvDataReceived5 = (TextView) findViewById(R.id.bio);
        tvDataReceived6 = (TextView) findViewById(R.id.nama);



        Intent intent = getIntent();
        tvDataReceived2.setText(intent.getStringExtra("Remarks"));
        tvDataReceived.setText(intent.getStringExtra("Name"));
        tvDataReceived6.setText(intent.getStringExtra("Name"));
        tvDataReceived3.setText(intent.getStringExtra("Tgl"));
        tvDataReceived4.setText(intent.getStringExtra("Cont"));
        tvDataReceived5.setText(intent.getStringExtra("Bio"));
        getSupportActionBar().setTitle(intent.getStringExtra("Name"));
        Glide.with(IsiMateri.this)
                .load(intent.getStringExtra("Photo"))
                .override(100, 100)
                .crossFade()
                .into(tvDataReceived1);
    }

}
