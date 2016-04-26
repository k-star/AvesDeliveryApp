package aves.deliveryapp.utils;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import aves.deliveryapp.R;

public class CommonMethods {
	
	// to get listview height
	public static void getTotalHeightofListView(ListView listView) {
		ListAdapter mAdapter = listView.getAdapter();
		int totalHeight = 0;
		for (int i = 0; i < mAdapter.getCount(); i++) {
			View mView = mAdapter.getView(i, null, listView);
			mView.measure(
					MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED),
					MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED));
			totalHeight += mView.getMeasuredHeight();
			Log.w("HEIGHT" + i, String.valueOf(totalHeight));
		}
		ViewGroup.LayoutParams params = listView.getLayoutParams();
		params.height = totalHeight
				+ (listView.getDividerHeight() * (mAdapter.getCount() - 1));
		listView.setLayoutParams(params);
		listView.requestLayout();
	}
	
	// common alert popup
	public static Dialog setAlertPopup(Context context,String msg) {

			final Dialog dialog = new Dialog(context,
					android.R.style.Theme_Translucent_NoTitleBar);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			dialog.setContentView(R.layout.popup_alert);
			dialog.setCancelable(true);
			((View) dialog.findViewById(R.id.dummyview))
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							dialog.dismiss();
						}

					});
			((TextView) dialog.findViewById(R.id.txt_alert)).setText(msg);
			((View) dialog.findViewById(R.id.btn_okay))
					.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {

							dialog.dismiss();
						}
					});
			

			return dialog;

		}
	
	public static void toastMsg(Context con,String text) {
		
		 Toast toast = Toast.makeText(con,text, Toast.LENGTH_LONG);
		 LinearLayout toastLayout = (LinearLayout) toast.getView();
		 TextView toastTV = (TextView) toastLayout.getChildAt(0);
		 toastTV.setTextSize(30);
		 toast.setGravity(Gravity.CENTER, 0, 0);
		 toast.show();
	}
}
