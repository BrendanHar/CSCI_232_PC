package Labs.Lab7;


import java.util.*;

public class Main {


    private static Integer higher(HashSet<Integer> hashSet, int value){
        Integer[] hashArr = new Integer[hashSet.size()];
        int currentIndex = 0;
        for (Integer number : hashSet){
            hashArr[currentIndex] = number;
            currentIndex++;
        }
        Arrays.sort(hashArr);


        for (int i = 0; i < hashArr.length; i++){
            if ((Integer) value == hashArr[i]){
                return hashArr[i+1];
            }
            else if (value < hashArr[i]){
                return hashArr[i];
            }
        }

        return null;
    }

    private static Integer ceiling(HashSet<Integer> hashSet, int value){
        Integer[] hashArr = new Integer[hashSet.size()];
        boolean c = false;
        int currentIndex = 0;
        for (Integer number : hashSet){
            hashArr[currentIndex] = number;
            currentIndex++;
        }
        Arrays.sort(hashArr);


        for (int i = 0; i < hashArr.length; i++){
            if ((Integer) value == hashArr[i]){
                if ((Integer) value == hashArr[i]){
                    c = true;
                    return hashArr[i];
                }
                else if (value < hashArr[i]){
                    c = true;
                    return hashArr[i];
                }
            }
        }
        return null;
    }
    public static void main(String[] args) {

        ArrayList<Long> hashSetTimes = new ArrayList<>();
        ArrayList<Long> treeSetTimes = new ArrayList<>();

        int[] sizes = {500000, 750000, 1000000,1250000};
        System.out.println("HashSet Ceiling Time");
        for (int size : sizes) {
            Random r = new Random();
            HashSet<Integer> h = new HashSet<>();
            System.out.println("HashSet Size: " + size);

            for (int i = 0; i < size; i++) {
                h.add(r.nextInt());
            }
            ceiling(h, 100);
        }

//            for (int i = 0; i < 10; i++){
//                long startTime = System.nanoTime();
//                ceiling(h, 10000);
//                long elapsedTime = System.nanoTime() - startTime;
//                hashSetTimes.add(elapsedTime);
//                System.out.println( elapsedTime/1000000000.0);
//            }
//
////            long hashAverage = 0;
////            for (int i = 0; i < hashSetTimes.size(); i++){
////                hashAverage += hashSetTimes.get(i);
////            }
////            hashAverage=hashAverage/hashSetTimes.size();
////            System.out.println("Average time: " + hashAverage/1000000000.0);
//        }
//
//        System.out.println();
//        System.out.println("HashSet Higher Time");
//        for (int size : sizes){
//            Random r = new Random();
//            HashSet<Integer> h = new HashSet<>();
//            System.out.println("HashSet Size: " + size);
//
//            for (int i = 0; i < size; i++){
//                h.add(r.nextInt());
//            }
//
//            for (int i = 0; i < 10; i++){
//                long startTime = System.nanoTime();
//                higher(h, r.nextInt());
//                long elapsedTime = System.nanoTime() - startTime;
//                hashSetTimes.add(elapsedTime);
//                System.out.println( elapsedTime/1000000000.0);
//            }
//
//
//
//        }
//
//
////        long hashAverage = 0;
////        for (int i = 0; i < hashSetTimes.size(); i++){
////            hashAverage += hashSetTimes.get(i);
////        }
////        hashAverage=hashAverage/hashSetTimes.size();
////        System.out.println(hashAverage/1000000000.0);
//
//        System.out.println();
//        System.out.println("TreeSet Ceiling Time");
//
//        for (int size : sizes){
//
//            Random r = new Random();
//            TreeSet<Integer> t = new TreeSet<>();
//            System.out.println("TreeSet of: " + size);
//
//            for (int i = 0; i < size; i++){
//                t.add(r.nextInt());
//            }
//
//            for (int i = 0; i < 10; i++){
//                long startTime = System.nanoTime();
//                t.ceiling(r.nextInt());
//                long elapsedTime = System.nanoTime() - startTime;
//                treeSetTimes.add(elapsedTime);
//                System.out.println(elapsedTime/1000000000.0);
//            }
//        }
//
//
////        long treeAverage = 0;
////        for (int i = 0; i < treeSetTimes.size(); i++){
////            treeAverage += treeSetTimes.get(i);
////        }
////        treeAverage=treeAverage/treeSetTimes.size();
////        System.out.println(treeAverage/1000000000.0);
////        System.out.println();
//
//
//        ArrayList<Long> treeHigherTime = new ArrayList<>();
//        System.out.println();
//        System.out.println("TreeSet Higher Time");
//
//        for (int size : sizes){
//            Random r = new Random();
//            TreeSet<Integer> t = new TreeSet<>();
//            System.out.println("TreeSet of: " + size);
//
//            for (int i = 0; i < size; i++){
//                t.add(r.nextInt());
//            }
//            for (int i = 0; i < 10; i++){
//                long startTime = System.nanoTime();
//                t.ceiling(r.nextInt());
//                long elapsedTime = System.nanoTime() - startTime;
//                treeHigherTime.add(elapsedTime);
//                System.out.println(elapsedTime/1000000000.0);
//            }
//        }
//
////        long treeHigherAverage = 0;
////        for (int i = 0; i < treeHigherTime.size(); i++){
////            treeHigherAverage += treeHigherTime.get(i);
////        }
////        treeHigherAverage=treeHigherAverage/treeHigherTime.size();
////        System.out.println( treeHigherAverage/1000000000.0);
////        System.out.println();




    }
}
