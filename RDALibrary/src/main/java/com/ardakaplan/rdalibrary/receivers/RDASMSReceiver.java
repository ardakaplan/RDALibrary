package com.ardakaplan.rdalibrary.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

import com.ardakaplan.rdalibrary.logger.RDALogger;


/**
 * Created by ardakaplan on 18/07/16.
 * <p/>
 * www.ardakaplan.com
 * <p/>
 * arda.kaplan09@gmail.com
 */
@SuppressWarnings("ConstantConditions")
public abstract class RDASMSReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        RDALogger.debug("onReceive");

        if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {

            Bundle bundle = intent.getExtras();
            SmsMessage[] smsMessages;
            if (bundle != null) {

                Object[] pdus = (Object[]) bundle.get("pdus");

                smsMessages = new SmsMessage[pdus.length];

                String messageFromWhomString = "";
                StringBuilder messageBodyString = new StringBuilder();

                for (int i = 0; i < smsMessages.length; i++) {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);

                    messageFromWhomString = smsMessages[i].getOriginatingAddress();
                    messageBodyString.append(smsMessages[i].getMessageBody());
                }
                whenSMSComing(context, messageFromWhomString, messageBodyString.toString(), smsMessages[0].getTimestampMillis());
            }
        }
    }

    public abstract void whenSMSComing(Context context, String phoneNoString, String bodyString, long dateString);


}