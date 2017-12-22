package com.example.cuipengyu.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * 普通通知的使用
 * Created by cuipengyu on 2017/12/22.
 */

public class MyNotification {
    private static MyNotification getMyNotification;
    private static Context mContext;


    public static MyNotification getInstance(Context context) {
        if (getMyNotification == null) {
            mContext = context;
            getMyNotification = new MyNotification();
        }
        return getMyNotification;
    }

    public void setNotification(Intent intent, String Title, String ContentText, int Icon, int id) {
        Log.e("id:", id + "");
        //获取管理器
        NotificationManager mManager = (NotificationManager) mContext.getSystemService(NOTIFICATION_SERVICE);
        //创建Notification对象
        Notification.Builder mBuilder = new Notification.Builder(mContext);
        /**
         * 小图标，通过 setSmallIcon() 方法设置
         标题，通过 setContentTitle() 方法设置
         内容，通过 setContentText() 方法设置
         */
        mBuilder.setContentTitle(Title)
                .setContentText(ContentText)
                .setContentIntent(getDefalutIntent(Notification.FLAG_NO_CLEAR, id, intent))
                .setWhen(System.currentTimeMillis())//设置通知时间，获取系统时间
                .setAutoCancel(true)//单击面板自动取消通知
                .setOngoing(true)//设置他是一个正在进行任务的通知
                .setSmallIcon(Icon);//设置图标
        Notification notification = mBuilder.build();
        mManager.notify(id++, notification);
    }

    /**
     * @param flag Notification.FLAG_SHOW_LIGHTS              //三色灯提醒，在使用三色灯提醒时候必须加该标志符
     *             Notification.FLAG_ONGOING_EVENT          //发起正在运行事件（活动中）
     *             Notification.FLAG_INSISTENT   //让声音、振动无限循环，直到用户响应 （取消或者打开）
     *             Notification.FLAG_ONLY_ALERT_ONCE  //发起Notification后，铃声和震动均只执行一次
     *             Notification.FLAG_AUTO_CANCEL      //用户单击通知后自动消失
     *             Notification.FLAG_NO_CLEAR          //只有全部清除时，Notification才会清除 ，不清楚该通知(QQ的通知无法清除，就是用的这个)
     *             Notification.FLAG_FOREGROUND_SERVICE    //表示正在运行的服务
     * @return
     */
    private static PendingIntent getDefalutIntent(int flag, int id, Intent mIntent) {
        PendingIntent intent = PendingIntent.getActivity(mContext, id, mIntent, flag);
        return intent;
    }
}
