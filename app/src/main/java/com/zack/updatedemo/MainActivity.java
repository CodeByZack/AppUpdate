package com.zack.updatedemo;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zack.appupdate.AppUpdate;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String dirFilePath = "";
        if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())){
            //SD卡有用
            dirFilePath = getExternalFilesDir("apk/test.apk").getAbsolutePath();
        }else{
            //SD卡没有用
            dirFilePath = getFilesDir()+ File.separator+"apk/test.apk";
        }
        AppUpdate.init(this)
                .setDownloadUrl("https://github.com/Justson/AgentWeb/raw/master/agentweb.apk")
                .setForceUpdate(true)
                .setSavePath(dirFilePath)
                .showUpdateDialog("检查到有更新！","本次更新版本1.1.1",null);

    }
}
