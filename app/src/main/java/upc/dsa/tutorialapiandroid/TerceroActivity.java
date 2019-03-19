package upc.dsa.tutorialapiandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TerceroActivity extends AppCompatActivity {

    TextView singer;
    TextView title;
    Button añadir;
    TrackAPI API;
    Track track;


    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercero);

        añadir = (Button) findViewById(R.id.añadir2Btn);
        singer = (TextView) findViewById(R.id.singerTextView);
        title = (TextView) findViewById(R.id.titleTextView);
        API = TrackAPI.retrofit.create(TrackAPI.class);

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                track = new Track(title.getText().toString(), singer.getText().toString());

                Call<Track> call = API.addTrack(track);

                call.enqueue(new Callback<Track>() {
                    @Override
                    public void onResponse(Call<Track> call, Response<Track> response) {

                        Toast.makeText(getApplicationContext(), "Cancion añadida correctamente", Toast.LENGTH_SHORT).show();
                        finish();

                    }

                    @Override
                    public void onFailure(Call<Track> call, Throwable t) {

                        Toast.makeText(getApplicationContext(), "Fallo con la petición de información", Toast.LENGTH_SHORT).show();
                    }

                });
            }
        });



    }
}
