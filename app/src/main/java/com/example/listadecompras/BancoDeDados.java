package com.example.listadecompras;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends  SQLiteOpenHelper{


        private static final String NOME_BANCO = "ListaDeCompras";
        private static final int VERSAO_BANCO = 1;

        public BancoDeDados(Context context){
            super(context, NOME_BANCO, null, VERSAO_BANCO);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE IF NOT EXISTS Produtos ( " +
                    "  id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT , " +
                    "  quantidade INTEGER , " +
                    "  nome TEXT , " +
                    "  preco REAL  ) " );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


