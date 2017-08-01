package com.sohaeb.wia.Home;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.icu.util.IslamicCalendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.opencsv.CSVReader;
import com.sohaeb.wia.R;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class HomeFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private TextView textView_f;
    private TextView textView_fi;
    private TextView textView_s;
    private TextView textView_d;
    private TextView textView_di;
    private TextView textView_a;
    private TextView textView_ai;
    private TextView textView_m;
    private TextView textView_mi;
    private TextView textView_i;
    private TextView textView_ia;

    private TextView text_fajir;
    private TextView text_duhur;
    private TextView text_asir;
    private TextView text_maghrib;
    private TextView text_isha;

    private ListView recyclerView;

    private char[] chars;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

//    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters

    private static final String TAG = "HomeFragment";

    public static HomeFragment newInstance() {
//        //(TAG, "newInstance: " + "called");
        HomeFragment fragment = new HomeFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        textView_f = (TextView) view.findViewById(R.id.tv_fajir1);
        textView_fi = (TextView) view.findViewById(R.id.tv_fajir);
        textView_d = (TextView) view.findViewById(R.id.tv_duhur1);
        textView_di = (TextView) view.findViewById(R.id.tv_duhur);
        textView_m = (TextView) view.findViewById(R.id.tv_maghrib1);
        textView_mi = (TextView) view.findViewById(R.id.tv_maghrib);
        textView_a = (TextView) view.findViewById(R.id.tv_asir1);
        textView_ai = (TextView) view.findViewById(R.id.tv_asir);
        textView_i = (TextView) view.findViewById(R.id.tv_isha1);
        textView_ia = (TextView) view.findViewById(R.id.tv_isha);
        textView_s = (TextView) view.findViewById(R.id.tv_sunrise1);

        text_fajir = (TextView) view.findViewById(R.id.text_fajir);
        text_duhur = (TextView) view.findViewById(R.id.text_Duhur);
        text_asir = (TextView) view.findViewById(R.id.text_Asir);
        text_maghrib = (TextView) view.findViewById(R.id.text_maghrib);
        text_isha = (TextView) view.findViewById(R.id.text_isha);

        Date date = new Date();
        String month = (String) DateFormat.format("MM", date);
        String day = (String) DateFormat.format("dd", date);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            // only for Nougat and newer versions
            android.icu.util.Calendar hijriCalendar = IslamicCalendar.getInstance();
        }

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(date);
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY) * 100;
        int currentMin = calendar.get(Calendar.MINUTE);
        int currentTime = currentHour + currentMin;
        Log.d(TAG, "onViewCreated: currentTime " + currentTime);

        String[] array = (String[]) readCsv(getActivity(), month, day);

        /*
        //
        // Fajir - 1
        //
        */

        chars = array[1].toCharArray();
        int hour_fajir = (100 * Character.getNumericValue(chars[0])) + Character.getNumericValue(chars[2]) * 10 + Character.getNumericValue(chars[3]);
        //(TAG, "onViewCreated: hour_fajir " + hour_fajir);
        /*
        //
        // Sunrise - 3
        //
        */

        chars = array[3].toCharArray();
        int hour_sunrise = (100 * Character.getNumericValue(chars[0])) + Character.getNumericValue(chars[2]) * 10 + Character.getNumericValue(chars[3]);
        //(TAG, "onViewCreated: hour_sunrise " + hour_sunrise);
        /*
        //
        // Duhur - 4
        //
        */

        chars = array[4].toCharArray();
        int hour_duhur = (100 * (Character.getNumericValue(chars[0]) + 12)) + Character.getNumericValue(chars[2]) * 10 + Character.getNumericValue(chars[3]);
        //(TAG, "onViewCreated: hour_duhur " + hour_duhur);
        /*
        //
        // asir - 6
        //
        */

        chars = array[6].toCharArray();
        int hour_asir = (100 * (Character.getNumericValue(chars[0]) + 12)) + Character.getNumericValue(chars[2]) * 10 + Character.getNumericValue(chars[3]);
        //(TAG, "onViewCreated: hour_asir " + hour_asir);
        /*
        //
        // Maghrib - 8
        //
        */

        chars = array[8].toCharArray();
        int hour_maghrib = (100 * (Character.getNumericValue(chars[0]) + 12)) + Character.getNumericValue(chars[2]) * 10 + Character.getNumericValue(chars[3]);
        Log.d(TAG, "onViewCreated: hour_maghrib " + hour_maghrib);
        /*
        //
        // Isha - 10
        //
        */

        chars = array[10].toCharArray();
        Log.d(TAG, "onViewCreated: " + chars[0] + " " + chars[1] + " " + chars[2] + " " + chars[3] + chars[4] + " ");
        int hour_isha = ((1000 * (Character.getNumericValue(chars[0]))) + (100 * (Character.getNumericValue(chars[1]))) + 1200) + Character.getNumericValue(chars[3]) * 10 + Character.getNumericValue(chars[4]);
        Log.d(TAG, "onViewCreated: hour_isha " + hour_isha);

        // ---- if -----

        if (currentTime >= hour_fajir && currentTime < hour_sunrise) {
            //(TAG, "onViewCreated: fajir");
            // fajir
            textView_f.setTextColor(Color.parseColor("#03A9F4"));
//            textView_f.setTypeface(null, Typeface.BOLD);
            textView_fi.setTextColor(Color.parseColor("#03A9F4"));
//            textView_fi.setTypeface(null, Typeface.BOLD);
            text_fajir.setTextColor(Color.parseColor("#03A9F4"));
            text_fajir.setTypeface(null, Typeface.BOLD);
        } else if (currentTime >= hour_duhur && currentTime < hour_asir) {
            //(TAG, "onViewCreated: Hour duhur + asir" + hour_duhur + " " + hour_asir);
            //(TAG, "onViewCreated: Duhur");
            // Duhur
            textView_d.setTextColor(Color.parseColor("#03A9F4"));
            textView_d.setTypeface(null, Typeface.BOLD);
            textView_di.setTextColor(Color.parseColor("#03A9F4"));
            textView_di.setTypeface(null, Typeface.BOLD);
            text_duhur.setTextColor(Color.parseColor("#03A9F4"));
        } else if (currentTime >= hour_asir && currentTime < hour_maghrib) {
            //(TAG, "onViewCreated: Hour duhur + asir" + hour_duhur + " " + hour_asir + " " + hour_maghrib);
            //(TAG, "onViewCreated: Asir");
            // Asir
            textView_a.setTextColor(Color.parseColor("#03A9F4"));
            textView_a.setTypeface(null, Typeface.BOLD);
            textView_ai.setTextColor(Color.parseColor("#03A9F4"));
            textView_ai.setTypeface(null, Typeface.BOLD);
            text_asir.setTextColor(Color.parseColor("#03A9F4"));
        } else if (currentTime >= hour_maghrib && currentTime < hour_isha) {
            // Maghrib
            Log.d(TAG, "onViewCreated: maghrib" + hour_isha);
            textView_m.setTextColor(Color.parseColor("#03A9F4"));
            textView_m.setTypeface(null, Typeface.BOLD);
            textView_mi.setTextColor(Color.parseColor("#03A9F4"));
            textView_mi.setTypeface(null, Typeface.BOLD);
            text_maghrib.setTextColor(Color.parseColor("#03A9F4"));

        } else if (currentTime >= hour_isha || currentTime < 100) {
            Log.d(TAG, "onViewCreated: " + currentHour + " " + hour_isha + 200);
            //Isha
            textView_i.setTextColor(Color.parseColor("#03A9F4"));
            textView_i.setTypeface(null, Typeface.BOLD);
            textView_ia.setTextColor(Color.parseColor("#03A9F4"));
            textView_ia.setTypeface(null, Typeface.BOLD);
            text_isha.setTextColor(Color.parseColor("#03A9F4"));
        }

        textView_f.setText(array[1].toString());
        textView_fi.setText(array[2].toString());
        textView_s.setText(array[3].toString());
        textView_s.setText(array[3].toString());
        textView_d.setText(array[4].toString());
        textView_di.setText(array[5].toString());
        textView_a.setText(array[6].toString());
        textView_ai.setText(array[7].toString());
        textView_m.setText(array[8].toString());
        textView_mi.setText(array[9].toString());
        textView_i.setText(array[10].toString());
        textView_ia.setText(array[11].toString());

        com.sohaeb.wia.Home.TwitterFragment twitterFragment = new com.sohaeb.wia.Home.TwitterFragment();
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_home_content, twitterFragment).commit();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //(TAG, "onCreateView: Inflating");

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    public Object readCsv(Context context, String month, String day) {
        List<String[]> questionList = new ArrayList<String[]>();
        AssetManager assetManager = context.getAssets();
        month += ".csv";
        try {
            InputStream csvStream = assetManager.open(month);
            InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
            CSVReader csvReader = new CSVReader(csvStreamReader);
            List myEntries = csvReader.readAll();

            // throw away the header
//            csvReader.readNext();

            // 0-
//            List list = new ArrayList();
//
//            //add elements to list
//
//            for(int i=0; i < list.size(); i++) {
//                Object obj = list.get(i);
//            }

            // 1- access via new for-loop
//            for(Object object : myEntries) { // Object to cast to any object
//                String[] array = (String[]) object;
//                //(TAG, "length of each (String[]) in index of a list: " + array.length);
//            }

            // 1- A- Another way

//            List<String> list = new ArrayList<String>();
//
//            //add elements to list
//
//            for(String obj : list) {
//
//            }

            // 2- access via Iterator
//            Iterator iterator = myEntries.iterator(); // Create an Iterator(Advantage: Auto type cr8ion)
//            while(iterator.hasNext()) {
//                String[] element = (String[]) iterator.next(); // Get index (String[], string[], etc...)
//            }

//            Integer[] array = {1,2,3,4,5,6};
//            Arrays.asList(array)

            // 2-A- Another way

//            Iterator<String[]> anotherIterator = myEntries.iterator();
//            while(anotherIterator.hasNext()) {
//                String[] obj = anotherIterator.next();; // Get index (String[], string[], etc...)
//            }

            // Get the index of day 30 + grab the Fajir Athan
            //(TAG, "NOw: " + ((String[]) myEntries.get(Integer.parseInt(day)))[1].toString());

            // coz array start from 0
            return (myEntries.get(Integer.parseInt(day) - 1));


//            while ((nextLine = csvReader.readNext()) != null) {
//                System.out.println(nextLine[0]  + "etc...");
//                questionList.add(nextLine);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return questionList;
        return null;
    }

    // TODO: Rename method, update argument and hook method into UI event
//    public void onButtonPressed(Uri uri) {
////        if (mListener != null) {
////            mListener.onFragmentInteraction(uri);
////        }
//    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
////        if (context instanceof OnFragmentInteractionListener) {
////            mListener = (OnFragmentInteractionListener) context;
////        } else {
////            throw new RuntimeException(context.toString()
////                    + " must implement OnFragmentInteractionListener");
////        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        mListener = null;
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
