package com.xitiz.dagger2_retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Inject
    Retrofit retrofit;
    private Object heroes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        ((MyApp) getApplication()).getNetComponent().inject(this);
        listView = findViewById(R.id.listView);
        getHeroes();

    }

    public void getHeroes() {
        Api api = retrofit.create(Api.class);
        Call<List<Hero>> listCall = api.getHeroes();
        listCall.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                List<Hero> heroList = response.body();
                String[] heroes = new String[heroList.size()];

                for (int i = 0; i < heroList.size(); i++) {
                    heroes[i] = heroList.get(i).getName();
                }
                listView.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, heroes));
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Log.d("TAG", "failed to load");

            }
        });
    }
}
