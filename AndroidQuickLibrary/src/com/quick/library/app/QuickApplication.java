package com.quick.library.app;

import android.app.Application;

import com.android.http.RequestManager;
import com.quick.library.QuickLogger;

public class QuickApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		QuickLogger.setOutput(true);
		RequestManager.getInstance().init(this);
	}

	@Override
	public void onTerminate() {
		super.onTerminate();
	}
	
}