package com.axelmonroy.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Graph my_graph = new Graph();
        char[] alphabet = "ABCDEFGHIJLMNOPQRSTUVXYZ".toCharArray();
        List<Node> my_nodes = new ArrayList<Node>();


        int fromNodeIndex;
        int toNodeIndex;
        int lengthToNode;

        Scanner scan = new Scanner(System.in);
        System.out.println("# Edges?");
        int cuantos = scan.nextInt();


        for (int x = 0; x < cuantos; x++) {
            Node actualNode = new Node(String.valueOf(alphabet[x]));
            my_nodes.add(actualNode);
        }
        System.out.println(my_nodes.size());

        for (int x = 0; x < cuantos; x++) {
            Node nodeMain = my_nodes.get(x);
            System.out.println("------------ Node:" + alphabet[x] + " ----------");
            String relationWith = scan.next();
            int weight = scan.nextInt();

            Node nodeRelationWith = null;
            for (int i = 0; i < my_nodes.size(); i++) {
                if (my_nodes.get(i).toString().equals(relationWith)) {
                    nodeRelationWith = my_nodes.get(i);
                }
            }

            nodeMain.adjacency = new Edge[]{new Edge(nodeRelationWith, weight)};

        }

        System.out.println("From: ");
        String from = scan.next();
        Node fromNode = null;
        for (int i = 0; i < my_nodes.size(); i++) {
            if (my_nodes.get(i).toString().equals(from)) {
                fromNode = my_nodes.get(i);
            }
        }
        System.out.println("To: ");
        String to = scan.next();
        Node toNode = null;
        for (int i = 0; i < my_nodes.size(); i++) {
            System.out.println(i);
            if (my_nodes.get(i).toString().equals(to)) {
                toNode = my_nodes.get(i);
            }
        }


        my_graph.calculatePaths(fromNode);
        System.out.println("Distance to " + toNode + ": " + toNode.minimumDistance);
        List<Node> path = my_graph.getShortestPathTo(toNode);
        System.out.println("Path: " + path);
    }

}

