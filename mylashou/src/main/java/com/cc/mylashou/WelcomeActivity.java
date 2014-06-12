package com.cc.mylashou;

import com.cc.mylashou.util.ToolKits;

import roboguice.activity.RoboActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;

public class WelcomeActivity extends RoboActivity {

	//是否第一次使用这个app
	public static final String IS_FIRST = "is_first";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_welcome);

		new Handler(new Callback() {
			public boolean handleMessage(Message msg) {
				if (ToolKits.fetchBoolean(WelcomeActivity.this, IS_FIRST, true)) {
					ToolKits.putBoolean(WelcomeActivity.this, IS_FIRST, false);
					startActivity(new Intent(WelcomeActivity.this,
							WhatsNewActivity.class));
					finish();
				} else {
					startActivity(new Intent(WelcomeActivity.this,
							MainActivity.class));
					finish();
				}
				return true;
			}
		}).sendEmptyMessageDelayed(0, 3000);
	}
}
