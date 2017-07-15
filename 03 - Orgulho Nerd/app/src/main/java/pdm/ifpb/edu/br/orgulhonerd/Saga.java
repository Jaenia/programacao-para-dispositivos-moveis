package pdm.ifpb.edu.br.orgulhonerd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaeni on 01/06/2017.
 */

public class Saga implements Serializable{
    private String titulo;
    private String descricao;
    private List<Comentario> comentarios = new ArrayList<Comentario>();
    private int imageLocal;
    private float estrelas;
    private int curtidas = 0;

    public Saga(){}

    public Saga(String titulo, String descricao, int imageLocal, float estrelas){
        super();
        this.titulo = titulo;
        this.descricao = descricao;
        this.imageLocal = imageLocal;
        this.estrelas = estrelas;
    }

    public Saga(String titulo, String descricao){
        super();
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public float getEstrelas(){
        return estrelas;
    }

    public int getCurtidas(){
        return curtidas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void addComentario(Comentario c){
        comentarios.add(c);
    }

    public int getImageLocal() {
        return imageLocal;
    }

    public void setImageLocal(int imageLocal) {
        this.imageLocal = imageLocal;
    }

    public void adicionarCurtida(){
        this.curtidas++;
    }

}
