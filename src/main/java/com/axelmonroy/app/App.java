package com.axelmonroy.app;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int fromNodeIndex;
        int toNodeIndex;
        int lengthToNode;

        Scanner scan = new Scanner(System.in);
        System.out.println("# Edges?");
        int cuantos = scan.nextInt();

        Edge[] edges = new Edge[cuantos];

        for (int x = 0; x < cuantos; x++) {
            System.out.println("------------ Node:"+(x+1)+" ----------");
            System.out.println("From Node Index:");
            fromNodeIndex = scan.nextInt();

            System.out.println("To Node Index:");
            toNodeIndex = scan.nextInt();

            System.out.println("Length To Node:");
            lengthToNode = scan.nextInt();

            edges[x] = new Edge(fromNodeIndex, toNodeIndex, lengthToNode);


        }


        Graph graphNodesWithEdges = new Graph(edges);
        graphNodesWithEdges.getShortestDistanceNodos();
        graphNodesWithEdges.printShortestPath();
    }

}

