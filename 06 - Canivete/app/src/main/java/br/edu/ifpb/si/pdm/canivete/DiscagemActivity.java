package br.edu.ifpb.si.pdm.canivete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DiscagemActivity extends AppCompatActivity {
    private TextView tvDiscagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discagem);

        this.tvDiscagem = (TextView) findViewById(R.id.tvDiscagem);

        Intent it = getIntent();

        String numero = it.getData().toString().replace("tel:", "    ");
        Log.i("PESSOA", numero);

        this.tvDiscagem.setText(numero);
    }
}
