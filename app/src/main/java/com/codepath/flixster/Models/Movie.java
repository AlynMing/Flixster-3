package com.codepath.flixster.Models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {
    String backdropPath;
    String posterPath;
    String title;
    String overview;
    double rating;

    public int getMovieId() {
        return movieId;
    }

    int movieId;
    //empty constructor used by Parceler library
    public Movie(){

    }

    public double getRating() {
        return rating;
    }

    public Movie(JSONObject jsonObject) throws JSONException {
       this.backdropPath=jsonObject.getString("backdrop_path");
        this.posterPath=jsonObject.getString("poster_path");
        this.title=jsonObject.getString("title");
        this.overview=jsonObject.getString("overview");
        this.rating=jsonObject.getDouble("vote_average");
        this.movieId=jsonObject.getInt("id");
   }

   public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
       List<Movie> movies=new ArrayList<>();
       for(int i=0;i<movieJsonArray.length();i++){
           movies.add(new Movie(movieJsonArray.getJSONObject(i)));
       }
       return movies;
   }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",posterPath);
    }
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s",backdropPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}
