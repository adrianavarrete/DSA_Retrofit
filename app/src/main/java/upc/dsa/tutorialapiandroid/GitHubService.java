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
    @GET("tracks")
    Call<ArrayList<Track>> tracks();

    /*@GET("tracks/{owner}/{repo}/contributors")
    Call<ArrayList<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
*/
    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://147.83.7.203:8080/dsaApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();


}


