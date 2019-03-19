package upc.dsa.tutorialapiandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SegundoActivity extends AppCompatActivity {


    TextView singer;
    TextView title;
    Button edit;
    Button delete;
    TrackAPI API;
    Track track;
    Intent adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);

        singer = (TextView) findViewById(R.id.singerTextView);
        title = (TextView) findViewById(R.id.titleTextView);
        edit = (Button) findViewById(R.id.editarBtn);
        delete = (Button) findViewById(R.id.deleteBtn);
        API = TrackAPI.retrofit.create(TrackAPI.class);


        adapter = getIntent();



        Call<Track> call = API.track(adapter.getStringExtra("trackId"));

        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {

                singer.setText(response.body().getSinger());
                title.setText(response.body().getTitle());

                track = new Track(response.body().getTitle(), response.body().getSinger());
                track.setId(adapter.getStringExtra("trackId"));

            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Fallo con la petición de información", Toast.LENGTH_SHORT).show();
            }

        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editTrack(track);

            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteTrack(track.getId());

            }


        });
    }

    public void deleteTrack(String id){
        Call<Void> call = API.deleteTrack(id);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Toast.makeText(getApplicationContext(), "Eliminado Correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Fallo con la petición de información", Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void editTrack(Track track){

        track.setTitle(title.getText().toString());
        track.setSinger(singer.getText().toString());

        Call<Void> call = API.editTrack(track);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Toast.makeText(getApplicationContext(), "Editado Correctamente", Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "Fallo con la petición de información", Toast.LENGTH_SHORT).show();
            }

        });

    }


}
