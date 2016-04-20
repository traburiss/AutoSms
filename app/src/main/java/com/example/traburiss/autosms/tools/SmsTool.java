package com.example.traburiss.autosms.tools;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.SmsManager;

import com.example.traburiss.autosms.constant.Constant;

/**
 * @author traburiss
 * @date 2016/3/11
 * @info AutoSms
 * @desc
 */
public class SmsTool {

    public static void MsgSend(String Msg , String PhoneNum, Context context) {

        //发送信息
        Intent iSend = new Intent(Constant.SMS_S_A);
        Intent iDeliver = new Intent(Constant.SMS_D_A);
        PendingIntent SPI = PendingIntent.getBroadcast(context, 0, iSend, 0);
        PendingIntent DPI = PendingIntent.getBroadcast(context, 0, iDeliver, 0);
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(PhoneNum, null, Msg	,SPI ,DPI);

        //保存发送信息
        ContentValues values = new ContentValues();
        values.put("address", PhoneNum);
        values.put("person", "");
        values.put("protocol", "0");
        values.put("read", "1");
        values.put("status", "-1");
        values.put("body", Msg);
        context.getContentResolver().insert(Uri.parse("content://sms/sent"), values);
    }

}
