package com.example.android.architecture.blueprints.todoapp.data.source.remote;

import android.graphics.Bitmap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface GitHubService {
    @GET
    Call<ResponseBody> getHttpPic(@Url String url);
}
