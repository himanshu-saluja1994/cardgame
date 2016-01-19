package com.example.practo.cardgame;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by practo on 13/01/16.
 */

public class ImageAdapter extends BaseAdapter {
    Context mcontext;
    int[] ran=new int[12];
    int backdeck[]=new int[12];
    public ImageAdapter(Context mainActivity,int[] arr) {
        mcontext=mainActivity;
        for(int i=0;i<12;i++){
            ran[i]=arr[i];
            backdeck[i]=ran[i];
        }
      //  System.out.println("was here");
    }

    @Override
    public int getCount() {
        return ran.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    ImageView imageView;



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        if (convertView == null) {
            imageView = new ImageView(mcontext);
            imageView.setLayoutParams(new GridView.LayoutParams(180, 180));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(10, 10, 10, 10);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
       // System.out.println(ran[position]);
        imageView.setImageResource(backdeck[position]);

        //  imageView.setImageResource(ran[position]);
        return imageView;

    }
    public void update(int position,int img){
      //  System.out.println("update image now");
        backdeck[position]=img;
        // imageView.setImageResource(ran[position]);


    }

}

