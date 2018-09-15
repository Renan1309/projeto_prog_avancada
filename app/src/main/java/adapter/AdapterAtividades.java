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

public class AdapterAtividades extends RecyclerView.Adapter<AdapterAtividades.ViewHolder> {

    private List<AtividadesListadas> atividadesListadasAdapter;

    public AdapterAtividades(List<AtividadesListadas> atividadeslistadas) {
        this.atividadesListadasAdapter = atividadeslistadas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //converter a lista em view
      //criando a visualizção
                      //converte um xml em visualização
        View cardlist = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.atividades_layout,viewGroup , false);

        //vamos passar o dados para o view holder configura dentro da apresentação
        return new ViewHolder(cardlist);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //quando o oncreatView cria as determinadas view o onbindView para exibir e não criar novamente
        //exibição

        AtividadesListadas atividadesListadas = atividadesListadasAdapter.get(i);
        viewHolder. nomeCardPrin .setText(atividadesListadas.getTitulo());
        viewHolder.texto2card .setText(atividadesListadas.getTitulo1());
        viewHolder.imageViewcard.setImageResource(atividadesListadas.getImagem());
        viewHolder.text1card.setText(atividadesListadas.getTitulo2());

    }

    @Override
    public int getItemCount() {
        return atividadesListadasAdapter.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {

        private TextView nomeCardPrin;
        private TextView texto2card;
        private ImageView imageViewcard;
        private TextView text1card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeCardPrin = (TextView) itemView.findViewById(R.id.nomeCardPrin);
            texto2card = (TextView) itemView.findViewById(R.id.texto2card);
            imageViewcard=(ImageView) itemView.findViewById(R.id.imageViewcard);
            text1card = (TextView) itemView.findViewById(R.id.texto1card);
        }
    }
}
