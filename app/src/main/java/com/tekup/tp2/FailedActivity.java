package com.tekup.tp2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class FailedActivity extends AppCompatActivity {
    private TextView TvScoreFA;

    private EditText etSmsPhoneNumber;
    private Button btnSendSms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_failed);
        TvScoreFA = (TextView) findViewById(R.id.TvScoreFA);
        double score = getIntent().getDoubleExtra("score", 0.0);
        TvScoreFA.setText(String.valueOf(score));

        etSmsPhoneNumber = (EditText) findViewById(R.id.EtSmsPhoneNumber);
        btnSendSms = (Button) findViewById(R.id.BtnSendSmsFA);

        btnSendSms.setOnClickListener(v -> {
            Uri uri = Uri.parse("smsto:" + etSmsPhoneNumber.getText().toString());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.putExtra("sms_body", String.format("Your score is %.2f", score));
            startActivity(intent);
        });
    }
}