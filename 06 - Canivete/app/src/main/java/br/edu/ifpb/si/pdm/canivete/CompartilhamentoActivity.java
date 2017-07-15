package br.edu.ifpb.si.pdm.canivete;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class CompartilhamentoActivity extends AppCompatActivity {
    private TextView tvCompartilhamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compartilhamento);

        this.tvCompartilhamento = (TextView) findViewById(R.id.tvCompartilhamento);

        Intent it = getIntent();

        String texto = it.getStringExtra(Intent.EXTRA_TEXT);
        Log.i("PESSOA", texto);

        this.tvCompartilhamento.setText(texto);

    }
}
