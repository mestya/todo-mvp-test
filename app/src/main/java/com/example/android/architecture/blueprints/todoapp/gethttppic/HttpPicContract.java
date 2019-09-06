package com.example.android.architecture.blueprints.todoapp.gethttppic;

import android.graphics.Bitmap;

import com.example.android.architecture.blueprints.todoapp.BasePresenter;
import com.example.android.architecture.blueprints.todoapp.BaseView;

public interface HttpPicContract {
    interface View extends BaseView<Presenter> {

       void loadPic(Bitmap bitmap);

    }

    interface Presenter extends BasePresenter {

    }
}
