package com.example.movi;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment implements MainView{
    RecyclerView rv;
    MoviAdapter adapter;
    MoviPresenter data;
    List<MoviModel> moviModels = new ArrayList<>();


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapter = new MoviAdapter(getContext(), moviModels);
        rv.setAdapter(adapter);
        data = new MoviPresenter(getContext(),this);
        data.setData();
    }

    @Override
    public void onSuccess(List<MoviModel> moviModels) {
        this.moviModels.clear();
        this.moviModels.addAll(moviModels);
        this.adapter.notifyDataSetChanged();
    }

}

