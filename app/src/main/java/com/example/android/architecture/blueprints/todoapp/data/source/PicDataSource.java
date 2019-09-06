package com.example.android.architecture.blueprints.todoapp.data.source;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;

public interface PicDataSource {
    interface GetHttpPicCallback{
        void onPicLoaded(Bitmap bitmap);
    }
    void getHttpPic(@NonNull String url,@NonNull GetHttpPicCallback callback);
}
