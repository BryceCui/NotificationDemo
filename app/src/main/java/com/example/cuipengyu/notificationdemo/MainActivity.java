package com.example.cuipengyu.notificationdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.app.Notification.VISIBILITY_PUBLIC;

public class MainActivity extends AppCompatActivity {
    int id = 1;
    Button button;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.btn_send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                id++;
                String title = "这是通知标题";
                String con = "这是通知内容";
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                MyNotification.getInstance(MainActivity.this).setNotification(intent, title, con, R.mipmap.ic_launcher, id);
            }
        });

    }


}
