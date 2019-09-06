package com.example.android.architecture.blueprints.todoapp.gethttppic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.architecture.blueprints.todoapp.R;
import com.example.android.architecture.blueprints.todoapp.data.source.remote.PicRemoteDataSource;
import com.example.android.architecture.blueprints.todoapp.util.ActivityUtils;

public class GetHttpPicActivity extends AppCompatActivity {

    private  Button mButton;
    private HttpPicPresenter mHttpPicPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_http_pic);

        HttpPicFragment picContainerFrag = (HttpPicFragment)getSupportFragmentManager()
                .findFragmentById(R.id.picFrame);
        if(picContainerFrag == null){
            picContainerFrag = picContainerFrag.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    picContainerFrag, R.id.picFrame);
        }
        new HttpPicPresenter(picContainerFrag,new PicRemoteDataSource());





    }
}
