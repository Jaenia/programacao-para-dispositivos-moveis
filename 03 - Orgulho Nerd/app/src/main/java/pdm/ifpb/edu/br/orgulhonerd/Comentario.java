package pdm.ifpb.edu.br.orgulhonerd;

import java.util.Date;

/**
 * Created by jaeni on 01/06/2017.
 */

public class Comentario {
    public Date data;
    public String texto;
    public Saga saga;

    @Override
    public String toString() {
        return "Comentario{" +
                "data=" + data +
                ", texto='" + texto + '\'' +
                '}';
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Saga getSaga() {
        return saga;
    }

    public void setSaga(Saga saga) {
        this.saga = saga;
    }
}
