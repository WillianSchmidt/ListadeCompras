package com.example.listadecompras;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;


public class ListaDeCompraActivity extends AppCompatActivity {

    ListView lvLista;
    List<Produto> lista;
    AdapterProduto adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_compra);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lvLista = (ListView) findViewById(R.id.lvProduto);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        ListaDeCompraActivity.this, CadastroProdutoActivity.class);
                startActivity(intent);
            }
        });

        lvLista.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                final Produto produtoSelecionado = lista.get(position);
                AlertDialog.Builder alerta =
                        new AlertDialog.Builder(ListaDeCompraActivity.this);
                alerta.setTitle("Excluir produto...");
                alerta.setMessage("Confirma a exclusão do produto " +
                        produtoSelecionado.getNome() + "?");
                alerta.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ProdutoDAO.excluir(produtoSelecionado.getId(),
                                ListaDeCompraActivity.this);
                        carregarLista();
                    }
                });
                alerta.setNeutralButton("Cancelar", null);
                alerta.show();

                return true;
            }
        });

    }

    private void carregarLista(){

        lista = ProdutoDAO.listar(this);
        adapter = new AdapterProduto(this, lista);
        lvLista.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarLista();
    }



}
