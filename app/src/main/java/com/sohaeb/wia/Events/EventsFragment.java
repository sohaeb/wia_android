package com.sohaeb.wia.Events;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sohaeb.wia.R;
import com.sohaeb.wia.Events.Model.Event;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment {

    private static final String TAG = "EventsFragment";

    protected FirebaseRecyclerAdapter<Event, EventHolder> mAdapter;
    private RecyclerView mMessages;
    private LinearLayoutManager mManager;
    protected DatabaseReference mChatRef;

    public EventsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static EventsFragment newInstance() {
        EventsFragment fragment = new EventsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        TextView editText = (TextView) view.findViewById(R.id.myEditText);
        editText.setText("Upcoming Events");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_events, container, false);
        readFromDB(view);
        return view;
    }

    public void readFromDB(View view) {

        Log.d(TAG, "readFromDB: 1");

        mChatRef = FirebaseDatabase.getInstance().getReference("server").child("events");

        mMessages = (RecyclerView) view.findViewById(R.id.rv_list);
        mMessages.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        mAdapter = new FirebaseRecyclerAdapter<Event, EventHolder>(
                Event.class,
                R.layout.layout_event,
                EventHolder.class,
                mChatRef) {

            @Override
            public void populateViewHolder(EventHolder holder, Event event, int position) {
                holder.bind(event, getActivity());
            }
        };

        mMessages.setAdapter(mAdapter);

//        mChatRef.addValueEventListener(new ValueEventListener() {
//
//
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.d(TAG, "readFromDB: 4");
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
////                Log.d(TAG, "onDataChange: 3");
//                for (DataSnapshot val : dataSnapshot.getChildren())
//                    event = val.getValue(Event.class);
//                Log.i("Chat", event.getName() + ": " + event.getDescription() + " " + event.getCover().getSource() + " hmm" + event.getPlace().getName() + " hmm" + event.getPlace().getLocation().getStreet());
////                    Log.d(TAG, "onDataChange: " + val.getValue());
////                    writer.write(String.valueOf(val));
////                String value = dataSnapshot.getValue(String.class);
////                Log.d(TAG, "onDataChange: 4");
////                Log.d(TAG, "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w(TAG, "Failed to read value.", error.toException());
//            }
//        });
    }
}