import java.util.HashSet;
import java.util.Set;
public class Main{
    public static void dfsAdjMatrix(int[][] graph,int start,Set<Integer>visited){
        if(visited==null){
            visited=new HashSet<>();
        }
        visited.add(start);
        System.out.print(start+" ");
        for(int adjacent=0;adjacent<graph.length;adjacent++){
            if(graph[start][adjacent]==1 && !visited.contains(adjacent)){
                dfsAdjMatrix(graph,adjacent,visited);
            }
        }
    }
    public static void main(String[] args){
        int[][] graph={{1,1,1,1},
                       {1,0,0,1},
                       {1,0,0,1},
                       {1,1,1,1}};
                       System.out.println("\nDFS using Adjacency Matrix: ");
                       dfsAdjMatrix(graph,0,null);
    }
}