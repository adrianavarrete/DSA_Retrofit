package upc.dsa.tutorialapiandroid;

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

    private final static Logger log = Logger.getLogger("Logger de Ejemplo");


    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button button = (Button) findViewById(R.id.button);

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        final Adapter mAdapter = new Adapter();
        mAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"hola",Toast.LENGTH_SHORT).show();
            }
        });
        mRecyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                log.info("hello there");
                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<ArrayList<Track>> call = gitHubService.tracks();

                call.enqueue(new Callback<ArrayList<Track>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Track>> call, Response<ArrayList<Track>> response) {

                        ArrayList<Track> canciones = response.body();
                        mAdapter.setDataSet(canciones);

                    }
                    @Override
                    public void onFailure(Call<ArrayList<Track>> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });

    }
    }



