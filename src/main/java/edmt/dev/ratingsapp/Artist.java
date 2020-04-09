package edmt.dev.ratingsapp;


public class Artist {
    String artistId;
    String artisttext;
    String artistcurrent_time;

    public Artist(){

    }
    public Artist(String artistId, String artisttext, String artistcurrent_time ){
        this.artistId=artistId;
        this.artisttext=artisttext;
        this.artistcurrent_time=artistcurrent_time;
    }
    public String getArtistId(){
        return artistId;
    }
    public String getArtisttext(){
        return artisttext;
    }
    public String getartistcurrent_time(){
        return artistcurrent_time;
    }



}

