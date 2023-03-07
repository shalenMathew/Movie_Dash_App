package com.example.movieproapp.model;


import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class MovieModal extends BaseObservable implements Parcelable {


    @SerializedName("poster_path")
    @Expose
    private String posterPath;

@BindingAdapter({"posterPath"})
public static void loadImage(ImageView imageView, String imageUrl){

//        By declaring the loadImage method as static, the data binding library can call the method directly without
////        having to create an instance of the class that contains the method.

String imagePath = "https://image.tmdb.org/t/p/w500" + imageUrl;

    Glide.with(imageView.getContext()).load(imagePath).into(imageView);

}


    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;



    @Bindable
    public Integer getId() {
        return id;
    }

    @Bindable
    public String getOverview() {
        return overview;
    }

    @Bindable
    public String getPosterPath() {
        return posterPath;
    }

    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public Double getVoteAverage() {
        return voteAverage;
    }



    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }



    public void setOverview(String overview) {
        this.overview = overview;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public void setVoteAverage(Double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {

parcel.writeValue(id);
parcel.writeValue(title);
parcel.writeValue(posterPath);
parcel.writeValue(overview);
parcel.writeValue(releaseDate);
parcel.writeValue(voteAverage);

    }


    public MovieModal() {
    }


    public MovieModal(Parcel in){

        this.id = ((Integer) in.readValue(Integer.class.getClassLoader()));
        this.title = (String) in.readValue(String.class.getClassLoader());
        this.posterPath = (String) in.readValue(String.class.getClassLoader());
        this.overview=(String) in.readValue(String.class.getClassLoader());
        this.releaseDate = (String) in.readValue(String.class.getClassLoader());
        this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());

    }

    // intizilaing parcel
    public  final  static Parcelable.Creator<MovieModal> CREATOR = new Creator<MovieModal>() {
        @Override
        public MovieModal createFromParcel(Parcel parcel) {
            return new MovieModal(parcel);
        }

        @Override
        public MovieModal[] newArray(int i) {
            return new MovieModal[i];
        }
    };
}
