import java.io.*;
import java.util.*;

public class problem83 {
    public static void main(String[] args) {
        int[][] matrix = new int[80][80];
        try{ //import text file
            File file = new File("0083_matrix.txt");
            Scanner inputScanner = new Scanner(file);
            int row = 0;
            while(inputScanner.hasNext()){
                String rawLine = inputScanner.nextLine();
                String[] line = rawLine.split(",");
                for(int i = 0; i<line.length; i++){
                    matrix[row][i] = Integer.parseInt(line[i]);
                }
                row++;
            }
            inputScanner.close();
        }
        catch(Exception e){
            System.out.println("Text File Error!!!!");
        }

        int[][] distance = new int[80][80];
        for(int i = 0; i<80; i++){
            for(int j = 0; j<80; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[0][0] = matrix[0][0];
        
        boolean found = false;

        while(!found){
            int[] closestIndex = closestUnvisited(distance); //get closest node
            int x = closestIndex[0];
            int y = closestIndex[1];

            if(x==79 && y==79){
                found = true;
                System.out.println(distance[x][y]);
            }

            if(x > 0){ //check adjacent cells
                if(distance[x-1][y] != -1 && distance[x-1][y] > distance[x][y]+matrix[x-1][y]){
                    distance[x-1][y] = distance[x][y]+matrix[x-1][y];
                }
            }
            if(x < 79){
                if((distance[x+1][y] != -1) && (distance[x+1][y] > distance[x][y]+matrix[x+1][y])){
                    distance[x+1][y] = distance[x][y]+matrix[x+1][y];
                }
            }
            if(y > 0){
                if(distance[x][y-1] != -1 && distance[x][y-1] > distance[x][y]+matrix[x][y-1]){
                    distance[x][y-1] = distance[x][y]+matrix[x][y-1];
                }
            }
            if(y < 79){
                if(distance[x][y+1] != -1 && distance[x][y+1] > distance[x][y]+matrix[x][y+1]){
                    distance[x][y+1] = distance[x][y]+matrix[x][y+1];
                }
            }

            distance[x][y] = -1; //set as visited
        }
    }
    static int[] closestUnvisited(int[][] distance){
        int[] bestNode = new int[2];
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i<80; i++){
            for(int j = 0; j<80; j++){
                if(distance[i][j] < Integer.MAX_VALUE && distance[i][j] != -1){
                    if(distance[i][j] < minValue){
                        bestNode[0] = i;
                        bestNode[1] = j;
                        minValue = distance[i][j];
                    }
                }
            }
        }
        return bestNode;
    }
}