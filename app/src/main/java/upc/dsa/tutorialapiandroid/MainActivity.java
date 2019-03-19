package upc.dsa.tutorialapiandroid;

import android.app.Activity;
import android.content.Intent;
import android.media.audiofx.LoudnessEnhancer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private AdapterDatos mAdapter;
    RecyclerView mRecyclerView;
    private ArrayList<Track> listTrack;
    Button recargar;
    Button añadir;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recargar = (Button) findViewById(R.id.recargarBtn);
        añadir = (Button) findViewById(R.id.añadirBtn);

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this );
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new AdapterDatos(listTrack,MainActivity.this);


        mRecyclerView.setAdapter(mAdapter);

        recargar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                TrackAPI API = TrackAPI.retrofit.create(TrackAPI.class);
                Call<ArrayList<Track>> call = API.tracks();

                call.enqueue(new Callback<ArrayList<Track>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Track>> call, Response<ArrayList<Track>> response) {

                        listTrack = response.body();
                        mAdapter.setDataSet(listTrack);

                    }
                    @Override
                    public void onFailure(Call<ArrayList<Track>> call, Throwable t) {

                        Toast.makeText(getApplicationContext(),"Fallo con la petición de información",Toast.LENGTH_SHORT);
                    }
                });
            }
        });

       añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent añadirIntent = new Intent(MainActivity.this,TerceroActivity.class);
                MainActivity.this.startActivity(añadirIntent);


            }
        });

    }


}



