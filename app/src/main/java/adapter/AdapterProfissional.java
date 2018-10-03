package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import  br.edu.fbv.programacaoavancada.R;

import java.util.ArrayList;

public class AdapterProfissional extends ArrayAdapter<String> {


    private Context context ;
    ArrayList<String> arrayList ;


    public AdapterProfissional(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.arrayList = objects;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHoulder viewHoulder ;

        View _view = convertView ;

        if(arrayList != null){


            if(_view == null){

                LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
                _view = inflater.inflate( R.layout.lista_profissional ,parent, false );
                viewHoulder = new ViewHoulder();

                viewHoulder.listservico = (TextView)_view.findViewById(R.id.textServico);

                _view.setTag(viewHoulder);
            }else {
                viewHoulder = (ViewHoulder) _view.getTag();
            }
            String name = arrayList.get(position);
            viewHoulder.listservico.setText(name);
        }

        return _view;
    }

    private class  ViewHoulder{
        public TextView listservico;
    }
}
