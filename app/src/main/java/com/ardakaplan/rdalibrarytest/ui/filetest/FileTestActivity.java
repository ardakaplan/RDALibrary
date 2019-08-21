package com.ardakaplan.rdalibrarytest.ui.filetest;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.ardakaplan.rdalibrary.base.files.RDAFileProperty;
import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.base.ui.screen.views.RDAActivity;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.ui.filetest.data.ApplicationFolder;
import com.ardakaplan.rdalibrarytest.ui.filetest.data.InnerFolder;
import com.ardakaplan.rdalibrarytest.ui.filetest.data.TestTextProperty;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.File;
import java.io.IOException;

import javax.inject.Inject;

import butterknife.OnClick;

public class FileTestActivity extends RDAActivity {

    @Inject
    ApplicationFolder applicationFolder;

    @Inject
    InnerFolder innerFolder;

    @Inject
    TestTextProperty testTextProperty;

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

            File rootFolder = applicationFolder.getFile();

            RDALogger.info("APP FOLDER " + rootFolder.getAbsolutePath());

            File innerFile = innerFolder.getFile();

            RDALogger.info("INNER FOLDER " + innerFile.getAbsolutePath());


            testTextProperty.setText("ARDA KAPLAN");

            try {

                File txtFile = testTextProperty.createFile();

                RDALogger.info("TEXT FILE -> " + txtFile.getAbsolutePath());

            } catch (IOException e) {

                e.printStackTrace();
            }


        } catch (RDAFileProperty.FileNotCreatedInteractionException e) {

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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            RDALogger.info("Permission: " + permissions[0] + "was " + grantResults[0]);

            createFolder();
        }
    }

    @Override
    public int getLayout() {
        return R.layout.file_test_activity;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return null;
    }
}
