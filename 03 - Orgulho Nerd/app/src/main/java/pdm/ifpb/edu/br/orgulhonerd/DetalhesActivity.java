package pdm.ifpb.edu.br.orgulhonerd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

public class DetalhesActivity extends AppCompatActivity {
    private Saga saga;
    private ImageView ivDetalhes;
    private TextView tvTitulo, tvDescricao, tvCurtidas;
    private RatingBar ratingBar;
    private Button btCurtir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        ivDetalhes = (ImageView) findViewById(R.id.ivDetalhes);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        tvDescricao = (TextView) findViewById(R.id.tvDescricao);
        tvCurtidas = (TextView) findViewById(R.id.tvCurtidas);
        btCurtir = (Button) findViewById(R.id.btCurtir);
        this.ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        Intent it = getIntent();
        this.saga = (Saga) it.getSerializableExtra("SAGA");

        this.tvTitulo.setText(this.saga.getTitulo());
        this.ivDetalhes.setImageResource(this.saga.getImageLocal());
        this.ratingBar.setRating(this.saga.getEstrelas());
        this.tvCurtidas.setText(Integer.toString(this.saga.getCurtidas()));
        this.tvDescricao.setText(this.saga.getDescricao());
        this.tvDescricao.setMovementMethod(new ScrollingMovementMethod());

        this.btCurtir.setOnClickListener(new BotaoListener());

    }

    private class BotaoListener implements View.OnClickListener {
        String curtida;
        @Override
        public void onClick(View v) {
            //this.comentario = DetalhesActivity.this.tvCurtidas.toString();
            DetalhesActivity.this.saga.adicionarCurtida();
            DetalhesActivity.this.atualizarCurtidas();
        }
    }

    private void atualizarCurtidas() {
       DetalhesActivity.this.tvCurtidas.setText(Integer.toString(this.saga.getCurtidas()));
    }
}

