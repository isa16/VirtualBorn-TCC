package com.virtualbornapp;

import android.app.Application;

import com.facebook.react.ReactApplication;
import com.emekalites.react.alarm.notification.ANPackage;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;
import com.zmxv.RNSound.RNSoundPackage;
import android.app.NotificationManager;
import android.app.NotificationChannel;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;

import java.util.Arrays;
import java.util.List;

public class MainApplication extends Application implements ReactApplication {

  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new ANPackage(),
          new RNSoundPackage() 

      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    String id = "12345";					// The id of the channel. 
    CharSequence name = "VirtualBorn";			// The user-visible name of the channel. 
    String description = "Seu bebe precisa de cuidados";	// The user-visible description of the channel. 
 
    if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
      NotificationChannel mChannel = new NotificationChannel(id, name, NotificationManager.IMPORTANCE_DEFAULT);
 
      // Configure the notification channel.  
      mChannel.setDescription(description);
 
      mChannel.enableLights(true);
      // Sets the notification light color for notifications posted to this 
      // channel, if the device supports this feature.  
 
      mChannel.enableVibration(true);
      mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
 
      NotificationManager mNotificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
      mNotificationManager.createNotificationChannel(mChannel);
    }
    SoLoader.init(this, /* native exopackage */ false);
  }
}
