package br.edu.ifpb.si.pdm.canivete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {
    private TextView tvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        this.tvWeb = (TextView) findViewById(R.id.tvWeb);

        Intent it = getIntent();

        String url = it.getData().toString();
        Log.i("PESSOA", url);

        this.tvWeb.setText(url);
    }
}
