package br.edu.ifpb.si.pdm.usacanivete;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaeni on 14/07/2017.
 */

public class Pessoa implements Parcelable{
    private String nome;
    private String telefone;

    public Pessoa(String nome, String telefone){
        super();
        this.nome = nome;
        this.telefone = telefone;
    }

    public Pessoa(Parcel parcel){
        this.nome = parcel.readString();
        this.telefone = parcel.readString();
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return this.telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String toString(){
        return "Pessoa [nome=" + this.nome + ", telefone=" + this.telefone + "]";
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(telefone);
    }

    public static Parcelable.Creator<Pessoa> CREATOR = new Parcelable.Creator<Pessoa>(){

        @Override
        public Pessoa createFromParcel(Parcel source) {
            return new Pessoa(source);
        }

        @Override
        public Pessoa[] newArray(int size) {
            return new Pessoa[size];
        }
    };
}
