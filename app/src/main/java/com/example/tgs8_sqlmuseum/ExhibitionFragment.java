package com.example.tgs8_sqlmuseum;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExhibitionFragment extends Fragment {
    String api_key = "6ec82d44-6b6e-4c58-bec3-1aca7e80316c";
    ArrayList<ModelClass> modelClassArrayList;
    Adapter adapter;
    String country="id";
    private RecyclerView recyclerViewexhb;
    private String category="exhibition";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_exhibition_fragment,null);
        recyclerViewexhb=v.findViewById(R.id.recyclerexhb);
        modelClassArrayList = new ArrayList<>();
        recyclerViewexhb.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new Adapter(getContext(),modelClassArrayList);
        recyclerViewexhb.setAdapter(adapter);
        findNews();
        return v;
    }
    private void findNews() {

        ApiUtilities.getApiInterface().getNews(country,100,api_key).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if(response.isSuccessful())
                {
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {
            }
        });
    }
}
