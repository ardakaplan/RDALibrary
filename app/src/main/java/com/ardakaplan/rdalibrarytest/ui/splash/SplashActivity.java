package com.ardakaplan.rdalibrarytest.ui.splash;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.RDAButtonClickListener;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.RDADialog;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.RDADialogButtonType;
import com.ardakaplan.rdalibrary.base.ui.screen.presenters.RDAPresenterContract;
import com.ardakaplan.rdalibrary.managers.LanguageManager;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.ui.BaseActivity;
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

    @OnClick(R.id.splash_activity_button_fragmentTest)
    void clickedFragmentTest() {

        startActivity(new Intent(this, FragmentTestActivity.class));
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

        RDADialog.showDialog(this, "TITLE",
                "MESSAGE",
                "POSITIVE",
                "NEGATIVE",
                "NEUTRAL",
                null,
                false,
                new RDAButtonClickListener() {
                    @Override
                    public void onClick(RDADialog rdaDialog, RDADialogButtonType RDADialogButtonType) {

                        rdaDialog.dismiss();

                        switch (RDADialogButtonType) {

                            case POSITIVE:

                                RDALogger.info("POSITIVE CLICKED");

                                break;

                            case NEGATIVE:

                                RDALogger.info("NEGATIVE CLICKED");

                                break;

                            case NEUTRAL:

                                RDALogger.info("NEUTRAL CLICKED");

                                break;

                        }

                    }
                }
        );
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
