package com.example.listadecompras;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {

    public static final void inserir(Produto produto, Context context){
        BancoDeDados banco = new BancoDeDados(context);
        ContentValues valores = new ContentValues();
        valores.put("nome", produto.getNome() );
        valores.put("quantidade", produto.getQuantidade() );
        valores.put("preco", produto.getPreco() );
        SQLiteDatabase db = banco.getWritableDatabase();
        db.insert("Produtos", null, valores);
    }

    public static final void excluir(int idProduto, Context context){
        BancoDeDados banco = new BancoDeDados(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("Produtos", "id = "+idProduto, null);
    }

    public static final List<Produto> listar(Context context){
        List<Produto> lista = new ArrayList<>();
        BancoDeDados banco = new BancoDeDados(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        String sql = "SELECT * FROM Produtos ORDER BY id DESC ";
        Cursor cursor = db.rawQuery(sql, null);
        if ( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto produto = new Produto();
                produto.setId( cursor.getInt( 0 ) );
                produto.setQuantidade( cursor.getInt( 1 ) );
                produto.setNome( cursor.getString( 2 ) );
                produto.setPreco( cursor.getDouble( 3 ) );
                lista.add( produto );
            }while ( cursor.moveToNext() );
        }
        return lista;
    }
}
