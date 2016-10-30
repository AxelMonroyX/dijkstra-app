package com.axelmonroy.app;

import java.util.ArrayList;

public class Graph {

    private Nodo[] nodos;
    private int noOfNodes;
    private Edge[] edges;
    private int noOfEdges;
    private int[] predecesor;


    public Graph(Edge[] edges) {
        this.edges = edges;

        this.noOfNodes = getNumberNodos(edges);
        this.nodos = new Nodo[this.noOfNodes];

        for (int n = 0; n < this.noOfNodes; n++) {
            this.nodos[n] = new Nodo();
        }

        this.noOfEdges = edges.length;

        for (int edgeToAdd = 0; edgeToAdd < this.noOfEdges; edgeToAdd++) {
            this.nodos[edges[edgeToAdd].getFromNodeIndex()].getEdges().add(edges[edgeToAdd]);
            this.nodos[edges[edgeToAdd].getToNodeIndex()].getEdges().add(edges[edgeToAdd]);
        }

    }

    private int getNumberNodos(Edge[] edges) {
        int noOfNodes = 0;

        for (Edge e : edges) {
            if (e.getToNodeIndex() > noOfNodes)
                noOfNodes = e.getToNodeIndex();
            if (e.getFromNodeIndex() > noOfNodes)
                noOfNodes = e.getFromNodeIndex();
        }

        noOfNodes++;

        return noOfNodes;
    }

    public void getShortestDistanceNodos() {
        this.nodos[0].setDistanceFromSource(0);
        int nextNode = 0;

        for (int i = 0; i < this.nodos.length; i++) {
            ArrayList<Edge> currentNodeEdges = this.nodos[nextNode].getEdges();

            for (int joinedEdge = 0; joinedEdge < currentNodeEdges.size(); joinedEdge++) {
                int neighbourIndex = currentNodeEdges.get(joinedEdge).getNeighbourIndex(nextNode);

                if (!this.nodos[neighbourIndex].isVisited()) {
                    int tentative = this.nodos[nextNode].getDistanceFromSource() + currentNodeEdges.get(joinedEdge).getLength();

                    if (tentative < nodos[neighbourIndex].getDistanceFromSource()) {
                        nodos[neighbourIndex].setDistanceFromSource(tentative);
                    }
                }
            }

            nodos[nextNode].setVisited(true);

            nextNode = getNodeShortestDistanced();

        }
    }

    private int getNodeShortestDistanced() {
        int storedNodeIndex = 0;
        int storedDist = Integer.MAX_VALUE;

        for (int i = 0; i < this.nodos.length; i++) {
            int currentDist = this.nodos[i].getDistanceFromSource();

            if (!this.nodos[i].isVisited() && currentDist < storedDist) {
                storedDist = currentDist;
                storedNodeIndex = i;

            }
        }

        return storedNodeIndex;
    }

    public void printShortestPath() {
        String output = "Number of nodos = " + this.noOfNodes;
        output += "\nNumber of edges = " + this.noOfEdges;

        for (int i = 0; i < this.nodos.length; i++) {
            output += ("\nDistance from node 0 to nodo " + i + " is " + nodos[i].getDistanceFromSource());
        }

        System.out.println(output);
    }

    public Nodo[] getNodos() {
        return nodos;
    }

    public int getNoOfNodes() {
        return noOfNodes;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public int getNoOfEdges() {
        return noOfEdges;
    }

}