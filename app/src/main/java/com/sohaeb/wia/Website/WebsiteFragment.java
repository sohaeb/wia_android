package com.sohaeb.wia.Website;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.sohaeb.wia.R;

public class WebsiteFragment extends Fragment {

    private CustomAdapter mAdapter;

    String[] listItems = {

            // About us -- 0

//            "About Us",
//            "Board of Directors",
//            "Our Constitution",


            //Services -- 3 - 0

            "Services",
            "Funeral Services",
            "Social Welfare & Assistance (ISWA)",
            "Imam's Programs",
            "Marriage Solemnization",

            // Organizations - 8 - 5
            "Organizations",
            "An-Noor School",
            "Muslim Youth Club (MYC)",
            "Sister Youth Club (SYC)",
            "WIA Center",


            //Supporting the mosque -13 - 10
            "Supporting the mosque",
            "Donations",
            "Membership",
            "Volunteer",
            "Employment Opportunities",

            //Other -- 18 - 15

            "Other",
            "Visiting the Mosque",
            "Islam for Non-Muslims",
            "Prayer Timings (pdf)",
    };


    final String[] urls = {
            // about Us
//            "",
//            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=117&Itemid=466",
//            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=115&Itemid=3282",


            //Services
            "",
            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=122:wia-funeral-services&catid=86&Itemid=3287",
            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=121:iswa&catid=86&Itemid=3286",
            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=120:imam-s-programs&catid=86&Itemid=3291",
            "hhttp://www.windsormosque.com/index.php?option=com_content&view=article&id=113:4-types-of-mobile-menus&catid=86&Itemid=3284",

            // orgs
            "",
            "",
            "",
            "",
            "",


            //Supporting the mosque - 13
            "",
            "https://app.etapestry.com/hosted/WindsorIslamicAssociation/OnlineDonation.html",
            "http://www.windsormosque.com/index.php?option=com_uniform&view=form&form_id=3&show_form_title=0&show_form_description=0&Itemid=503",
            "http://www.windsormosque.com/index.php?option=com_uniform&view=form&form_id=2&show_form_title=0&show_form_description=0&Itemid=502",
            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=85&Itemid=488",


            //Other //Other -- 18
            "",
            "http://www.windsormosque.com/index.php?option=com_content&view=article&id=118&Itemid=505",
            "http://www.windsormosque.com/index.php?option=com_wrapper&view=wrapper&Itemid=506",
            "http://www.windsormosque.com/index.php?option=com_kaprayertimes&view=prayertimes&Itemid=3253",

    };


//   map.put("mission Background","http://www.annoorschool.ca/about/aboutus/mission-background");


    public WebsiteFragment() {

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //
        // if we extend ListFragment
        //

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, listItems);
//        setListAdapter(adapter);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAdapter = new CustomAdapter(getActivity());

        for (int i = 0; i < listItems.length; i++) {
            if (i == 0) {
                mAdapter.addSectionHeaderItem(listItems[i]);
            } else if (i == 5) {
                mAdapter.addSectionHeaderItem(listItems[i]);
            } else if (i == 10) {
                mAdapter.addSectionHeaderItem(listItems[i]);
            } else if (i == 15) {
                mAdapter.addSectionHeaderItem(listItems[i]);
            } else {
                mAdapter.addItem(listItems[i]);
            }
        }

        TextView editText = (TextView) view.findViewById(R.id.myEditText);
        editText.setText("www.windsormosque.ca");

        ListView listView = (ListView) view.findViewById(R.id.list);

        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:
                    case 5:
                    case 10:
                    case 15:
                    case 16:
                    case 17:
                        break;
                    default:
                        Intent intent = new Intent(getActivity(), openHTML.class);
                        intent.putExtra("url", urls[position]);
                        startActivity(intent);
                }
            }
        });
    }

    //
    // if we extend ListFragment
    //

//    @Override
//    public void onListItemClick(ListView l, View v, int position, long id) {
//
//        Toast.makeText(getContext(), "Clicked on " + position, Toast.LENGTH_SHORT).show();
//
//
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_website, container, false);

        return view;
    }
}