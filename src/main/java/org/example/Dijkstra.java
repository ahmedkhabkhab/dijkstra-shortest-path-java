package org.example;

import java.util.*;

public class Dijkstra {

    public static void printShortestPath(Vertex source, Vertex destination) {

        Dijkstra.computeShortestPaths(source);

        Map<Vertex, Integer> path = getShortestPath(destination);


        StringBuilder stringBuilder = new StringBuilder();
        for (Vertex v: path.keySet()) {
            stringBuilder.insert(0, String.format("%s ---> ", v.getName()));
        }

        String str = stringBuilder.toString();
        str = str.substring(0, str.lastIndexOf(" ---> "));

        System.out.println(str);

        System.out.printf("Total distance = %d\n", destination.getWeight());

    }

    private static void computeShortestPaths(Vertex source) {

        Queue<Vertex> queue = new PriorityQueue<>();

        source.setWeight(0);
        queue.add(source);

        while(!queue.isEmpty()) {
            Vertex u = queue.poll();

            for(Edge e: u.getEdges()) {
                Vertex v = e.getDestination();
                Integer distanceFromU = u.getWeight() + e.getDistance();
                if (distanceFromU < v.getWeight()) {
                    queue.remove(v);
                    v.setWeight(distanceFromU);
                    v.setParent(u);
                    queue.add(v);
                }
            }
        }
    }

    private static Map<Vertex, Integer> getShortestPath(Vertex destination) {

        Map<Vertex, Integer> path = new LinkedHashMap<>();

        Vertex v = destination;

        while(v != null) {
            path.put(v, v.getWeight());
            v = v.getParent();
        }

        return path;
    }

}
