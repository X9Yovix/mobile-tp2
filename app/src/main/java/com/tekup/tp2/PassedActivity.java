package com.tekup.tp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PassedActivity extends AppCompatActivity {
    private TextView tvScorePA;
    private EditText etSmsPhoneNumber;
    private Button btnSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passed);

        tvScorePA = (TextView) findViewById(R.id.TvScorePA);
        double score = getIntent().getDoubleExtra("score", 0.0);
        tvScorePA.setText(String.valueOf(score));

        etSmsPhoneNumber = (EditText) findViewById(R.id.EtSmsPhoneNumber);
        btnSendSms = (Button) findViewById(R.id.BtnSendSmsPA);

        btnSendSms.setOnClickListener(v -> {
            Uri uri = Uri.parse("smsto:" + etSmsPhoneNumber.getText().toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtra("sms_body", String.format("Your score is %.2f", score));
            startActivity(intent);
        });
    }
}