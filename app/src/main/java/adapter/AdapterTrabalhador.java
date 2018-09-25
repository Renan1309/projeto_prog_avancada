package adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fbv.programacaoavancada.R;
import model.Pessoa;

public class AdapterTrabalhador extends BaseAdapter {

    private final List<Pessoa> pessoas;
    private final Activity activity;

    public AdapterTrabalhador(List<Pessoa> pessoa ,  Activity act) {
        this.pessoas = pessoa;
        this.activity = act;
    }


    @Override
    public int getCount() {
        return pessoas.size();
    }

    @Override
    public Object getItem(int position) {
        return pessoas.get(position);
    }

    @Override
    public long getItemId(int position) {
        //aqui eu posso implementaar pra ele da um getID da pessoa que vim do banco
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        //TextView nome;
        ViewHolder holder ;

        if( convertView == null) {
            view = activity.getLayoutInflater().inflate(R.layout.lista_profissional, parent, false);
            Pessoa pessoa = pessoas.get(position);
            //nome = (TextView)  view.findViewById(R.id.textServico);
           // nome.setText(pessoa.getNome());

            holder = new ViewHolder(view);
            view.setTag(holder);


        } else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Pessoa pessoa = pessoas.get(position);
        holder.nome.setText(pessoa.getNome());
        return view;


        /**
        //metodo responsável pela construção de cada item
        View view = activity.getLayoutInflater().inflate(R.layout.lista_profissional, parent, false);
        Pessoa pessoa = pessoas.get(position);

        TextView nome = (TextView)  view.findViewById(R.id.textServico);
        nome.setText(pessoa.getNome());

        return view;
         */
    }

    public class ViewHolder {

        final TextView nome;


        public ViewHolder(View view) {
            nome = (TextView) view.findViewById(R.id.textServico);

        }

    }
}
