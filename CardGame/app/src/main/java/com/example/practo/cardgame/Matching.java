package com.example.practo.cardgame;

/**
 * Created by practo on 14/01/16.
 */
public class Matching {
    public int Matching(int[]arr,int a,int b){
        a=find(arr,a);
        b=find(arr,b);
     //   System.out.println(a+" "+b);
        int num=a%4;
        switch (num){
            case 0:
                if(a+1==b || a+2==b || a+3==b ){
                    return 1;
                }
                break;
            case 1:
                if(a+1==b||a-1==b||a+2==b){
                    return 1;
                }
                break;
            case 2:
                if(a-1==b || a-2==b || a+1==b){
                    return 1;
                }
                break;
            case 3:
                if(a-1==b||a-2==b||a-3==b){
                    return 1;
                }
                break;

        }
        return 0;
    }
    private int find(int[]arr,int a){
        int l=arr.length;
        for(int index=0;index<l;index++){
            if(arr[index]==a){
                return index;
            }
        }
        return -1;
    }
}
