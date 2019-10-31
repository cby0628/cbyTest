package com.example.cby.mytest;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;


/**
 * Created by chenbiyue on 2019/10/30.
 */

public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImagerLoader(getApplicationContext());
    }

    /**
     * 初始化ImageLoader的配置
     * @param applicationContext
     */
    private void initImagerLoader(Context applicationContext) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true).cacheOnDisk(true).build();

      //threadPriority ,denyCacheImageMultipleSizesInMemory()；
        //
        ImageLoaderConfiguration configuration =new ImageLoaderConfiguration.Builder(applicationContext)
                .defaultDisplayImageOptions(options)
                .threadPriority(Thread.NORM_PRIORITY-2)//线程优先权
                .denyCacheImageMultipleSizesInMemory()//不能存储内容相同大小不同的图像
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) //设置磁盘缓存文件名称
                .tasksProcessingOrder(QueueProcessingType.LIFO)// 设置加载显示图片队列进程
               // .discCache() // 文件缓存目录
                .build();

        ImageLoader.getInstance().init(configuration);

    }
}
