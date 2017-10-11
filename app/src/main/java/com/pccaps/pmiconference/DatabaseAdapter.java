package com.pccaps.pmiconference;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

/**
 * Created by User1 on 10/10/2017.
 */

public class DatabaseAdapter extends ArrayAdapter<Event> {

    private Activity context;
    private List<Event> eventList;

    public DatabaseAdapter(Activity context, List<Event> eventList){
        super(context, R.layout.tab3, eventList);
        this.context=context;
        this.eventList=eventList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.tab3, null, true);

        ListView list = (ListView) listViewItem.findViewById(R.id.list_view);
        Event event = eventList.get(position);



        return listViewItem;
    }
}