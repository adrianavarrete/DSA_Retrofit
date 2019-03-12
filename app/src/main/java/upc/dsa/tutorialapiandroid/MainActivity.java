package upc.dsa.tutorialapiandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

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
        mRecyclerView.setAdapter(mAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
                Call<ArrayList<Contributor>> call = gitHubService.repoContributors("Microsoft", "Calculator");

                call.enqueue(new Callback<ArrayList<Contributor>>() {
                    @Override
                    public void onResponse(Call<ArrayList<Contributor>> call, Response<ArrayList<Contributor>> response) {

                        ArrayList<Contributor> contribudores = response.body();
                        mAdapter.setDataSet(contribudores);

                    }
                    @Override
                    public void onFailure(Call<ArrayList<Contributor>> call, Throwable t) {
                        final TextView textView = (TextView) findViewById(R.id.textView);
                        textView.setText("Something went wrong: " + t.getMessage());
                    }
                });
            }
        });

    }
    }



