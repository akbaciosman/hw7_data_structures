/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.hw7_111044054;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author osman
 */
public class Main {
    int totalTime = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        LinkedList list = new LinkedList(); 
        Queue<Costumer> array = new Queue<Costumer>();

        Main main = new Main();
        main.readFile(array);
     
        main.start(array);
      
        
        
    }
    /**
     * 
     * @param array 
     * Dosyadan okunan degerlere gore ilk elemani aliyor 
     * ve daha sonra arrival time süresi esnasinda olan costumerleri 
     * belli öncelik sirsina gore duzenliyor 
     * ve bu her defasinda tekrarlaniyor
     */
    void start(Queue<Costumer> array){
        System.out.println("start function");
        Queue<Costumer> list = new Queue<Costumer>();
        Costumer cos1 = array.peek();
        
        while(array.size()!=0){
            cos1 = array.poll();
            totalTime = cos1.getArrivalTimeHour()*60 + cos1.getArrivalTimeMinute();
            if(cos1==null){
                System.out.println("size Queue : " + array.size());
                break;
            }
            System.out.println("size Queue : " + array.size());
            int counter = cos1.getServiceTime();
            list.offer(cos1);
            totalTime = totalTime + cos1.getServiceTime();
            System.out.println("------------");
            displayCostumerInfor(array);
            System.out.println("******************");
            System.out.print(cos1.getArrivalTimeHour() + " " + cos1.getArrivalTimeMinute());
            System.out.print(" " + cos1.getServiceTime() + " " + cos1.getCostumerType() + "\n");
            if(array.size()!=1){
                int count = totalCostumerInQueue(array, totalTime);
                
                ArrayList<Costumer> sort = new ArrayList<Costumer>();

                sortQueue(array, sort, count);
            
            
                int i=0;
                while(i<sort.size()){
                    
                    array.addFirst(sort.get(sort.size()-1-i));
                    i++;
                }
            }
            while(counter>=0){
                
                counter--;
            }
        }
        System.out.println("end function");
        displayCostumerInfor(list);
    }
    
    /**
     * 
     * @param arr bekleyen costumerler
     * @param sort kuyraga alinan costumerler siralanıp dondurelcek
     * @param count kac tane kuyrukta olan costumer sayisi
     */
    private void sortQueue(Queue<Costumer> arr,ArrayList<Costumer> sort,int count){
        while(count>=0){
            sort.add(arr.poll());
            count--;
        }
        
        if(sort.size()>1){
            Collections.sort(sort,new MyCostumerComperator());
            int i=0;
            
            while(i<sort.size()){
                arr.offer(sort.get(sort.size()-i-1));
                i++;
            }
       
                
        }

    }
    
    /**
     * Costumer tipine ve time gore verilen iki costumer siraliyor
     */
    class MyCostumerComperator implements Comparator<Costumer>{
 
        @Override
        public int compare(Costumer e1, Costumer e2) {
            if(e1==null && e2==null)
                return 0;
            int compare = e1.getCostumerType().compareTo(e2.getCostumerType());
            if(compare<=0){
                if(compare==0){
                    int e1Time = e1.getArrivalTimeHour()*60 + e1.getArrivalTimeMinute();
                    int e2Time = e2.getArrivalTimeHour()*60 + e2.getArrivalTimeMinute();
                    if(e1Time>e2Time)
                        return 1;
                    else
                        return -1;
                }
                
                return -1;
            } else{
                return 1;
            }
        }
    }

    
    /**
     * 
     * @param array
     * @param arrTime
     * @return kuyrugun en basındaki elemanın arrivalTime 
     * suresince kac tane costumer bulunuyor onu hesaplıyor
     */
    private int totalCostumerInQueue(Queue<Costumer> array,int arrTime){
        int count=0;
        Costumer cos;
        
        while(true){
    
            if(array.size()==0)
                return -1;
            cos = array.poll();
            int cosTime = cos.getArrivalTimeHour()*60 + cos.getArrivalTimeMinute();
            /*System.out.print(cos.getArrivalTimeHour() + " " + cos.getArrivalTimeMinute());
            System.out.print(" " + cos.getServiceTime() + " " + cos.getCostumerType() + "\n");*/
            if(arrTime>=cosTime){
                count++;
               // System.out.println("arrTime : " +arrTime+ " cosTime : " + cosTime );
                if(array.size()==1)
                {
                    array.offer(cos);
                    break;
                }
                
            }else{
                array.offer(cos);
                break;
            }

           
            array.offer(cos);
        }
        
        int counter = 0;

        while(counter<count){
            cos = array.getLast();
            array.addFirst(cos);
            counter++;
        }
        
        return count;
    }
    
    /**
     * 
     * @param array 
     * Verilen costumerleri ekrana basiyor
     */
    public void displayCostumerInfor(Queue<Costumer> array){
        int i=0,size= array.size();
        System.out.println("Display");
        while (size!=i) {
            Costumer temp = array.poll();
            System.out.print(temp.getArrivalTimeHour() + " " + temp.getArrivalTimeMinute());
            System.out.print(" " + temp.getServiceTime() + " " + temp.getCostumerType() + "\n");
            array.offer(temp);
            i++;
        }
    }
    
    /**
     * 
     * @param arr 
     * Dosyadan okudugu Costumerleri parse ederek
     * Queue atiyor
     */
    public void readFile(Queue<Costumer> arr){
        try{
          
            BufferedReader reader = new BufferedReader(new FileReader("data1.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line);
                Costumer cos= new Costumer();
                while(str.hasMoreTokens()){
                    cos.setArrivalTimeHour(Integer.parseInt(str.nextToken()));
                    cos.setArrivalTimeMinute(Integer.parseInt(str.nextToken()));
                    cos.setServiceTime(Integer.parseInt(str.nextToken()));
                    cos.setCostumerType(str.nextToken());
                    arr.offer(cos);
                }
            }
       } catch (IOException x) {
            System.err.println(x);
        }
    }

}