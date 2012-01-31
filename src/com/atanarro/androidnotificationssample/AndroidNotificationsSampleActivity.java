/*
 * Copyright (C)  2011  Álvaro Tanarro Santamaría.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.atanarro.androidnotificationssample;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

/**
 * Class to test de Notifications
 * 
 * @author atanarro
 * 
 */
public class AndroidNotificationsSampleActivity extends Activity {

	private NotificationManager mNotificationManager;
	private int NOTFICATION_ID = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

		sendNotification();
		//cancelNotification();

	}

	private void sendNotification() {
		int icon = R.drawable.icon;
		CharSequence tickerText = getResources().getString(R.string.app_name);
		long when = System.currentTimeMillis();

		Notification notification = new Notification(icon, tickerText, when);

		// use the default notification vibrate (requires the VIBRATE
		// permission)
		notification.defaults |= Notification.DEFAULT_VIBRATE;

		// use the default notification sound
		notification.defaults |= Notification.DEFAULT_SOUND;

		// use the default notification lights
		notification.defaults |= Notification.DEFAULT_LIGHTS;

		// notification is canceled when it is clicked by the user
		notification.flags |= Notification.FLAG_AUTO_CANCEL;

		// the audio will be repeated until the notification is cancelled or the
		// notification window is opened
		notification.flags |= Notification.FLAG_INSISTENT;

		CharSequence contentTitle = "Notification Title";
		CharSequence contentText = "Notification text";

		Intent notifyIntent = new Intent(this,
				AndroidNotificationsSampleActivity.class);

		PendingIntent intent = PendingIntent.getActivity(
				AndroidNotificationsSampleActivity.this, 0, notifyIntent,
				android.content.Intent.FLAG_ACTIVITY_NEW_TASK);

		notification
				.setLatestEventInfo(this, contentTitle, contentText, intent);

		mNotificationManager.notify(NOTFICATION_ID, notification);

	}

	private void cancelNotification() {
		mNotificationManager.cancel(NOTFICATION_ID);	
	}
	
}