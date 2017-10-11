package com.pccaps.pmiconference;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.google.android.gms.internal.zzs.TAG;

/**
 * Created by User1 on 9/30/2017.
 */

public class Tab3 extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference dRef=FirebaseDatabase.getInstance().getReference("Event");
    DatabaseReference iEvents = dRef.child("Event1");
    DatabaseReference subData = iEvents.child("subData");


    static int popChoice;
    static Event jim = new Event("jim", 3, 5, "Library", "asdf", "", 5, 3);
    static Event j = new Event("jim", 3, 5, "Library", "asdc", "", 5, 3);
    static Event ji = new Event("jim", 3, 5, "Library", "asdfsadf", "", 5, 3);
    static Event im = new Event("jim", 3, 5, "Library", "sdfs", "", 5, 3);
    static Event x = new Event("Error", 3, 5, "Library", "sdfs", "", 5, 3);
    static Event create = new Event("create", 3, 5, "Library", "sdfs", "", 5,3);
    static Event start = new Event("start", 3, 5, "Library", "sdfs", "", 5,3);
    static Event datachange = new Event("datachange", 3, 5, "Library", "sdfs", "", 5,3);
    static Event for4 = new Event("for", 3, 5, "Library", "sdfs", "", 5,3);

    ListView listView;
    static List<Event> list = new ArrayList<>(
            Arrays.asList(jim, j, ji, im)
    );


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.tab3, container, false);
        listView = (ListView) rootView.findViewById(R.id.list_view);
        //ArrayAdapter<Event> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.activity_list_item, android.R.id.text1, list);
        //listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                popChoice=position;
                startActivity(new Intent(getActivity(), Pop.class));
            }
        });

        return rootView;

    }

    @Override
    public void onStart() {
        super.onStart();
        list.add(start);
        subData.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.add(datachange);
                //list.clear();
                Iterable<DataSnapshot> event1 = dataSnapshot.getChildren();
                for(DataSnapshot data : event1){
                    list.add(datachange);
                    Event retrieve = data.getValue(Event.class);
                    list.add(retrieve);
                }

                //DatabaseAdapter adapter = new DatabaseAdapter(getActivity(), list);
                //listView.setAdapter(adapter);
                ArrayAdapter<Event> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.activity_list_item, android.R.id.text1, list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                list.add(x);
            }
        });
    }


}