package upc.dsa.tutorialapiandroid;

public class Contributor {

    public String login;
    public String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }
}
