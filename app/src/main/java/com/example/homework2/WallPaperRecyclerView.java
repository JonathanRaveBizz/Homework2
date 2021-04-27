package com.example.homework2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class WallPaperRecyclerView extends RecyclerView.Adapter<WallPaperRecyclerView.ViewHolder> {

    //private ItemClickListener clickListener;
    public List<Wallpaper> WallPaperList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.wallpaper_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WallPaperRecyclerView.ViewHolder holder, int position) {
        holder.bind(WallPaperList.get(position));
    }

    @Override
    public int getItemCount() {
        if( WallPaperList!=null)
            return WallPaperList.size();
        else return 0;
    }

    public void updateItems(List<Wallpaper> newList)
    {
        WallPaperList = newList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView WallPaperText;
        ImageView WallPaperImage;
        Button WallPaperButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            WallPaperText = itemView.findViewById(R.id.the_wallpaper_text);
            WallPaperImage= itemView.findViewById(R.id.the_wallpaper);
            //WallPaperButton = itemView.findViewById(R.id.the_wallPaper_download);
            //WallPaperButton.setOnClickListener(this);
        }

        public void bind(Wallpaper wallPaper) {
            if (wallPaper.getUrlImage() != null)
                Picasso.get().load(wallPaper.getUrlImage()).into(WallPaperImage);
        }
    }



}
