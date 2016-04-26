package aves.deliveryapp.servicecall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

import aves.deliveryapp.utils.Constants;

public class AsyncInvokeURLTask extends AsyncTask<Void, Void, String> {

	private ArrayList<NameValuePair> mParams;
	private OnPostExecuteListener mPostExecuteListener = null;
	private String mSubUrl = null;

	public static interface OnPostExecuteListener {
		void onPostExecute(String result);
	}

	public AsyncInvokeURLTask(ArrayList<NameValuePair> nameValuePairs,
			String subUrl, OnPostExecuteListener postExecuteListener)
			throws Exception {

		mParams = nameValuePairs;
		mSubUrl = subUrl;
		mPostExecuteListener = postExecuteListener;
		if (mPostExecuteListener == null)
			throw new Exception("Param cannot be null.");
	}

	@Override
	protected String doInBackground(Void... params) {

		String result = "";

		// Create a new HttpClient and Post Header
		HttpClient httpclient = new DefaultHttpClient();

		try {
			HttpResponse response = null;
			
			//considering if no mParams passed from call then it is GET or else POST
			if (mParams == null) {
				HttpGet request = new HttpGet(Constants.BASE_URL + mSubUrl);
				response = httpclient.execute(request);
			} else {
				HttpPost httppost = new HttpPost(Constants.BASE_URL + mSubUrl);
				// Add parameters
				httppost.setEntity(new UrlEncodedFormEntity(mParams));
				response = httpclient.execute(httppost);
			}

			// Execute HTTP Post Request

			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream inStream = entity.getContent();
				result = convertStreamToString(inStream);
				Log.e("res::", result);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	@Override
	protected void onPostExecute(String result) {
		if (mPostExecuteListener != null) {
			try {
				mPostExecuteListener.onPostExecute(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private static String convertStreamToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;

		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
} // AsyncInvokeURLTask