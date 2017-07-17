package br.edu.ifpb.si.pdm.palavras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 15/07/17.
 */

public class PalavraDAO {
    private SQLiteDatabase banco;

    public PalavraDAO(Context context){
        this.banco = new BancoHelper(context).getWritableDatabase();
    }

    public void insert(Palavra nova){
        ContentValues cv = new ContentValues();
        cv.put("conteudo", nova.getConteudo());
        cv.put("datahora", nova.getDataHoraLong());
        this.banco.insert(BancoHelper.TABELA, null, cv);
    }

    public void delete(int index){
        this.banco.delete(BancoHelper.TABELA, "codigo=" + Integer.toString(index), null);
    }

    public void update(Palavra editada, int index){
        ContentValues cv = new ContentValues();
        cv.put("conteudo", editada.getConteudo());
        cv.put("datahora", editada.getDataHoraLong());
        this.banco.update(BancoHelper.TABELA, cv, "codigo=" + Integer.toString(index), null);
    }

    public Palavra get(int index){
        String[] colunas = {"codigo", "conteudo", "datahora"};
        //Cursor c = this.banco.query(BancoHelper.TABELA, colunas, "codigo" + "=?", new String[]{Integer.toString(index)}, null, null, null);
        Palavra p = null;

        String consulta = "select codigo, conteudo, datahora from palavra where codigo = " + Integer.toString(index);
        Cursor c2 = this.banco.rawQuery(consulta, null);

        Log.i("APP_PALAVRAS", "Cursor 2 " + Integer.toString(c2.getCount()));
        Log.i("APP_PALAVRAS", "Index " + Integer.toString(index));
        if(c2.getCount() > 0){
            c2.moveToFirst();
            do{
                p = new Palavra();
                p.setId(c2.getInt(c2.getColumnIndex("codigo")));
                p.setConteudo(c2.getString(c2.getColumnIndex("conteudo")));
                p.setDataHoraLong(c2.getLong(c2.getColumnIndex("datahora")));
            }while(c2.moveToNext());
        }
        return p;
    }

    public List<Palavra> get(){
        List<Palavra> lista = new ArrayList<Palavra>();
        String[] colunas = {"codigo", "conteudo", "datahora"};
        Cursor c = this.banco.query(BancoHelper.TABELA, colunas, null, null, null, null, null);
        Palavra p;

        if (c.getCount() > 0){
            c.moveToFirst();
            do{
                p = new Palavra();
                p.setId(c.getInt(c.getColumnIndex("codigo")));
                p.setConteudo(c.getString(c.getColumnIndex("conteudo")));
                p.setDataHoraLong(c.getLong(c.getColumnIndex("datahora")));
                lista.add(p);
            }while(c.moveToNext());
        }

        return lista;
    }

    public int size(){
        List<Palavra> lista = new ArrayList<Palavra>();
        String[] colunas = {"codigo", "conteudo", "datahora"};
        Cursor c = this.banco.query(BancoHelper.TABELA, colunas, null, null, null, null, null);

        return c.getCount();
    }
}
