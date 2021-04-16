package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Vertex implements Comparable<Vertex> {

    private final String name;
    private final Set<Edge> edges = new HashSet<>();
    private Vertex parent;
    private Integer weight = Integer.MAX_VALUE;

    public Vertex(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addEdgeDirected(Edge edge) {
        this.edges.add(edge);
    }

    public void addEdgeUndirected(Vertex vertex, Integer weight) {
        this.addEdgeDirected(new Edge(vertex, weight));
        vertex.addEdgeDirected(new Edge(this, weight));
    }

    public List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Vertex o) {
        return Integer.compare(this.weight, o.weight);
    }
}
