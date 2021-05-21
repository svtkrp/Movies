package com.sve.movies.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sve.movies.constants.PostConstants;
import com.sve.movies.dto.MovieDTO;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class AddMoviesController implements Callback<Void> {
    static final String BASE_URL = PostConstants.BASE_URL;

    public void start(List<MovieDTO> movies) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .setDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        MovieApi api = retrofit.create(MovieApi.class);

        Call<Void> call = api.addMovies(movies);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Void> call, Response<Void> response) {
        if (response.isSuccessful()) {
            System.out.println("success");
        } else {
            System.out.println("error: " + response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<Void> call, Throwable t) {
        t.printStackTrace();
    }
}