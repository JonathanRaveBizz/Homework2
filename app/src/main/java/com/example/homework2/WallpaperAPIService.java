package com.example.homework2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WallpaperAPIService {

    @GET("get.php")
    Call<WallPaperRequest> getWallpapers(
            @Query("auth") String key,
            @Query("method") String method,
            @Query("id") int id,
            @Query("page") int page
    );
}
