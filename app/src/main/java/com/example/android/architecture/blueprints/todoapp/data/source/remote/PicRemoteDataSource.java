package com.example.android.architecture.blueprints.todoapp.data.source.remote;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import androidx.annotation.NonNull;

import com.example.android.architecture.blueprints.todoapp.data.source.PicDataSource;


import java.io.InputStream;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class PicRemoteDataSource implements PicDataSource {


    @Override
    public void getHttpPic(@NonNull String url, @NonNull final GetHttpPicCallback callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.baidu.com/")
                .build();

        GitHubService service = retrofit.create(GitHubService.class);
        Call<ResponseBody> call = service.getHttpPic(url);
        call.enqueue(new Callback<ResponseBody>(){
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                InputStream inputStream = response.body().byteStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                callback.onPicLoaded(bitmap);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                callback.onPicLoaded(null);
            }
        });
    }

    //    @Override
//    public void getHttpPic(@NonNull String url, @NonNull final GetHttpPicCallback callback) {
//        OkHttpClient client = new OkHttpClient();
//        final Request request = new Request.Builder()
//                .get()
//                .url(url)
//                .build();
//        Call call = client.newCall(request);
//        call.enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e("PicRemoteDataSource", "onFailure: "+e.toString());
//                callback.onPicLoaded(null);
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                InputStream is = response.body().byteStream();
//                final Bitmap bitmap = BitmapFactory.decodeStream(is);
//                callback.onPicLoaded(bitmap);
//
//
//            }
//        });
//
//    }
}
