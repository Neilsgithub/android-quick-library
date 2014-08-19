package com.quick.library.app;

import android.os.Bundle;
import android.view.View;

import com.android.http.LoadControler;
import com.android.http.RequestManager.RequestListener;
import com.quick.library.QuickTitleActivity;

public class QuictTitleSampleAct extends QuickTitleActivity implements RequestListener {
	
	public LoadControler mLoadControler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quick_activity_sample);

		setTitle();

		this.mLoadControler = get("http://www.baidu.com/", this, 0);
	}

	private void setTitle() {
		getTitleManager().setTitle("hello world", true).setOptionView(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				showToast("asfad");
			}
		}).commit();
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
