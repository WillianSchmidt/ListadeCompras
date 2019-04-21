package com.example.listadecompras;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterProduto extends BaseAdapter {

    private Context context;
    private List<Produto> lista;
    private LayoutInflater inflater;

    public AdapterProduto(Context context, List<Produto> lista){
        this.context = context;
        this.lista = lista;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return lista.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Suporte item;

        if( convertView == null ){
            convertView = inflater.inflate
                    (R.layout.layout_lista_produto, null);
            item = new Suporte();
            item.tvId = (TextView)
                    convertView.findViewById(R.id.tvListaId);
            item.tvQuantidade = (TextView)
                    convertView.findViewById(R.id.tvListaQuantidade);
            item.tvNome = (TextView)
                    convertView.findViewById(R.id.tvListaNome);
            item.tvPreco = (TextView)
                    convertView.findViewById(R.id.tvListaPreco);

            convertView.setTag(item);
        }else {
            item = (Suporte) convertView.getTag();
        }


        Produto produto = lista.get( position );
        item.tvId.setText( String.valueOf( produto.getId() ) );
        item.tvNome.setText(  produto.getNome());
        item.tvQuantidade.setText(  String.valueOf( produto.getQuantidade() ));
        item.tvPreco.setText(  String.valueOf( produto.getPreco() ));

        return convertView;
    }

    private class Suporte{
        TextView tvId, tvNome , tvQuantidade, tvPreco;
    }
}
