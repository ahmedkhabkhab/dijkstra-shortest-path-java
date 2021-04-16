package org.example;

public class App 
{
    public static void main(String[] args) {

        Vertex vertexA = new Vertex("A");
        Vertex vertexB = new Vertex("B");
        Vertex vertexC = new Vertex("C");
        Vertex vertexD = new Vertex("D");
        Vertex vertexE = new Vertex("E");

        vertexA.addEdgeUndirected(vertexB, 3);
        vertexA.addEdgeUndirected(vertexC, 1);

        vertexB.addEdgeUndirected(vertexC, 7);
        vertexB.addEdgeUndirected(vertexD, 5);
        vertexB.addEdgeUndirected(vertexE, 1);

        vertexC.addEdgeUndirected(vertexD, 2);

        vertexD.addEdgeUndirected(vertexE, 7);


        Dijkstra.printShortestPath(vertexA, vertexE);

    }
}
