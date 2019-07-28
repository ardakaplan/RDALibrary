package com.ardakaplan.rdalibrarytest.ui.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.ButtonClickListener;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.ButtonType;
import com.ardakaplan.rdalibrary.base.ui.dialogs.rdaDialog.RDADialog;
import com.ardakaplan.rdalibrary.base.ui.screen.RDAActivity;
import com.ardakaplan.rdalibrary.helpers.RDAAESCryptionHelper;
import com.ardakaplan.rdalibrarytest.R;
import com.ardakaplan.rdalibrarytest.ui.filetest.FileTestActivity;
import com.ardakaplan.rdalibrarytest.ui.language.LanguageTestActivity;
import com.ardakaplan.rdalogger.RDALogger;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.inject.Inject;

import butterknife.OnClick;

public class SplashActivity extends RDAActivity implements SplashContract.SplashViewContract {

    @Inject
    SplashContract.SplashPresenterContract presenter;

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState, R.layout.activity_splash);

        presenter.attach(this);

        encryptTest();
    }

    private void encryptTest() {

        String source = "Arda KaplanĞÜŞİÖÇğüşiöç";

        try {
            String encrypt = RDAAESCryptionHelper.encrypt("112312321312", source);

            RDALogger.info(encrypt);

            decryptTest(encrypt);

        } catch (GeneralSecurityException e) {

            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }
    }

    private void decryptTest(String encryptedText) {

        try {

            String decrypt = RDAAESCryptionHelper.decrypt("112312321312", encryptedText);

            RDALogger.info(decrypt);

        } catch (GeneralSecurityException e) {

            e.printStackTrace();

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();
        }
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

        RDADialog.showDialog(this, R.style.Theme_Dialog, "TITLE",
                "MESSAGE",
                "POSITIVE",
                "NEGATIVE",
                "NEUTRAL",
                0,
                false,
                new ButtonClickListener() {
                    @Override
                    public void onClick(RDADialog rdaDialog, ButtonType buttonType) {

                        rdaDialog.dismiss();

                        switch (buttonType) {

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
    protected void onDestroy() {
        super.onDestroy();

        presenter.detach();
    }
}
