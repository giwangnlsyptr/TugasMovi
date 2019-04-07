package com.example.movi;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class MoviPresenter {
    Context context;
    List<MoviModel> moviModels = new ArrayList<>();
    MainView view;

    public MoviPresenter(Context context, MainView view) {
        this.context = context;
        this.view = view;
    }

    public void setData() {
        MoviModel playlist;
        playlist = new MoviModel("US", R.drawable.us);
        moviModels.add(playlist);
        playlist = new MoviModel("CAPTAIN MARVEL", R.drawable.captainmarvel);
        moviModels.add(playlist);
        playlist = new MoviModel("GLASS", R.drawable.glass);
        moviModels.add(playlist);
        playlist = new MoviModel("TOY STORY 4", R.drawable.toystory);
        moviModels.add(playlist);
        playlist = new MoviModel("FROZEN 2", R.drawable.frozen2);
        moviModels.add(playlist);
        playlist = new MoviModel("FIVE FEET APART", R.drawable.fivefeetapart);
        moviModels.add(playlist);
        playlist = new MoviModel("SHAZAM", R.drawable.shazam);
        moviModels.add(playlist);
        playlist = new MoviModel("DILAN 1991", R.drawable.dilan);
        moviModels.add(playlist);
        view.onSuccess(moviModels);
    }

}

