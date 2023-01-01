package mx.edu.itl.c19130519.u3recyclerviewejemploapp;
//  By: RETBOT
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//  By: RETBOT
import java.util.ArrayList;

public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.ListaPersonasViewHolder> {

    private ArrayList<Persona> arrlstPersonas;
    public ListaPersonasAdapter (ArrayList<Persona> datos){
        arrlstPersonas = datos;
    }

    @NonNull
    @Override
    public ListaPersonasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.persona_recyler_layout, parent, false);
        return new ListaPersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListaPersonasViewHolder holder, int position) {
        holder.getTxtvNombre().setText(arrlstPersonas.get(position).getNombre());
        holder.getTxtvEdad().setText(arrlstPersonas.get(position).getEdad()+"");
        holder.getTxtvSexo().setText(arrlstPersonas.get(position).getSexo());
    }//  By: RETBOT

    @Override
    public int getItemCount(){//  return 0;
        return arrlstPersonas.size();
    }
//  By: RETBOT
    public static class ListaPersonasViewHolder extends RecyclerView.ViewHolder{
        private TextView txtvNombre;
        private TextView txtvEdad;
        private TextView txtvSexo;

        public ListaPersonasViewHolder (View v){
            super(v);
            txtvNombre = v.findViewById(R.id.txtvNombre);
            txtvEdad = v.findViewById(R.id.txtvEdad);
            txtvSexo = v.findViewById(R.id.txtvSexo);
        }

        public TextView getTxtvNombre() {
            return txtvNombre;
        }

        public TextView getTxtvEdad() {
            return txtvEdad;
        }

        public TextView getTxtvSexo() {
            return txtvSexo;
        }
    }//  By: RETBOT
}

//  By: RETBOT
