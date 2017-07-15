package br.edu.ifpb.si.pdm.arrocha;

import java.util.Random;

/**
 * Created by admin on 15/05/17.
 */

public class Arrocha {
    private int menor, maior, secreto;

    public Arrocha(){
        this.menor = 1;
        this.maior = 100;

        Random r = new Random();
        this.secreto = r.nextInt(98) + 2;
    }

    public int getMenor() {
        return menor;
    }

    public int getMaior() {
        return maior;
    }

    public int getSecreto() {
        return secreto;
    }

    public boolean isArrochado(){
        return this.menor + 1 == this.maior - 1;
    }

    private boolean validar(int chute){
        return ((chute > this.menor) && (chute < this.maior));
    }

    public String jogar(int chute){
        if(validar(chute)){

            if(isArrochado()){
                return "Arrochou o numero e venceu!";
            }
            if(chute == this.secreto){
                return "Acertou o segredo e perdeu!";
            }
            if(chute < this.secreto){
                this.menor = chute;
            }else if(chute > this.secreto){
                this.maior = chute;
            }
        }else{
            return "O numero digitado é fora do intervalo";
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d] - %d", this.menor, this.maior, this.secreto);
    }
}
