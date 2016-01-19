package com.example.practo.cardgame;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class LeaderBoardFragment extends Fragment {

    public LeaderBoardFragment() {
    }
    private View RootView;
    private ArrayAdapter<String> adp;
    private ArrayList<String> leader;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        RootView=inflater.inflate(R.layout.fragment_leader_board, container, false);
        ListView listView = (ListView) RootView.findViewById(R.id.leadership);
        leader = new ArrayList<String>();
        adp=new ArrayAdapter<String>(getActivity(),R.layout.leaders,R.id.leader,leader);
        listView.setAdapter(adp);

        return RootView;
    }
    public class Fetch extends AsyncTask<String,Void,String[]>{

        @Override
        protected String[] doInBackground(String... params) {
            return new String[0];
        }
    }
}
