package upc.dsa.tutorialapiandroid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ContributorsService {

    GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
    Call<ArrayList<Track>> call = gitHubService.tracks();
    ArrayList<Track> result = call.execute().body();

    public ContributorsService() throws IOException {
    }
}