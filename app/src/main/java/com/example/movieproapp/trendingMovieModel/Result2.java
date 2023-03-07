package com.example.movieproapp.trendingMovieModel;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Result2 implements Parcelable {

    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("results")
    @Expose
    private List<TrendingMovieModal> results;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<TrendingMovieModal> getResults() {
        return results;
    }

    public void setResults(List<TrendingMovieModal> results) {
        this.results = results;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Result2() {
    }



    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int flags) {


        parcel.writeValue(page);
        parcel.writeValue(results);
        parcel.writeValue(totalPages);
        parcel.writeValue(totalResults);
    }
    public Result2(Parcel in) {

        this.page = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalResults = (Integer) in.readValue(Integer.class.getClassLoader());
        this.totalPages= (Integer) in.readValue(Integer.class.getClassLoader());
        in.readList(this.results,(com.example.movieproapp.trendingMovieModel.TrendingMovieModal.class.getClassLoader()));
    }

    public static Parcelable.Creator<Result2> CREATOR = new Creator<Result2>() {
        @Override
        public Result2 createFromParcel(Parcel parcel) {
            return new Result2(parcel);
        }

        @Override
        public Result2[] newArray(int size) {
            return new Result2[size];
        }
    };

}
