package adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.edu.fbv.programacaoavancada.R;
import model.Opiniao;

public class AdapterListOpinioes extends BaseAdapter {

    private final List<Opiniao> opiniaos;
    private  final Activity activity;

    public AdapterListOpinioes(List<Opiniao> opiniaos, Activity activity) {
        this.opiniaos = opiniaos;
        this.activity = activity;
    }


    @Override
    public int getCount() {
        return opiniaos.size();
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
            view = activity.getLayoutInflater().inflate(R.layout.opinioes_layout, parent,false);
            Opiniao opiniao = opiniaos.get(position);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else {
            view = convertView;
            holder = (ViewHolder) view.getTag();
        }
        Opiniao opiniao = opiniaos.get(position);
        holder.nomeOpiniao.setText(opiniao.getNome());
        holder.opiniao.setText(opiniao.getOpiniao());
        holder.opiniao.setText(opiniao.getNota());
        return view;
    }


    public class ViewHolder{
        final TextView nomeOpiniao;
        final TextView opiniao;
        final TextView nota;

        public ViewHolder(View view) {
            nomeOpiniao= (TextView) view.findViewById(R.id.nomeOpiniao);
            opiniao = (TextView) view.findViewById(R.id.opiniaoUser);
            nota = (TextView) view.findViewById(R.id.notaOpiniao);
        }
    }
}
