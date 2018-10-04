package adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


import br.edu.fbv.programacaoavancada.R;
import model.AtividadesListadas;
import model.Opiniao;

public class AdapterOpinioes extends  RecyclerView.Adapter<AdapterOpinioes.ViewHolder> {

    private List<Opiniao> OpiniaoAdapter;

    public void AdapterOpinioes(List<Opiniao> opiniaos) {
        this.OpiniaoAdapter = opiniaos;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View opiniaoview = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.opinioes_layout,viewGroup , false);

        //vamos passar o dados para o view holder configura dentro da apresentação
        return new ViewHolder(opiniaoview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Opiniao opinioes = OpiniaoAdapter.get(i);
        viewHolder.nomeOpiniao.setText(opinioes.getNome());
        viewHolder.opiniao.setText(opinioes.getOpiniao());
        viewHolder.nota.setText(opinioes.getNota());


    }


    @Override
    public int getItemCount() {
        return OpiniaoAdapter.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private TextView nomeOpiniao;
        private TextView opiniao;
        private TextView nota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeOpiniao= (TextView) itemView.findViewById(R.id.nomeOpiniao);
            opiniao = (TextView) itemView.findViewById(R.id.opiniaoUser);
            nota = (TextView) itemView.findViewById(R.id.notaOpiniao);
        }
    }
}
