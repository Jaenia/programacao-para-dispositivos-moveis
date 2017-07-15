package br.edu.ifpb.si.pdm.usacanivete;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Visualiza: receber uma pessoa (nome, telefone  e calendar nascimento);
 * Compartilhamento: visualizar o texto compartilhado
 * Discagem: visualizar o número para discagem
 * Web: visualizar a página solicitada
 * */

public class MainActivity extends AppCompatActivity {
    private Button btNome, btCompartilhamento, btDiscagem, btWeb, btPessoa;
    private Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Criando a pessoa que será passada
        this.pessoa = new Pessoa("Jaenia", "98871-6103");
        Log.i("PESSOA", pessoa.getNome());

        this.btCompartilhamento = (Button) findViewById(R.id.btCompartilhamento);
        this.btDiscagem = (Button) findViewById(R.id.btDiscagem);
        this.btNome = (Button) findViewById(R.id.btNome);
        this.btWeb = (Button) findViewById(R.id.btWeb);
        this.btPessoa = (Button) findViewById(R.id.btPessoa);

        this.btCompartilhamento.setOnClickListener(new ClickBotao());
        this.btDiscagem.setOnClickListener(new ClickBotao());
        this.btNome.setOnClickListener(new ClickBotao());
        this.btWeb.setOnClickListener(new ClickBotao());
        this.btPessoa.setOnClickListener(new ClickBotao());
    }

    private class ClickBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            if (v.equals(btCompartilhamento)){
                Intent it = new Intent(Intent.ACTION_SEND);
                it.putExtra(Intent.EXTRA_TEXT, "Texto compartilhado!");
                it.setType("text/plain");
                startActivity(it);
            }else if (v.equals(btDiscagem)){
                Uri uri = Uri.parse("tel:36121392");
                Intent it = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(it);
            }else if (v.equals(btNome)){
                Intent it = new Intent("VISUALIZA_NOME");
                it.putExtra("NOME", "O nome!");
                startActivity(it);
            }else if (v.equals(btWeb)){
                Uri uri = Uri.parse("http://pdm.valeriacavalcanti.com.br");
                Intent it = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(it);
            }else if (v.equals(btPessoa)){
                Intent it = new Intent("VISUALIZA_NOME");
                Log.i("PESSOA", "Intent " + pessoa.getNome());
                it.putExtra("PESSOA", MainActivity.this.pessoa);
                startActivity(it);
            }
        }
    }
}
