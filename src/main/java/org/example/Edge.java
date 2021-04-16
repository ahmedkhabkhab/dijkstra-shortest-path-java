package org.example;

public class Edge {

    private final Vertex destination;
    private final Integer distance;

    public Edge(Vertex destination, Integer distance) {
        this.destination = destination;
        this.distance = distance;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Integer getDistance() {
        return distance;
    }
}