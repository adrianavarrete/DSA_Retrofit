package upc.dsa.tutorialapiandroid;

import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface GitHubService {
    @GET("repos/{owner}/{repo}/contributors")
    Call<ArrayList<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}


