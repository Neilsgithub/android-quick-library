package com.quick.library;

import com.android.http.LoadControler;
import com.android.http.RequestManager.RequestListener;

/** 
 * description：   QuickResourceLoader
 * @author  steven-pan
 * @date    2014年8月19日
 * @version 1.0
 */
public interface QuickResourceLoader {
	
	public LoadControler get(String url, RequestListener requestListener, int actionId) ;
	
	public LoadControler post(String url, String data, RequestListener requestListener, int actionId) ;
}
