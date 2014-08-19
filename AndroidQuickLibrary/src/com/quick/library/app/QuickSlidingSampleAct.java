package com.quick.library.app;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.android.http.LoadControler;
import com.android.http.RequestManager.RequestListener;
import com.quick.library.QuickSlidingActivity;
import com.quick.library.QuickToolHelper;

public class QuickSlidingSampleAct extends QuickSlidingActivity implements RequestListener {
	
	public LoadControler mLoadControler;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.slide_right, R.layout.slide_left);

		findViewById(R.id.show).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				getSlidingMenu().showMenu();
			}
		});
		
		this.mLoadControler = get("http://www.baidu.com/", this, 0);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (isSlidingMenuOpen()) {
				getSlidingMenu().toggle();
				return true;
			}

			DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					if (arg1 == DialogInterface.BUTTON_POSITIVE) {
						QuickToolHelper.appExit();
					}
				}
			};
			QuickToolHelper.showDialog(this, "exit app?", listener, false);
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onSuccess(String result, String url, int actionId) {
		System.out.println("on Success");
	}

	@Override
	public void onError(String url, String error, int arg2) {
		System.out.println("on Error");
	}

	@Override
	public void onRequest() {
		System.out.println("on Request start");
	}

}