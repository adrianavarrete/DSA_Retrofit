package upc.dsa.tutorialapiandroid;

public class Track {

    private String id;
    private String title;
    private String singer;

    public Track(String id){
        this.id = id;
        this.singer = "";
        this.singer = "";
    }

    public String getId(){

        return this.id;
    }

    public String getTitle(){

        return this.title;
    }

    public String getSinger(){

        return this.singer;
    }

    public void setSinger(String singer){

        this.singer = singer;
    }

    public void setTitle(String title){

        this.title = title;
    }

    public void setId(String id){

        this.id = id;
    }


}


