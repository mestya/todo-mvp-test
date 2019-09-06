package com.example.android.architecture.blueprints.todoapp.gethttppic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.os.Handler;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.android.architecture.blueprints.todoapp.data.source.PicDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class HttpPicPresenter implements HttpPicContract.Presenter, PicDataSource.GetHttpPicCallback {

    private final HttpPicContract.View mHttpPicView;
    private final PicDataSource mPicDataSource;

    public HttpPicPresenter(@NonNull HttpPicContract.View httpPicView,@NonNull PicDataSource picDataSource) {
        mHttpPicView = checkNotNull(httpPicView, "httpPicView cannot be null!");
        mPicDataSource = checkNotNull(picDataSource,"mPicDataSource cannot be null");
        mHttpPicView.setPresenter(this);
    }
    @Override
    public void start() {
        openHttpPic();
    }

    @Override
    public void onPicLoaded(final Bitmap bitmap) {
            if(null == bitmap){
                Log.d("HttpPicPresenter","bitmap为空");
                return;
            }else {
                mHttpPicView.loadPic(bitmap);
            }

    }

    private void openHttpPic(){
        String url = "https://www.baidu.com/img/bd_logo1.png";
        mPicDataSource.getHttpPic(url, this);
    }


}
