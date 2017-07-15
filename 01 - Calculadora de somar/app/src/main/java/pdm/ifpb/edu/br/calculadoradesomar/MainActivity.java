package pdm.ifpb.edu.br.calculadoradesomar;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText campo1, campo2;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.campo1 = (EditText) findViewById(R.id.etValor1);
        this.campo2 = (EditText) findViewById(R.id.etValor2);
        this.botao = (Button) findViewById(R.id.btSomar);

        this.botao.setOnClickListener(new BotaoListener());
    }

    private class BotaoListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            int valor1, valor2, resultado;

            valor1 = Integer.parseInt(MainActivity.this.campo1.getText().toString());
            valor2 = Integer.parseInt(MainActivity.this.campo2.getText().toString());

            resultado = valor1 + valor2;

            AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
            dialogo.setTitle("Resultado");
            dialogo.setMessage("Soma: " + resultado);
            dialogo.setNeutralButton("OK", null);
            dialogo.show();
        }
    }
}
