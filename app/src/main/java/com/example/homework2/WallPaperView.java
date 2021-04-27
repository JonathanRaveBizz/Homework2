package com.example.homework2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class WallPaperView extends Fragment {

    private WallPaperViewViewModel viewModel;
    private RecyclerView wallpaperView;
    private WallPaperRecyclerView WallpaperAdapter;

    private List<Wallpaper> wallpaperList;

    public static WallPaperView newInstance() {
        return new WallPaperView();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.wall_paper_view_fragment, container, false);

       wallpaperView = view.findViewById(R.id.wallpaper_recycler_view);

       WallpaperAdapter = new WallPaperRecyclerView();

       wallpaperView.setAdapter(WallpaperAdapter);

       wallpaperView.setLayoutManager(new LinearLayoutManager(
               view.getContext(),
               LinearLayoutManager.VERTICAL,
               false
       ));
       return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(WallPaperViewViewModel.class);
        // TODO: Use the ViewModel
        viewModel.getWallpaper().observe(requireActivity(), this::newWallpapers);
    }
    private void newWallpapers(List<Wallpaper> wallpapers)
    {
        wallpaperList = wallpapers;
        WallpaperAdapter.updateItems(wallpaperList);
    }

}