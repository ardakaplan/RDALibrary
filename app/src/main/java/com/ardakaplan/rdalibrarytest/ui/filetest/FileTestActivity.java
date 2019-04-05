package com.ardakaplan.rdalibrarytest.ui.filetest;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.ardakaplan.rdalibrary.base.files.RDAFile;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.File;

import javax.inject.Inject;

import butterknife.OnClick;

public class FileTestActivity extends RDAActivity {

    @Inject
    ApplicationFolder applicationFolder;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.file_test_activity);
    }

    @OnClick(R.id.fileTestActivity_button_createRootFolder)
    void test() {

        requestWritePermission();
    }

    private void requestWritePermission() {

        if (isStoragePermissionGranted()) {

            createFolder();
        }
    }

    private void createFolder() {

        try {

            File file = applicationFolder.getFile();

            RDALogger.info("APP FOLDER " + file.getAbsolutePath());

        } catch (RDAFile.FileNotCreatedInteractionException e) {

            e.printStackTrace();
        }
    }


    public boolean isStoragePermissionGranted() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {


                RDALogger.info("Permission is granted");
                return true;
            } else {

                RDALogger.info("Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else {
            RDALogger.info("Permission is granted");
            return true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            RDALogger.info("Permission: " + permissions[0] + "was " + grantResults[0]);

            createFolder();
        }
    }
}
