package adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import br.edu.fbv.programacaoavancada.R;
import model.Servicos;

public class AdapterListServicos extends BaseAdapter {

    private List<Servicos> servicosList;
    private  final Activity activity;

    private ListView listView ;

    public AdapterListServicos(List<Servicos> servicos, Activity activity) {
    this.servicosList = servicos;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return servicosList.size();
    }

    @Override
    public Object getItem(int position) {
        return 0;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder holder ;

        if(convertView == null){
            view = activity.getLayoutInflater().inflate(R.layout.servicos_oferecidos, parent,false);
            Servicos servicos = servicosList.get(position);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Servicos servicos = servicosList.get(position);
        holder.servico_nome.setText(servicos.getServico());
        holder.icone.setImageResource(servicos.getImg());

        return view;
    }

    public class ViewHolder {
        final ImageView icone ;
        final TextView servico_nome;

        public ViewHolder(View view) {
            this.icone = view.findViewById(R.id.ima_oferecida);
            this.servico_nome = view.findViewById(R.id.profissaoOferecida);
        }
    }
}
