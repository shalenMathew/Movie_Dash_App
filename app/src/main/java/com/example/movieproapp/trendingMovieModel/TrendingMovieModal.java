package com.example.movieproapp.trendingMovieModel;


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
public class TrendingMovieModal extends BaseObservable implements Parcelable {


    @SerializedName("poster_path")
    @Expose
    private String posterPath;


    @BindingAdapter({"posterPath"})
    public static void loadImage(ImageView imageView,String imageUrl){

        String imagePath = "https://image.tmdb.org/t/p/w500" + imageUrl;

        Glide.with(imageView.getContext()).load(imagePath).into(imageView);


    }


    @SerializedName("adult")
    @Expose
    private Boolean adult;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("original_language")
    @Expose
    private String originalLanguage;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("media_type")
    @Expose
    private String mediaType;
    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genreIds;
    @SerializedName("popularity")
    @Expose
    private Double popularity;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("vote_average")
    @Expose
    private Double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;

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



    public void setId(Integer id) {
        this.id = id;
    }



    public void setTitle(String title) {
        this.title = title;
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

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public List<Integer> getGenreIds() {
        return genreIds;
    }

    public void setGenreIds(List<Integer> genreIds) {
        this.genreIds = genreIds;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }



    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
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

    @Bindable
    public String getPosterPath() {
        return posterPath;
    }
    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }
    @Bindable
    public Double getVoteAverage() {
        return voteAverage;
    }
    @Bindable
    public String getOverview() {
        return overview;
    }
    @Bindable
    public String getTitle() {
        return title;
    }

    @Bindable
    public Integer getId() {
        return id;
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {

parcel.writeValue(title);
parcel.writeValue(overview);
//parcel.writeValue(voteAverage);
parcel.writeValue(releaseDate);
parcel.writeValue(posterPath);

    }

    public TrendingMovieModal() {
    }

    public TrendingMovieModal(Parcel in) {


        this.title = (String) in.readValue(String.class.getClassLoader());
        this.overview = (String) in.readValue(String.class.getClassLoader());
        this.posterPath = (String) in.readValue(String.class.getClassLoader());
        this.releaseDate = (String) in.readValue(String.class.getClassLoader());
//       this.voteAverage = (Double) in.readValue(Double.class.getClassLoader());


    }


    public final static Parcelable.Creator<TrendingMovieModal> CREATOR = new Creator<TrendingMovieModal>() {
        @Override
        public TrendingMovieModal createFromParcel(Parcel source) {
            return new TrendingMovieModal(source);
        }

        @Override
        public TrendingMovieModal[] newArray(int size) {
            return new TrendingMovieModal[size];
        }
    };
}
