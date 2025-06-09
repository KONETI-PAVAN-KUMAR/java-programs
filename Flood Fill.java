import java.util.*;

public class Main {
    class Pair{
        int first;
        int second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    public void BFS(int [][]image, int visited[][], int sr, int sc,int color){
        int m = image.length;
        int n = image[0].length;
        visited[sr][sc] = 1;
        int initial = image[sr][sc];
        image[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        while(!q.isEmpty()){
            Pair node =  q.remove();
            int first = node.first;
            int second = node.second;

            // Right
            if (second < n - 1 && image[first][second + 1] == initial  && visited[first][second + 1] == 0) {
                q.add(new Pair(first, second + 1));
                image[first][ second + 1] = color;
                visited[first][second + 1] = 1;
            }

            // Left
            if (second > 0 && image[first][second - 1] == initial && visited[first][second - 1] == 0) {
                q.add(new Pair(first, second - 1));
                image[first][ second - 1] = color;
                visited[first][second - 1] = 1;
            }

            // Down
            if (first < m - 1 && image[first + 1][second] == initial && visited[first + 1][second] == 0) {
                q.add(new Pair(first + 1, second));
                image[first + 1][second] = color;
                visited[first + 1][second] = 1;
            }

            // Up
            if (first > 0 && image[first - 1][second] == initial && visited[first - 1][second] == 0) {
                q.add(new Pair(first - 1, second));
                image[first - 1][second] = color;
                visited[first - 1][second] = 1;
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int visited[][] = new int[m][n];

        BFS(image, visited, sr, sc, color);

        return image;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main sol = new Main();

        System.out.print("Enter number of rows (m): ");
        int m = sc.nextInt();
        System.out.print("Enter number of columns (n): ");
        int n = sc.nextInt();

        int[][] image = new int[m][n];

        System.out.println("Enter the image matrix row-wise:");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                image[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row (sr): ");
        int sr = sc.nextInt();
        System.out.print("Enter starting column (sc): ");
        int scCol = sc.nextInt();  // renamed variable to avoid conflict with Scanner

        System.out.print("Enter new color: ");
        int newColor = sc.nextInt();

        int[][] result = sol.floodFill(image, sr, scCol, newColor);

        System.out.println("Flood filled image:");
        for(int i = 0; i < result.length; i++){
            for(int j = 0; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
