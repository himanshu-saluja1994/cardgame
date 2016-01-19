package com.example.practo.cardgame;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

/**
 * A placeholder fragment containing a simple view.
 */
public class GamePlayFragment extends Fragment {
    private int arr[] = new int[52];
    private int random_selected[] = new int[12];
    private int flag[] = new int[52];
    private int Total_random_card = 12;
    private int max_move_allowed=42;
    private int max = 51;
    private int min = 0;
    private Vector<Integer> v = new Vector<Integer>();
    private int[] number_of_click = new int[12];
    private timer ti = new timer();
    private Timer time;
    private int number_of_pair=0;
    private Vector<Integer> matched = new Vector<Integer>();
    private int total_number_of_click=0;
    private TextView textView ,textView1;
    private int[] random_selected1= new int[12];
    private ImageAdapter imageAdapter;
    private GridView gridView;
    private SharedPreferences sharedpreferences;
    private String MyPREFERENCES="MYpref";
    private String highscore="99";
    private void initialize() {
        arr[0] = R.drawable.ac;
        arr[1] = R.drawable.ad;
        arr[2] = R.drawable.ah;
        arr[3] = R.drawable.as;

        arr[4] = R.drawable.jc;
        arr[5] = R.drawable.jd;
        arr[6] = R.drawable.jh;
        arr[7] = R.drawable.js;

        arr[8] = R.drawable.qc;
        arr[9] = R.drawable.qd;
        arr[10] = R.drawable.qh;
        arr[11] = R.drawable.qs;

        arr[12] = R.drawable.kc;
        arr[13] = R.drawable.kd;
        arr[14] = R.drawable.kh;
        arr[15] = R.drawable.ks;

        arr[16] = R.drawable.twoc;
        arr[17] = R.drawable.twod;
        arr[18] = R.drawable.twoh;
        arr[19] = R.drawable.twos;

        arr[20] = R.drawable.threec;
        arr[21] = R.drawable.threed;
        arr[22] = R.drawable.threeh;
        arr[23] = R.drawable.threes;

        arr[24] = R.drawable.fourc;
        arr[25] = R.drawable.fourd;
        arr[26] = R.drawable.fourh;
        arr[27] = R.drawable.fours;

        arr[28] = R.drawable.fivec;
        arr[29] = R.drawable.fived;
        arr[30] = R.drawable.fiveh;
        arr[31] = R.drawable.fives;

        arr[32] = R.drawable.sixc;
        arr[33] = R.drawable.sixd;
        arr[34] = R.drawable.sixh;
        arr[35] = R.drawable.sixs;

        arr[36] = R.drawable.sevenc;
        arr[37] = R.drawable.sevend;
        arr[38] = R.drawable.sevenh;
        arr[39] = R.drawable.sevens;

        arr[40] = R.drawable.eightc;
        arr[41] = R.drawable.eight8;
        arr[42] = R.drawable.eighth;
        arr[43] = R.drawable.eights;

        arr[44] = R.drawable.ninec;
        arr[45] = R.drawable.nined;
        arr[46] = R.drawable.nineh;
        arr[47] = R.drawable.nines;

        arr[48] = R.drawable.tenc;
        arr[49] = R.drawable.tend;
        arr[50] = R.drawable.tenh;
        arr[51] = R.drawable.tens;

        for (int i = 0; i < 52; i++) {
            flag[i] = 0;

        }
    }
    public GamePlayFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        initialize();
        super.onCreate(savedInstanceState);

    }
    public void savedata(){
        SharedPreferences sharedpreferences1 = getActivity().getPreferences( Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =sharedpreferences1.edit();
        String h=loaddata();
        String highscore1=Integer.toString(Math.min(total_number_of_click,Integer.parseInt(h)));
        editor.putString(MyPREFERENCES, highscore1);
        editor.commit();

    }
    public String loaddata(){
        SharedPreferences sharedpreferences1 =getActivity().getPreferences(Context.MODE_PRIVATE);
        String highscore1=sharedpreferences1.getString(MyPREFERENCES, "99");

        return highscore1;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //System.out.println("here now");
        Objs objs = new Objs();
        random_selected = objs.select_random(arr);
        View rootView = inflater.inflate(R.layout.fragment_game_play, container, false);
        gridView =  (GridView) rootView.findViewById(R.id.gridview);
        imageAdapter =new ImageAdapter(this.getContext(), random_selected);

        gridView.setAdapter(imageAdapter);
        //    for(int idx=0;idx<12;idx++){
        //      imageAdapter.update(idx,random_selected[idx]);

        //}
        gridView.setClickable(false);
        imageAdapter.notifyDataSetChanged();
        timer1 ti1=new timer1();
        Timer time1 = new Timer();
        time1.schedule(ti1,900);


        textView=(TextView)rootView.findViewById(R.id.linear).findViewById(R.id.textView3);
        textView1=(TextView)rootView.findViewById(R.id.linear3).findViewById(R.id.txt1);
        textView1.setText(loaddata());

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //  Toast.makeText(MainActivity.this,position,Toast.LENGTH_SHORT).show();
                //         System.out.println(position);
                int pos_check = matched.indexOf(position);
                if (number_of_click[position] == 0 && pos_check == -1) {
                    total_number_of_click++;
                    max_move_allowed--;
                    textView.setText(Integer.toString(total_number_of_click));
                    if (v.size() != 2) {
                        v.add(position);
                        number_of_click[position] = 1;
                        imageAdapter.update(position, random_selected[position]);
                        imageAdapter.notifyDataSetChanged();

                        time = new Timer();
                        ti = new timer();

                        if (v.size() == 2) {

                            time.schedule(ti, 300);


                        }
                    }
                } else if (number_of_click[position] == 1 && pos_check == -1) {
                    total_number_of_click++;
                    max_move_allowed--;
                    textView.setText(Integer.toString(total_number_of_click));
                    number_of_click[position] = 0;
                    int index = v.indexOf(position);
                    // System.out.println(index);
                    v.remove(index);
                    imageAdapter.update(position, R.drawable.rsz_card_back);
                    imageAdapter.notifyDataSetChanged();
                }

                // imageAdapter.update(position,random_selected[position]);
                //imageAdapter.notifyDataSetChanged();

            }
        });
        return rootView;
    }
    public class timer extends TimerTask {


        Handler handler = new Handler() {
            @Override
            public void close() {

            }

            @Override
            public void flush() {

            }

            @Override
            public void publish(LogRecord record) {

            }

        };

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    //           System.out.println("here");
                    number_of_click[v.get(0)] = 0;
                    number_of_click[v.get(1)] = 0;
                    Matching matching = new Matching();
                    int X = matching.Matching(arr, random_selected[v.get(0)], random_selected[v.get(1)]);


                    // System.out.println(X);
                    if (X == 0) {
                        imageAdapter.update(v.get(0), R.drawable.rsz_card_back);
                        imageAdapter.update(v.get(1), R.drawable.rsz_card_back);
                        imageAdapter.notifyDataSetChanged();
                    } else {
                        matched.add(v.get(0));
                        matched.add(v.get(1));
                        imageAdapter.update(v.get(0), 0);
                        imageAdapter.update(v.get(1), 0);
                        imageAdapter.notifyDataSetChanged();
                        number_of_pair++;
                        if(number_of_pair==6){
                            System.out.println("dne");
                            gridView.setClickable(false);
                            Toast.makeText(getActivity().getApplicationContext(), "Completed", Toast.LENGTH_LONG).show();
                            savedata();
                            textView1.setText(loaddata());




                        }
                    }
                    v.clear();

                }
            });


        }

    }
    class timer1 extends TimerTask{

        @Override
        public void run() {

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    for(int i=0;i<12;i++){
                        imageAdapter.update(i,R.drawable.rsz_card_back);
                    }
                    imageAdapter.notifyDataSetChanged();
                    gridView.setClickable(true);
                }
            });
            //  imageAdapter.notifyDataSetChanged();

        }
    }


}

