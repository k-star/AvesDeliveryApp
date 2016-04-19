package aves.deliveryapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import aves.deliveryapp.R;
import aves.deliveryapp.adapter.CompletedDeliveriesAdapter;
import aves.deliveryapp.adapter.DeliveryDetailsAdapter;

/**
 * Created by keerthan on 3/19/2016.
 */
public class CompletedDeliveriesFragment extends Fragment {
    private CompletedDeliveriesAdapter adapter;
    private String[] menuTitles;
    private ArrayList<String> listItems;
    private ListView mDeliveryList;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //Inflate the layout for this fragment
        View rootView = inflater.inflate(
                R.layout.fragment_completed_deliveries, container, false);

        mDeliveryList = (ListView) rootView.findViewById(R.id.order_list);
        return rootView;
    }

    @Override
    public void onStart(){
        super.onStart();
        menuTitles = getResources().getStringArray(R.array.drawer_items);

        listItems = new ArrayList<String>();

        // adding nav drawer items to array
        listItems.add(menuTitles[0]);
        listItems.add(menuTitles[1]);
        listItems.add(menuTitles[2]);
        listItems.add(menuTitles[3]);
        listItems.add(menuTitles[4]);

        // setting the nav drawer list adapter
        adapter = new CompletedDeliveriesAdapter(getActivity().getApplicationContext(),
                listItems);
        mDeliveryList.setAdapter(adapter);

    }
}