package com.example.android.architecture.blueprints.todoapp.gethttppic;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android.architecture.blueprints.todoapp.R;

import static com.google.common.base.Preconditions.checkNotNull;

public class HttpPicFragment extends Fragment implements HttpPicContract.View {
    public static final int MSG_LOAD = 1;

    @NonNull
    private ImageView mImageView;
    private HttpPicContract.Presenter mPresenter;
    public  static HttpPicFragment newInstance(){return new HttpPicFragment();}

    @Override
    public void setPresenter(@NonNull HttpPicContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_get_http_pic,container,false);
        mImageView = (ImageView)root.findViewById(R.id.picContainer);
        return root;
    }
    @Override
    public void loadPic(final Bitmap bitmap) {
        Message message = handler.obtainMessage(MSG_LOAD);
        message.obj = bitmap;
        handler.sendMessage(message);
//        getActivity().runOnUiThread(new Runnable() {
//            @Override
//            public void run() {
//                mImageView.setImageBitmap(bitmap);}
//            });


    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_LOAD:
                    Bitmap bitmap = (Bitmap) msg.obj;
                    mImageView.setImageBitmap(bitmap);
                    break;
            }
        }
    };

}
