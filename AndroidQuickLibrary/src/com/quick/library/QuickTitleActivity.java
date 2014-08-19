package com.quick.library;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.android.http.LoadControler;
import com.android.http.RequestManager.RequestListener;
import com.quick.library.app.R;

/**
 * 带QuickTitleManager的Activity基类
 * 
 * @author steven-pan
 * 
 */
public class QuickTitleActivity extends Activity  implements QuickResourceLoader{

	private QuickTitleManager mTitleManager = null;
	
	private ProgressDialog mProgressDialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	public void setContentView(int resId) {
		LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.quick_activity, null);
		ScrollView contentLayout = (ScrollView) layout.findViewById(R.id.quick_content_layout);
		contentLayout.addView(getLayoutInflater().inflate(resId, null));

		RelativeLayout titleLayout = (RelativeLayout) layout.findViewById(R.id.quick_title_layout);
		this.mTitleManager = new QuickTitleManager(QuickTitleActivity.this, titleLayout);

		super.setContentView(layout);
	}

	protected QuickTitleManager getTitleManager() {
		return mTitleManager;
	}

	/**
	 * show toast
	 * 
	 * @param resId
	 */
	public void showToast(int resId) {
		Toast.makeText(this, resId, Toast.LENGTH_SHORT).show();
	}

	/**
	 * show toast
	 * 
	 * @param text
	 */
	public void showToast(String text) {
		QuickToolHelper.showToast(this, text);
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
