package upc.dsa.tutorialapiandroid;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

public class ContributorsService {

    GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
    Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");
    List<Contributor> result = call.execute().body();

    public ContributorsService() throws IOException {
    }
}