package br.edu.ifpb.si.pdm.milho;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by admin on 05/06/17.
 */

public class Gasto implements Serializable{
    private String descricao;
    private int quantidade;
    private float valor;
    private Calendar data;

    public Gasto(String descricao, int quantidade, float valor){
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
        this.data = Calendar.getInstance();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public float getTotal(){
        return this.valor * this.quantidade;
    }

    public String getData(){
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy, HH:mm");
        return dataFormatada.format(this.data.getTime());
    }

    public Calendar getDataPura(){
        return this.data;
    }

    @Override
    public String toString() {
        return this.descricao;
    }

    /*@Override
    public int compareTo(@NonNull Gasto o) {
        return this.descricao.compareToIgnoreCase(o.descricao);
    }*/

    public static Comparator<Gasto> compararDescricao() {
        return new Comparator<Gasto>() {
            @Override
            public int compare(Gasto o1, Gasto o2) {
                return o1.getDescricao().compareToIgnoreCase(o2.getDescricao());
            }
        };
    }

    public static Comparator<Gasto> compararQuantidade() {
        return new Comparator<Gasto>() {
            @Override
            public int compare(Gasto o1, Gasto o2) {
                if(o1.getQuantidade() > o2.getQuantidade()){
                    return 1;
                }else if(o1.getQuantidade() == o2.getQuantidade()){
                    return 0;
                }else{
                    return -1;
                }
            }
        };
    }

    public static Comparator<Gasto> compararValorUnitario() {
        return new Comparator<Gasto>() {
            @Override
            public int compare(Gasto o1, Gasto o2) {
                if(o1.getValor() > o2.getValor()){
                    return 1;
                }else if(o1.getValor() == o2.getValor()){
                    return 0;
                }else{
                    return -1;
                }
            }
        };
    }

    public static Comparator<Gasto> compararValorTotal() {
        return new Comparator<Gasto>() {
            @Override
            public int compare(Gasto o1, Gasto o2) {
                if(o1.getTotal() > o2.getTotal()){
                    return 1;
                }else if(o1.getTotal() == o2.getTotal()){
                    return 0;
                }else{
                    return -1;
                }
            }
        };
    }

    public static Comparator<Gasto> compararData() {
        return new Comparator<Gasto>() {
            @Override
            public int compare(Gasto o1, Gasto o2) {
                return o1.getDataPura().compareTo(o2.getDataPura());
            }
        };
    }
}
