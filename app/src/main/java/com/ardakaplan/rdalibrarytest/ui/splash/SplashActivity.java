package com.ardakaplan.rdalibrarytest.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.helpers.RDADeviceHelpers;
import com.ardakaplan.rdalibrary.managers.LanguageManager;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.ui.BaseActivity;
import com.ardakaplan.rdalibrarytest.ui.ThemeTestActivity;
import com.ardakaplan.rdalibrarytest.ui.filetest.FileTestActivity;
import com.ardakaplan.rdalibrarytest.ui.fragmentscenerio.FragmentTestActivity;
import com.ardakaplan.rdalibrarytest.ui.language.LanguageTestActivity;
import com.ardakaplan.rdalogger.RDALogger;

import javax.inject.Inject;

import butterknife.OnClick;

public class SplashActivity extends BaseActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @Inject
    LanguageManager languageManager;
    @Inject
    RDADeviceHelpers rdaDeviceHelpers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        encryptTest();
    }

//    private void encryptTest() {
//
//        String source = "Arda KaplanĞÜŞİÖÇğüşiöç";
//
//        try {
//            String encrypt = RDAAESCryptionHelper.encrypt("112312321312", source);
//
//            RDALogger.info(encrypt);
//
//            decryptTest(encrypt);
//
//        } catch (GeneralSecurityException e) {
//
//            e.printStackTrace();
//
//        } catch (UnsupportedEncodingException e) {
//
//            e.printStackTrace();
//
//        }
//    }

//    private void decryptTest(String encryptedText) {
//
//        try {
//
//            String decrypt = RDAAESCryptionHelper.decrypt("112312321312", encryptedText);
//
//            RDALogger.info(decrypt);
//
//        } catch (GeneralSecurityException e) {
//
//            e.printStackTrace();
//
//        } catch (UnsupportedEncodingException e) {
//
//            e.printStackTrace();
//        }
//    }

    @OnClick(R.id.splash_activity_button_screenDensity)
    void clickedScreenDensity() {

        RDALogger.info("SCREEN DENSITY : " + rdaDeviceHelpers.getScreenDensity());

        String toast = "DENSITY " + rdaDeviceHelpers.getScreenDensity() + "\n" +
                "FOLDER " + getString(R.string.folder_name);

        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.splash_activity_button_fragmentTest)
    void clickedFragmentTest() {

        startActivity(new Intent(this, FragmentTestActivity.class));
    }

    @OnClick(R.id.splash_activity_button_themeTest)
    void clickedThemeTest() {

        startActivity(new Intent(this, ThemeTestActivity.class));
    }

    @OnClick(R.id.splash_activity_button_fileTest)
    void clickedFileTest() {

        startActivity(new Intent(this, FileTestActivity.class));
    }

    @OnClick(R.id.splash_activity_button_languageTest)
    void clickedLanguageTest() {

        startActivity(new Intent(this, LanguageTestActivity.class));
    }

    @OnClick(R.id.splash_activity_button_dialogTest)
    void clickedDialogTest() {

    }

    @OnClick(R.id.continious)
    void continous() {

        RDALogger.info("BURDA");
    }

    @Override
    public int getLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public RDAPresenterContract getPresenterContract() {
        return presenter;
    }
}
