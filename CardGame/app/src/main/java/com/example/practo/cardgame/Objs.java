package com.example.practo.cardgame;

import java.util.Random;

/**
 * Created by practo on 13/01/16.
 */
public class Objs {

    private int random_selected[]=new int[12];
    private int flag[]=new int[52];
    private int Total_random_card=12;
    private int max=51;
    private int min=0;
    Random random;
    int[] select_random(int[] arr) {

        random = new Random();
        int count = 0;
        while (count != Total_random_card) {
            int num = random.nextInt((max - min) + 1) + min;
 //           System.out.println(num + " " + count);
            if (num >= 0 && num < 52 && flag[num] == 0) {
                flag[num] = 1;
                int num_mod = num % 4;
                switch (num_mod) {
                    case 0:
                        if (flag[num + 1] == 0 && flag[num + 2] == 0 && flag[num + 3] == 0) {
                            Random ran = new Random();
                            int num1 = ran.nextInt((3 - 1) + 1) + 1;
   //                         System.out.println("inside " + num1);
                            flag[num + num1] = 1;
                            count++;
                        } else if (flag[num + 1] == 1 || flag[num + 2] == 1 || flag[num + 3] == 1) {
                            if (flag[num + 1] == 1 && flag[num + 2] == 1 && flag[num + 3] != 1) {
                                flag[num + 3] = 1;
                                count++;
                            } else if (flag[num + 1] == 1 && flag[num + 3] == 1 && flag[num + 2] != 1) {
                                flag[num + 2] = 1;
                                count++;
                            } else if (flag[num + 2] == 1 && flag[num + 3] == 1 && flag[num + 1] != 1) {
                                flag[num + 1] = 1;
                                count++;

                            }

                        } else {

                        }
                        break;
                    case 1:
                        if (flag[num - 1] == 0 && flag[num + 1] == 0 && flag[num + 2] == 0) {
                            Random ran = new Random();
                            int num1 = ran.nextInt((3 - 1) + 1) + 1;

     //                       System.out.println("inside " + num1);

                            if (num1 == 3)
                                flag[num + 1] = 1;
                            else if (num1 == 2)
                                flag[num + num1] = 1;
                            else
                                flag[num - num1] = 1;

                            count++;
                        } else if (flag[num - 1] == 1 || flag[num + 1] == 1 || flag[num + 2] == 1) {
                            if (flag[num - 1] == 1 && flag[num + 1] == 1 && flag[num + 2] != 1) {
                                flag[num + 2] = 1;
                                count++;
                            } else if (flag[num - 1] == 1 && flag[num + 2] == 1 && flag[num + 1] != 1) {
                                flag[num + 1] = 1;
                                count++;
                            } else if (flag[num + 2] == 1 && flag[num + 1] == 1 && flag[num - 1] != 1) {
                                flag[num - 1] = 1;
                                count++;

                            }

                        } else {

                        }
                        break;
                    case 2:
                        if (flag[num - 1] == 0 && flag[num - 2] == 0 && flag[num + 1] == 0) {
                            Random ran = new Random();
                            int num1 = ran.nextInt((3 - 1) + 1) + 1;
       //                     System.out.println("inside " + num1);
                            if (num1 == 1) {
                                flag[num - 2] = 1;

                            } else if (num1 == 2) {
                                flag[num - 1] = 1;

                            } else {
                                flag[num + 1] = 1;
                            }
                            count++;
                        } else if (flag[num - 1] == 1 || flag[num - 2] == 1 || flag[num + 1] == 1) {
                            if (flag[num + 1] == 1 && flag[num - 1] == 1 && flag[num - 2] != 1) {
                                flag[num - 2] = 1;
                                count++;
                            } else if (flag[num + 1] == 1 && flag[num - 2] == 1 && flag[num - 1] != 1) {
                                flag[num - 1] = 1;
                                count++;
                            } else if (flag[num - 1] == 1 && flag[num - 2] == 1 && flag[num + 1] != 1) {
                                flag[num + 1] = 1;
                                count++;

                            }

                        } else {

                        }
                        break;
                    case 3:
                        if (flag[num - 1] == 0 && flag[num - 2] == 0 && flag[num - 3] == 0) {
                            Random ran = new Random();
                            int num1 = ran.nextInt((3 - 1) + 1) + 1;
         //                   System.out.println("inside " + num1);
                            if (num1 == 1) {
                                flag[num - 2] = 1;

                            } else if (num1 == 2) {
                                flag[num - 1] = 1;

                            } else {
                                flag[num - 3] = 1;
                            }
                            count++;
                        } else if (flag[num - 1] == 1 || flag[num - 2] == 1 || flag[num - 3] == 1) {
                            if (flag[num - 3] == 1 && flag[num - 1] == 1 && flag[num - 2] != 1) {
                                flag[num - 2] = 1;
                                count++;
                            } else if (flag[num - 3] == 1 && flag[num - 2] == 1 && flag[num - 1] != 1) {
                                flag[num - 1] = 1;
                                count++;
                            } else if (flag[num - 1] == 1 && flag[num - 2] == 1 && flag[num - 3] != 1) {
                                flag[num - 3] = 1;
                                count++;

                            }

                        } else {

                        }
                        break;


                }

                count = count + 1;
            }

        }
        //System.out.println("here");
        int j = 0;
        for (int idx = 0; idx < 52 && j<12; idx++) {
            if (flag[idx] == 1) {
               // System.out.println(idx+" "+j+" "+arr[idx]);

                random_selected[j] = arr[idx];
                j++;
            }
        }
        //System.out.println("selected");
        int[] fl=new int[12];
        for (int idx=0;idx<12;idx++){
            fl[idx]=0;
        }
        int[] randomised= new int[12];
        int count1=0;
        while(count1!=Total_random_card){
            int num = random.nextInt((11) + 1);
            if(fl[num]==0){
                fl[num]=1;
                randomised[count1]=random_selected[num];
                count1++;

            }


        }
        //  System.out.println(random.nextInt());
        return randomised;

    }

}
