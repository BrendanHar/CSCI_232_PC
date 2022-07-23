package Labs.Lab6;

import Projects.Project1.Tree;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        ArrayList<Long> hashSetTimes = new ArrayList<>();
        ArrayList<Long> treeSetTimes = new ArrayList<>();

        int[] sizes = {500000, 750000, 1000000,1250000};
        System.out.println("HashSet Insert Time");
        for (int size : sizes){
            Random r = new Random();
            HashSet<Integer> h = new HashSet<Integer>();
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++){
                h.add(r.nextInt());
            }
            long elapsedTime = System.nanoTime() - startTime;
            hashSetTimes.add(elapsedTime);
            System.out.println( elapsedTime/1000000000.0);
        }
        long hashAverage = 0;
        for (int i = 0; i < hashSetTimes.size(); i++){
            hashAverage += hashSetTimes.get(i);
        }
        hashAverage=hashAverage/hashSetTimes.size();
        System.out.println(hashAverage/1000000000.0);

        System.out.println();
        System.out.println("TreeSet Insert Time");
        for (int size : sizes){
            Random r = new Random();
            TreeSet<Integer> t = new TreeSet<>();
            long startTime = System.nanoTime();
            for (int i = 0; i < size; i++){
                t.add(r.nextInt());
            }
            long elapsedTime = System.nanoTime() - startTime;
            treeSetTimes.add(elapsedTime);
            System.out.println(elapsedTime/1000000000.0);
        }
        long treeAverage = 0;
        for (int i = 0; i < treeSetTimes.size(); i++){
            treeAverage += treeSetTimes.get(i);
        }
        treeAverage=treeAverage/treeSetTimes.size();
        System.out.println( treeAverage/1000000000.0);
        System.out.println();

        System.out.println("HashSet Search Time");
        for (int size : sizes){
            Random r = new Random();
            HashSet<Integer> h = new HashSet<Integer>();
            for (int i = 0; i < size; i++){
                h.add(r.nextInt());
            }
            long startTime = System.nanoTime();
            for (int i= 0; i < 10; i++){
                h.contains(r.nextInt());
            }
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println(elapsedTime/1000000000.0);
        }
        System.out.println();

        System.out.println("TreeSet Search Time");
        for (int size : sizes){
            Random r = new Random();
            TreeSet<Integer> t = new TreeSet<Integer>();
            for (int i = 0; i < size; i++){
                t.add(r.nextInt());
            }
            long startTime = System.nanoTime();
            for (int i= 0; i < 10; i++){
                t.contains(r.nextInt());
            }
            long elapsedTime = System.nanoTime() - startTime;
            System.out.println(elapsedTime/1000000000.0);
        }




    }
}
