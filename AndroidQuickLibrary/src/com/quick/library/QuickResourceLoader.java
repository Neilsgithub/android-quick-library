package com.quick.library;

import com.android.http.LoadControler;
import com.android.http.RequestManager.RequestListener;

/**
 * description： QuickResourceLoader
 * 
 * @author steven-pan
 * @date 2014年8月19日
 * @version 1.0
 */
public interface QuickResourceLoader {

	/**
	 * load String resource from network by GET method
	 * 
	 * @param url
	 *            tartget url
	 * @param requestListener
	 *            request listener for callback
	 * @param actionId
	 *            request id
	 * @return
	 */
	public LoadControler get(String url, RequestListener requestListener, int actionId);

	/**
	 * load String resource from network by POST method
	 * 
	 * @param url
	 *            tartget url
	 * @param data
	 *            postBody
	 * @param requestListener
	 *            request listener for callback
	 * @param actionId
	 *            request id
	 * @return
	 */
	public LoadControler post(String url, String data, RequestListener requestListener, int actionId);
	
}
