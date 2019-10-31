package HomeWork_less7;

import HomeWork_less7.queue.Queue;
import HomeWork_less7.queue.QueueImpl;
import HomeWork_less7.stack.Stack;
import HomeWork_less7.stack.StackImpl;

public class Graph {

    private Vertex[] vertexList;
    private int[][] matrix;
    private int size;
    private int[][] points;

    Stack stack;
    Queue queue;

    public Graph(int VERTS) {
        stack = new StackImpl(VERTS);
        queue = new QueueImpl(VERTS);

        vertexList = new Vertex[VERTS];
        matrix = new int[VERTS][VERTS];
        points = new int[VERTS][VERTS];
        size = 0;
    }

    public void addVertex(char label) {
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;
    }

    public void display(int vertex) {
        System.out.println(vertexList[vertex].label);
    }

    private int getUnvisitVertex(int ver) {
        for (int i = 0; i < size; i++) {
            if (matrix[ver][i] == 1 && !vertexList[i].wasVisit) {
                return i;
            }
        }
        return -1;
    }

    //depth-first search
    public void dfs() {
        vertexList[0].wasVisit = true;
        display(0);
        stack.push(0);
        while (!stack.isEmpty()) {
            int v = getUnvisitVertex(stack.peek());
            if (v == -1) {
                stack.pop();
            } else {
                vertexList[v].wasVisit = true;
                display(v);
                stack.push(v);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisit = false;
        }
    }

    //breadth-first search
    public void bfs() {
        vertexList[0].wasVisit = true;
        display(0);
        queue.insert(0);
        int w;
        while(!queue.isEmpty()){
            int v = queue.remove();
            while((w = getUnvisitVertex(v)) != -1){
                vertexList[w].wasVisit = true;
                display(w);
                queue.insert(w);
                stack.push(w);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisit = false;
        }
    }

    //breadth-first search for chr
    public void bfsFind(char chr) {
        vertexList[0].wasVisit = true;
        queue.insert(0);
        int w;
        boolean find = false;
        while(!queue.isEmpty() && !find){
            int v = queue.remove();
            points[v][0] = v;
            int i = 1;
            while((w = getUnvisitVertex(v)) != -1 && !find){
                vertexList[w].wasVisit = true;
                points[v][i] = w;
                if (vertexList[w].label == chr){
                    find = true;
                    wayPointer(w);
                }
                queue.insert(w);
                i++;
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisit = false;
        }
    }

    private char wayPointer(int w) {
        if (w==0){
            System.out.println(vertexList[0].label);
            return vertexList[0].label;
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < points[i].length; j++) {
                if (points[i][j] == w){
                    System.out.println(vertexList[points[i][j]].label);
                    return wayPointer(i);
                }
            }
        }
        return vertexList[0].label;
    }

    public boolean isEmpty(){
        if(this.size > 0) {
            return false;
        } else {
            return true;
        }
    }
}
