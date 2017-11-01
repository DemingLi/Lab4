package com.example.deminglee.lab3;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.ImageView;

/**
 * Created by Deming Lee on 2017/10/31.
 */

public class StaticBroadcastReceiver extends BroadcastReceiver {
  private NotificationManager notificationManager;
  private static final String STATICACTION = "StaticFilter";
  @Override
  public void onReceive(Context context, Intent intent) {
    if(intent.getAction().equals(STATICACTION)) {
      Bundle bundle = intent.getExtras();
      
      Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("image"));
      //获取通知栏管理
      notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
      //实例化通知栏构造器
      Notification.Builder notification = new Notification.Builder(context);
      //对notification进行配置
      notification.setContentTitle("新商品热卖！！！")//设置标题
              .setContentText(bundle.getString("name") + "仅售" + bundle.getString("price") + "!")
              .setSmallIcon(R.drawable.shoplist)
              .setLargeIcon(bitmap)
              .setWhen(System.currentTimeMillis())
              .setTicker("您有一条新消息")
              .setAutoCancel(true);
      
      //绑定Intent
      Intent myIntent = new Intent(context, DetailActivity.class);
      myIntent.putExtra("name", bundle.getString("name"));
      myIntent.putExtra("price", bundle.getString("price"));
      myIntent.putExtra("Info", bundle.getString("Info"));
      PendingIntent mPendingIntent = PendingIntent.getActivity(context, 0, myIntent, PendingIntent.FLAG_ONE_SHOT);
      notification.setContentIntent(mPendingIntent);
      Notification notification1 = notification.build();
      notificationManager.notify(0, notification1);
    }
  }
}
