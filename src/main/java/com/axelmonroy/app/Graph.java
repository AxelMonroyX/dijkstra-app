package com.axelmonroy.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    public static void calculatePaths(Node fromNode) {
        fromNode.minimumDistance = 0.;
        PriorityQueue<Node> nodePriorityQueue = new PriorityQueue<Node>();
        nodePriorityQueue.add(fromNode);

        while (!nodePriorityQueue.isEmpty()) {
            Node head = nodePriorityQueue.poll();

            for (Edge my_edge : head.adjacency) {
                Node my_node = my_edge.target;
                double weight = my_edge.weight;
                double distanceThroughHead = head.minimumDistance + weight;
                if (distanceThroughHead < my_node.minimumDistance) {
                    nodePriorityQueue.remove(my_node);

                    my_node.minimumDistance = distanceThroughHead;
                    my_node.previous = head;
                    nodePriorityQueue.add(my_node);
                }
            }
        }
    }

    public static List<Node> getShortestPathTo(Node toNode) {
        List<Node> path = new ArrayList<Node>();
        for (Node node = toNode; node != null; node = node.previous)
            path.add(node);

        Collections.reverse(path);
        return path;
    }

}