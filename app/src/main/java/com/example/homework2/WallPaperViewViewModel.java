package com.example.homework2;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WallPaperViewViewModel extends ViewModel {
    private final WallpaperRepository wallRepo = new WallpaperRepository();

    private MutableLiveData<List<Wallpaper>> wallpapers;
    public MutableLiveData<List<Wallpaper>> getWallpaper() {
        if (wallpapers == null) {
            wallpapers = new MutableLiveData<>();
            loadWallpapers();
        }

        return wallpapers;
    }

    private void loadWallpapers() {
        wallRepo.getWallpaperCall().enqueue(new Callback<WallPaperRequest>() {
            @Override
            public void onResponse(@NotNull Call<WallPaperRequest> call, @NotNull Response<WallPaperRequest> response) {
                if (response.body() != null) {
                    wallpapers.setValue(response.body().getWallpapers());
                }
            }

            @Override
            public void onFailure(@NotNull Call<WallPaperRequest> call, @NotNull Throwable t) {
                Log.e("_network", "failed to get Wallpapers");
            }
        });
    }
    // TODO: Implement the ViewModel

}