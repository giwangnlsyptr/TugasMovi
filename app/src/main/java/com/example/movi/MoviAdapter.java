package com.example.movi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MoviAdapter extends RecyclerView.Adapter<MoviAdapter.ViewHolder> {
    Context context;
    List<MoviModel> moviModels = new ArrayList<>();
    public MoviAdapter(Context context, List<MoviModel> tempatModels) {
        this.context = context;
        this.moviModels = tempatModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_list, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.onBind(moviModels.get(i));
    }

    @Override
    public int getItemCount() {
        return moviModels.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        ImageView ivImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.title);
            ivImage = itemView.findViewById(R.id.poster);
        }

        public void onBind(final MoviModel playlist) {
            tvName.setText(playlist.getTitle());
            ivImage.setImageResource(playlist.getPoster());
            itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Toast.makeText(context, playlist.getTitle(), Toast.LENGTH_LONG).show();
                }
            });
        }
    }
}

