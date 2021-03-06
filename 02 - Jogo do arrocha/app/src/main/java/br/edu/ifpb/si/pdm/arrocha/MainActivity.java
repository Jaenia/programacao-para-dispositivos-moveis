package br.edu.ifpb.si.pdm.arrocha;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tvMenor, tvMaior;
    private Button btChutar;
    private EditText etChute;
    private Arrocha jogo;

    public MainActivity(){
        this.jogo = new Arrocha();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvMenor = (TextView) findViewById(R.id.tvMenor);
        this.tvMaior = (TextView) findViewById(R.id.tvMaior);
        this.btChutar = (Button) findViewById(R.id.btChutar);
        this.etChute = (EditText) findViewById(R.id.etChute);

        this.btChutar.setOnClickListener(new BotaoListener());

        this.atualizaInterface();
    }

    private void atualizaInterface(){
        this.tvMenor.setText(Integer.toString(this.jogo.getMenor()));
        this.tvMaior.setText(Integer.toString(this.jogo.getMaior()));
    }

    private class BotaoListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Log.i("FOFO", MainActivity.this.jogo.toString());
            int chute;
            String mensagem;

            chute = Integer.parseInt(MainActivity.this.etChute.getText().toString());

            mensagem = jogo.jogar(chute);
            MainActivity.this.atualizaInterface();

            if(mensagem != null){
                AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
                dialogo.setTitle("Opaaa!!");
                dialogo.setMessage(mensagem);
                dialogo.setNeutralButton("OK", null);
                dialogo.show();
            }
        }
    }
}