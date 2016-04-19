package aves.deliveryapp.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import aves.deliveryapp.R;

/**
 * Created by keerthan on 3/15/2016.
 */
public class CompletedDeliveriesAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> navDrawerItems;

    public CompletedDeliveriesAdapter(Context context, ArrayList<String> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }

    @Override
    public int getCount() {
        return navDrawerItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.completed_delivery_item, null);
            holder = new ViewHolder();
            holder.customernameTextView = (TextView) convertView.findViewById(R.id.customer_name);
            holder.locationnameTextView = (TextView) convertView.findViewById(R.id.location_name);
            holder.deliverytimeTextView = (TextView) convertView.findViewById(R.id.delivery_time);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        //holder.customernameTextView.setText();
        //holder.locationnameTextView.setText();
        //holder.deliverytimeTextView.setText();
        //holder.selectionImageView.setImageBitmap(person.getImage());

        return convertView;
    }

    static class ViewHolder {
        private TextView customernameTextView;
        private TextView locationnameTextView;
        private TextView deliverytimeTextView;
    }
}