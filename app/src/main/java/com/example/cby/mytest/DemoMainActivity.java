package com.example.cby.mytest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by chenbiyue on 2019/10/30.
 */

public class DemoMainActivity extends Activity implements ItemOnClickListener  {
    @BindView(R.id.demo_main_recycleview)
    RecyclerView recyclerView;

    private List<String> list;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo_main_activity);
        JPushInterface.init(this);
        CustomPushNotificationBuilder builder = new
                CustomPushNotificationBuilder(this,
                R.layout.customer_notitfication_layout,
                R.id.icon,
                R.id.title,
                R.id.text,
                R.id.time);
        // 指定定制的 Notification Layout
        builder.statusBarDrawable = R.drawable.ic_launcher;
        // 指定最顶层状态栏小图标
        builder.layoutIconDrawable = R.drawable.jpush_ic_richpush_actionbar_back;
        // 指定下拉状态栏时显示的通知图标
        JPushInterface.setPushNotificationBuilder(2, builder);

//        BasicPushNotificationBuilder builder = new BasicPushNotificationBuilder(this);
//        builder.statusBarDrawable = R.drawable.jpush_notification_icon;
//        builder.notificationFlags = Notification.FLAG_AUTO_CANCEL
//                | Notification.FLAG_SHOW_LIGHTS;  //设置为自动消失和呼吸灯闪烁
//        builder.notificationDefaults = Notification.DEFAULT_SOUND
//                | Notification.DEFAULT_VIBRATE
//                | Notification.DEFAULT_LIGHTS;  // 设置为铃声、震动、呼吸灯闪烁都要
//        JPushInterface.setPushNotificationBuilder(1, builder);

        initData();
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(new DemoMainAdapter(this,list));

    }

    private void initData() {
        list = new ArrayList<>();
        list.add("1.ImageLoader的使用");

    }


    @Override
    public void onItemClick(View view, int position) {
        position+=1;
        Toast.makeText(this,"Tag:"+view.getTag()+"``````position:"+position,Toast.LENGTH_LONG).show();

        switch(position){
            case 1:

                break;
        }
    }

    private void mStartActivity( Class<?> cls){
        Intent intent = new Intent();
        intent.setClass(this,cls);
        startActivity(intent);
    }

}
