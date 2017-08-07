package com.sohaeb.wia.Events;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sohaeb.wia.Events.Model.Event;
import com.sohaeb.wia.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.twitter.sdk.android.core.TwitterCore.TAG;

/**
 * Created by may on 2017-07-11.
 */

public class EventHolder extends RecyclerView.ViewHolder {

    private final TextView titleField;
    private final TextView placeNameField;
    private final TextView dayField;
    private final TextView monthField;
    private final TextView timeField;
    private final ImageView imageView;
    private final Button moreDetails;
    private final Context context;
    private SimpleDateFormat simpleDateFormat;
    private Date newDate;

    public EventHolder(View itemView) {
        super(itemView);
        titleField = (TextView) itemView.findViewById(R.id.tv_title);
        placeNameField = (TextView) itemView.findViewById(R.id.tv_location);
        monthField = (TextView) itemView.findViewById(R.id.tv_month);
        dayField = (TextView) itemView.findViewById(R.id.tv_day);
        timeField = (TextView) itemView.findViewById(R.id.tv_time);
        imageView = (ImageView) itemView.findViewById(R.id.event_imageView);
        moreDetails = (Button) itemView.findViewById(R.id.event_layout_more_info);
        context = itemView.getContext();

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onItemClick(v, getAdapterPosition());

            }
        });


    }

    private EventHolder.ClickListener mClickListener;

    public interface ClickListener{
        public void onItemClick(View view, int position);
    }

    public void setOnClickListener(EventHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }

//    public void setDayField(String name) {
//        dayField.setText(name);
//    }
//
//    public void setMonthField(String name) {
//        monthField.setText(name);
//    }
//
//    public void setTimeField(String name) {
//        timeField.setText(name);
//    }

    public void setTitle(String name) {
        titleField.setText(name);

    }

    public void setPlaceName(String message) {
        placeNameField.setText(message);
    }

    public void setImage(String image, Context context) {
        Picasso.with(context).load(image).into(imageView);
    }


    public void bind(Event event, final Context context) {
        final String title = event.getName();
        final String body = event.getDescription();
        final String imageURL = event.getCover().getSource();

        setTitle(event.getName());
        setPlaceName(event.getPlace().getName());
        setImage(event.getCover().getSource(), context);
        setDate(event.getStart_time());
        moreDetails.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.d(TAG, "onClick: " + "clicked");
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("title", title.toString());
                intent.putExtra("body", body.toString());
                intent.putExtra("image", imageURL.toString());
                context.startActivity(intent);

            }
        });
    }

    public void setDate(String date) {

        String pattern = "yyyy-MM-dd'T'HH:mm:ssZZZZZ";
        simpleDateFormat = new SimpleDateFormat(pattern);
        try {

            newDate = (Date) simpleDateFormat.parseObject((date));
            String month = (String) DateFormat.format("MM", newDate);

            // EEEE for full day with Sunday, tuesday, etc...
            String dayOfTheWeek = (String) DateFormat.format("EEE", newDate); // Thu
            String day = (String) DateFormat.format("dd", newDate);

            // HH for full time with 08:00
            String time = (String) DateFormat.format("H:mm", newDate);
            String monthAsText = new DateFormatSymbols().getShortMonths()[Integer.parseInt(month) - 1];
            // Return all days of week starting from 1 to 7

            String twelveHour;

            Calendar now = Calendar.getInstance();
            now.setTime(newDate);
            int a = now.get(Calendar.AM_PM);
            if (a == Calendar.AM)
                twelveHour = "AM";
            else
                twelveHour = "PM";

            dayField.setText(day);
            monthField.setText(monthAsText);
            timeField.setText(dayOfTheWeek + " - " + time + " " + twelveHour);

            // 2nd way:
            //Calendar cal = Calendar.getInstance();
            //System.out.println(new SimpleDateFormat("MMM").format(cal.getTime()));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

