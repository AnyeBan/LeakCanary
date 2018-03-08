# LeakCanary
android内存泄露检测工具
用来检测在编程过程中可能出现的内存泄露的情况
这篇文章介绍了几种会出现内存泄露的情况以及相应的解决办法
http://www.jb51.net/article/97694.htm

加入LeakCanary只需要3步骤

1,添加依赖
dependencies {
    compile fileTree(dir: 'libs', include: ['*.jar'])
    testCompile 'junit:junit:4.12'
    compile 'com.android.support:appcompat-v7:+'

    //添加leakcanary相关的依赖
    //在release和test版本中，使用的是LeakCanary的no-op版本，也就是没有实际代码和操作的Wrapper版本，只包含LeakCanary和RefWatcher类的空实现，这样不    会对生成的APK包体积和应用性能造成影响
    debugCompile 'com.squareup.leakcanary:leakcanary-android:1.5'
    releaseCompile 'com.squareup.leakcanary:leakcanary-android-no-op:1.5'
    testCompile 'com.squareup.leakcanary:leakcanary-android-no-op:1.5'
}

MyApplication,并且在manifest里声明

  <application
        android:name=".MyApplication"
        android:allowBackup="true"
        android:icon="@mipmap/ic_launcher"
        
3在MyApplication里初始化

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化LeakCanary
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
    }
}
这样就可以了。
