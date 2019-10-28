package HomeWork_less7;

public class Main {
    public static void main(String[] args) {
        int Vertex = 10;
        Graph graph = new Graph(Vertex);
        for (int i = 65; i < Vertex+65; i++) {
            graph.addVertex((char) i);
        }
        graph.addEdge(0,1); //A-B
        graph.addEdge(1,2); //B-C
        graph.addEdge(0,3); //A-D
        graph.addEdge(3,4); //D-E
        graph.addEdge(4,5); //E-F
        graph.addEdge(0,6); //A-G
        graph.addEdge(6,7); //G-H
        graph.addEdge(7,8); //H-I
        graph.addEdge(2,9); //C-J
        graph.addEdge(2,5); //C-F
        graph.addEdge(6,5); //G-F

        if (!graph.isEmpty()){
            graph.bfs();
            System.out.println();
            // find short way to char by bfs
            graph.bfsFind('F');

        }else {
            System.out.println("Граф пустой");
        }
    }
}
