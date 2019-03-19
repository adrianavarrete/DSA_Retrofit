package upc.dsa.tutorialapiandroid;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import okhttp3.OkHttpClient;


import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

interface TrackAPI {
    @GET("tracks")
    Call<ArrayList<Track>> tracks();

    /*@GET("tracks/{owner}/{repo}/contributors")
    Call<ArrayList<Contributor>> repoContributors(
            @Path("owner") String owner,
            @Path("repo") String repo);
*/
    @GET("tracks/{id}")
    Call<Track> track(
            @Path("id") String id);

    @PUT("tracks")
    Call<Void> editTrack(
            @Body Track track);

    @DELETE("tracks/{id}")
    Call<Void> deleteTrack(
            @Path("id") String id);

    @POST("tracks")
    Call<Track> addTrack(
            @Body Track track);


    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://147.83.7.203:8080/dsaApp/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}


