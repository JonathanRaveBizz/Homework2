package com.example.homework2;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WallpaperRepository {
    private final String BASE_URL = "https://wall.alphacoders.com/api2.0/";
    private final String API_KEY = "e1362fea4864a3e2f2dba8e1ef453831";
    private int page=0;
    private String method = "category";
    private int id = 3;

    private final OkHttpClient client = new OkHttpClient.Builder()
            .addInterceptor(
                    new HttpLoggingInterceptor()
                            .setLevel(HttpLoggingInterceptor.Level.BODY)
            ).build();
    private final WallpaperAPIService service = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WallpaperAPIService.class);
    public Call<WallPaperRequest> getWallpaperCall() {
        page++;
        return service.getWallpapers(
                API_KEY,
                method,
                id,
                page
        );
    }
}
