package com.horical.hrc7.lib_base.notification;

import android.app.Activity;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

/**
 * Created by HRC7 on 7/7/2017.
 */

public class Alert {
    public static class Builder {

        private final Context context;
        private int smallIcon;
        private String title;
        private String contentText;
        private boolean autoCancel;
        private Uri sound;
        private Intent intent;

        private NotificationCompat.Builder notificationBuilder;
        private Class<Activity> clazz;

        public Builder(Context context) {
            this.context = context;
            notificationBuilder = new NotificationCompat.Builder(context);
        }

        public Alert.Builder setSmallIcon(int smallIcon) {
            this.smallIcon = smallIcon;
            notificationBuilder.setSmallIcon(smallIcon);
            return this;
        }

        public Alert.Builder setTitle(String title) {
            this.title = title;
            notificationBuilder.setContentTitle(title);
            return this;
        }

        public Alert.Builder setContentText(String contentText) {
            this.contentText = contentText;
            notificationBuilder.setContentText(contentText);
            return this;
        }

        public Alert.Builder setAutoCancel(boolean autoCancel) {
            this.autoCancel = autoCancel;
            notificationBuilder.setAutoCancel(autoCancel);
            return this;
        }

        public Alert.Builder setSound(Uri sound) {
            this.sound = sound;
            notificationBuilder.setSound(sound);
            return this;
        }

        public Alert.Builder useSoundDefault() {
            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            notificationBuilder.setSound(sound);
            return this;
        }

        public Alert.Builder setStartActivity(Class clazz) {
            this.clazz = clazz;
            this.intent = new Intent(context, clazz);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent,
                    PendingIntent.FLAG_ONE_SHOT);
            notificationBuilder.setContentIntent(pendingIntent);
            return this;
        }

        public void show() {
            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.notify(0, notificationBuilder.build());
        }
    }
}
