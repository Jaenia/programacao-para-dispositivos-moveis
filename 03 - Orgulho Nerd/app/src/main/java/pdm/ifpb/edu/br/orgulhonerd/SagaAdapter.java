package pdm.ifpb.edu.br.orgulhonerd;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jaeni on 02/06/2017.
 */

public class SagaAdapter extends ArrayAdapter{
    private List<Saga> sagas;
    private Activity context;

    public SagaAdapter(Activity context, List<Saga> sagas){
        super(context, R.layout.item_saga, sagas);

        this.context = context;
        this.sagas = sagas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        // Uma row vai inflar com: layout, raiz definida, attach to root?.
        View row = inflater.inflate(R.layout.item_saga, null, true);

        TextView titulo = (TextView) row.findViewById(R.id.tvTituloFilme);
        TextView descricao = (TextView) row.findViewById(R.id.tvDescricao);
        //ImageView poster = (ImageView) row.findViewById(R.id.ivFilme);

        titulo.setText(sagas.get(position).getTitulo());
        descricao.setText(sagas.get(position).getDescricao());
        //poster.setImageResource(sagas.get(position).getImageLocal());

        return row;
    }
}
