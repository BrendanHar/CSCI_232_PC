package Labs.Lab9;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author yaw
 */
public class Graph {

    private LinkedList<Integer>[] adjacencyList;
    private int numEdges;
    
    public Graph(int numVertices) {
        adjacencyList = new LinkedList[numVertices];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }
    
    public Graph(String file) {
        loadGraph(file);
    }

    private void loadGraph(String file) {
        // TODO: Code to load graph from file.
        String fileOutput = "";
        try {
            File graphIn = new File(file);
            if (!graphIn.exists()) {
                System.out.println("Invalid input. Check your filename");
            }
            else {
                Scanner s = new Scanner(graphIn);
                Scanner count = new Scanner(graphIn);
                int lines = 0;
                count.nextLine();
                while (count.hasNextLine()) {
                    count.nextLine();
                    lines++;
                }

            String[] text = new String[lines];
            String input = "";
            int size = s.nextInt();
            int i = 0;


            while (s.hasNextLine()) {
                input += s.nextLine();
                input += "\n";
            }


            text = input.split("\n");

            String[] test = new String[2];
            int[] arr = new int[3];

            adjacencyList = new LinkedList[size];
            for (int j= 0; j < adjacencyList.length; j++){
                adjacencyList[j] = new LinkedList<>();
            }


            for (int j = 0; j < lines + 1; j++){
                test = text[j].split(",");
                for (int k = 0; k < test.length; k++){
                    if (!test[k].equals("")) {
                        arr[k] = Integer.parseInt(test[k]);
//                        System.out.print(arr[k] + " ");
                    }
                }

                adjacencyList[arr[0]].add(arr[1]);
                adjacencyList[arr[1]].add(arr[0]);

//                adjacencyList[Integer.parseInt(test[0])].add(Integer.parseInt(test[1]));
//                System.out.println(text[j]);
            }
//            int counter = 0;
//            for (int k = 0; k < adjacencyList.length; k++){
//                System.out.print("Vertex: " + counter + "- ");
//                for (int element : adjacencyList[k]){
//                    System.out.print(element + ", ");
//                }
//                counter++;
//                System.out.println();
//            }
        }
    }
        catch (
    FileNotFoundException e) {
        e.printStackTrace();
    }


    }

    public int getNumVertices() {
        return adjacencyList.length;
    }

    public int getNumEdges() {
        return numEdges;
    }

    public void addEdge(int vertex1, int vertex2) {
        adjacencyList[vertex1].add(vertex2);
        adjacencyList[vertex2].add(vertex1);

        numEdges++;
    }

    public void removeEdge(int vertex1, int vertex2) {
        if (adjacencyList[vertex1].contains(vertex2)) {
            adjacencyList[vertex1].remove((Integer) vertex2);
            adjacencyList[vertex2].remove((Integer) vertex1);

            numEdges--;
        }
    }

    public LinkedList<Integer> getNeighbors(int vertex) {
        return adjacencyList[vertex];
    }
}
