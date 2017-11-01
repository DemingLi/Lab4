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

/**
 * Created by Deming Lee on 2017/10/31.
 */

public class DynamicBroadcastReceiver extends BroadcastReceiver {
  private static final String DYNAMICACTION = "DynamicFilter";
  private NotificationManager notificationManager;
  @Override
  public void onReceive(Context context, Intent intent) {
    if(intent.getAction().equals(DYNAMICACTION)) {
      Bundle bundle = intent.getExtras();
      int image = 0;
      switch (bundle.getString("name")) {
        case "Enchated Forest":
          image = R.drawable.enchatedforest;
          break;
        case "Arla Milk":
          image = R.drawable.arla;
          break;
        case "Devondale Milk":
          image = R.drawable.devondale;
          break;
        case "Kindle Oasis":
          image = R.drawable.kindle;
          break;
        case "waitrose 早餐麦片":
          image = R.drawable.waitrose;
          break;
        case "Mcvitie's 饼干":
          image = R.drawable.mcvitie;
          break;
        case "Ferrero Rocher":
          image = R.drawable.ferrero;
          break;
        case "Maltesers":
          image = R.drawable.maltesers;
          break;
        case "Lindt":
          image = R.drawable.lindt;
          break;
        case "Borggreve":
          image = R.drawable.borggreve;
          break;
      }
      Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), image);
      //获取通知栏管理
      notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
      //实例化通知栏构造器
      Notification.Builder notification = new Notification.Builder(context);
      //对notification进行配置
      notification.setContentTitle("马上下单")//设置标题
              .setContentText(bundle.getString("name") + "已添加到购物车")
              .setSmallIcon(R.drawable.shoplist)
              .setLargeIcon(bitmap)
              .setAutoCancel(true);
      Intent myIntent = new Intent(context, MainActivity.class);
      myIntent.putExtra("add_in_shoplist", "yes");
      PendingIntent mPendingIntent = PendingIntent.getActivity(context, 0, myIntent, PendingIntent.FLAG_ONE_SHOT);
      notification.setContentIntent(mPendingIntent);
      Notification notification1 = notification.build();
      notificationManager.notify((int)System.currentTimeMillis(), notification1);
    }
  }
}
