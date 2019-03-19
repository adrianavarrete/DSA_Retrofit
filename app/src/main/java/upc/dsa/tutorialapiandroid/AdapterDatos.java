package upc.dsa.tutorialapiandroid;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder> implements View.OnClickListener {

    @Override
    public void onClick(View v) {
        if (listener != null){

            listener.onClick(v);
        }

    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }





    private ArrayList<Track> listTrack;
    private Activity activity;
    private View.OnClickListener listener;

    public AdapterDatos(ArrayList<Track> listTrack, Activity activity) {
        this.listTrack = new ArrayList<>();
        this.activity = activity;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_view,parent,false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Track track = listTrack.get(i);
        viewHolder.dato.setText(listTrack.get(i).getSinger() + " - " + listTrack.get(i).getTitle());
        viewHolder.dato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent = new Intent(activity.getApplicationContext(),SegundoActivity.class);
                mIntent.putExtra("trackId",track.getId());
                activity.startActivity(mIntent);
            }
        });
    }

    public void setDataSet(ArrayList<Track> dataSet){

        listTrack = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listTrack.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView dato;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dato = (TextView) itemView.findViewById(R.id.textView);


        }

    }
}
