package br.edu.ifpb.si.pdm.milho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by admin on 05/06/17.
 */

public class Cadastro {
    private List<Gasto> gastos;

    public Cadastro(){
        this.gastos = new ArrayList<Gasto>();
    }

    public void add(Gasto gasto){
        this.gastos.add(gasto);
    }

    public float getTotal(){
        float soma = 0;
        for (Gasto g: this.gastos) {
            soma += g.getTotal();
        }
        return soma;
    }

    public int getQuantidade(){
        return this.gastos.size();
    }

    public List<Gasto> getLista(){
        return this.gastos;
    }

    public Gasto get(int index){
        return this.gastos.get(index);
    }

    public void clear(){
        this.gastos.clear();
    }

    public void excluir(int index){
        this.gastos.remove(index);
    }

    public void ordenarDescricao(){
        Collections.sort(this.gastos, Gasto.compararDescricao());
    }

    public void ordenarQuantidade(){
        Collections.sort(this.gastos, Gasto.compararQuantidade());
    }

    public void ordenarValorUnitario(){
        Collections.sort(this.gastos, Gasto.compararValorUnitario());
    }

    public void ordenarValorTotal(){
        Collections.sort(this.gastos, Gasto.compararValorTotal());
    }

    public void ordenarData(){
        Collections.sort(this.gastos, Gasto.compararData());
    }
}
