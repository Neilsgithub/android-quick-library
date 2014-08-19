package com.quick.library;

import android.app.ProgressDialog;
import android.view.Window;

import com.android.http.LoadControler;
import com.android.http.RequestManager.RequestListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnClosedListener;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu.OnOpenedListener;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingActivity;
import com.quick.library.app.R;
/**
 * 左边侧滑Activity基类
 * 
 * @author steven-pan
 *
 */
public class QuickSlidingActivity extends SlidingActivity implements OnOpenedListener, OnClosedListener, QuickResourceLoader {
	
	private boolean isOpen = false;
	
	private ProgressDialog mProgressDialog = null;
	
	public void setContentView(int resId, int behindId) {
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.setBehindContentView(behindId);
		super.setContentView(resId);
		
		SlidingMenu sm = getSlidingMenu();// more option see PropertiesActivity sample
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setFadeDegree(0.35f);
		sm.setMode(SlidingMenu.LEFT);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);

		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		sm.setBehindWidth(200);
		sm.setBehindScrollScale(0.333f);

		setSlidingActionBarEnabled(false);

		getSlidingMenu().setOnOpenedListener(this);
		getSlidingMenu().setOnClosedListener(this);
	}
	
	@Override
	public void onOpened() {
		this.isOpen = true;
	}

	@Override
	public void onClosed() {
		this.isOpen = false;
	}

	public boolean isSlidingMenuOpen() {
		return this.isOpen;
	}

	public LoadControler get(String url, RequestListener requestListener, int actionId) {
		return QuickToolHelper.get(url, requestListener, actionId);
	}

	public LoadControler post(String url, String data, RequestListener requestListener, int actionId) {
		return QuickToolHelper.post(url, data, requestListener, actionId);
	}

	/**
	 * show progress dialog
	 * 
	 * @param message
	 *            message
	 * @param cancel
	 *            cancelable
	 */
	public void showDialog(String message) {
		if (isFinishing()) {
			return;
		}
		if (mProgressDialog == null) {
			mProgressDialog = ProgressDialog.show(this, "", message);
			mProgressDialog.setCanceledOnTouchOutside(false);
		} else {
			mProgressDialog.setMessage(message);
			mProgressDialog.show();
		}
	}

	public boolean isDialogShowing() {
		return (mProgressDialog != null && mProgressDialog.isShowing());
	}

	public void dismissDialog() {
		if (isFinishing()) {
			return;
		}
		if (mProgressDialog != null && mProgressDialog.isShowing()) {
			mProgressDialog.dismiss();
		}
	}
	
}
