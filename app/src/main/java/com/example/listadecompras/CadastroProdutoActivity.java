package com.example.listadecompras;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroProdutoActivity extends AppCompatActivity {

    private EditText etNomeProduto, etPrecoProduto, etQuantidadeProduto ;
    private Button btnSalvar,btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_produto);

        etNomeProduto = (EditText) findViewById(R.id.etNomeProduto);
        etQuantidadeProduto = (EditText) findViewById(R.id.etQuantidade);
        etPrecoProduto = (EditText) findViewById(R.id.etPreco);
        btnSalvar = (Button) findViewById(R.id.btnSalvarProduto);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void salvar() {
        Produto produto = new Produto();

        String preco = etPrecoProduto.getText().toString();
        String quantidade = etQuantidadeProduto.getText().toString();

        produto.setNome(etNomeProduto.getText().toString());
        produto.setPreco(Double.parseDouble(preco));
        produto.setQuantidade(Integer.parseInt(quantidade));

        ProdutoDAO.inserir(produto, this);
        this.finish();
    }
}
