package com.zijin.usbcamera;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.zijin.camera_lib.CameraActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_start_camera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CameraActivity.start4Login(MainActivity.this, "1280_720", "http://10.2.72.10:8080/");
                Camera2Activity.start(MainActivity.this);
           }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CameraActivity.REQ_START_CAMERA && resultCode == RESULT_OK && data != null) {
            Bundle extras = data.getExtras();
            if (extras != null) {
                String response = extras.getString("response", "");
                Log.i("wk", "登录成功后的响应信息:");
                Log.i("wk", response);
            } else {
                Log.i("wk", "extras is null");
            }
        } else {
            Log.i("wk", "被取消了");
        }
    }
}