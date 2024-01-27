import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
    * Puzzle Structure:
    *   +---+---+---+
    *   | 1 | 2 | 3 |
    *   +---+---+---+
    *   | 4 | 5 | 6 |
    *   +---+---+---+ 
    *   | 7 | 8 |   | 
    *   +---+---+---+ 
    */

public class BlockPuzzle {
    private ArrayList<String> recordedSteps = new ArrayList<>();
    private char[][] newMap = new char[4][4];
    private String TARGET = "12345678 ";
    private int MAX_STEPS = 50;

    
    // INIT STEPS
    private final int UPPER_BOUND = 3;
    private final int LOWER_BOUND = 1;

    private void generateDefaultPuzzle(){
        String newMapInList = "16542783 ";
        this.newMap = stringToMap(newMapInList);
    }

    private char[][] stringToMap(String mapInString){
        char[][] newMap = new char[4][4];
        for(int i = 0; i < 9; i ++){
            char val = mapInString.charAt(i);
            int y = this.indexToCoordinate(i)[1];
            int x = this.indexToCoordinate(i)[0];
            newMap[y][x] = val;
        }
        return newMap;
    }

    private String mapToString(char[][] mapIn2DArray){
        String mapInString = "";
        for (int y = 1; y <= 3; y++){
            for (int x = 1; x <= 3; x++){
                mapInString += mapIn2DArray[y][x];
            }
        }
        return mapInString;
    }

    private int[] indexToCoordinate(int index){
        return new int[]{index % 3 + 1, index / 3 + 1};
    }

    // DRAW BOARD
    private void drawHorizontalBorder(){
        System.out.println("+---+---+---+");
    }

    private void drawTopBoarder(){
        this.drawHorizontalBorder();
    }

    private void drawNumberRows(int row, char[][] map){
        System.out.print("|");
        for(int col = 1; col <= 3; col ++){
            System.out.print(" " + map[row][col] + " |");
        }
        System.out.println();
    }

    private void drawRow(int row, char[][] map){
        this.drawNumberRows(row, map);
        this.drawHorizontalBorder();
    }

    private void drawPuzzleMap(char[][] map){
        drawTopBoarder();
        for(int row = 1; row <= 3; row ++){
            this.drawRow(row,map);
        }
    }

    // SOLVE METHOD
    private void solvePuzzle(){
        int[] spacePosition ={3,3};
        this.depthFirstSearch(spacePosition,newMap);
    }

    private char[][] copyMap(char[][] map){
        char[][] copiedMap = new char[4][4];
        for(int x = 0; x <= 3; x ++){
            for (int y = 0; y <= 3; y ++){
                copiedMap[x][y] = map[x][y];
            }
        }
        return copiedMap;
    }

    private void recordStep(char[][] board){
        recordedSteps.add(mapToString(board));
    }

    private void removeLastStep(){
        recordedSteps.remove(recordedSteps.size()-1);
    }

    private boolean depthFirstSearch(int[] spacePosition, char[][] board){
        if (this.recordedSteps.size() > MAX_STEPS){
            return false;
        }

        if (this.reachedTarget(board)){
            recordStep(board);
            return true;
        }
        if (this.enteredLoop(board)){
            return false;
        }        
        
        recordStep(board);
        Boolean solvedPuzzle = false;
        if(canSwapLeft(spacePosition)){
            solvedPuzzle = solvedPuzzle || swapLeft(spacePosition, board);
        } if (canSwapRight(spacePosition)){
            solvedPuzzle = solvedPuzzle || swapRight(spacePosition, board);
        } if (canSwapDown(spacePosition)){
            solvedPuzzle = solvedPuzzle || swapDown(spacePosition, board);
        } if (canSwapUp(spacePosition)){
            solvedPuzzle = solvedPuzzle || swapUp(spacePosition,board);
        }
        
        if(!solvedPuzzle){
            removeLastStep();
        }
    
        return solvedPuzzle;
    }

    private Boolean swapLeft(int[] spacePosition, char[][] board){
        int spaceX = spacePosition[0]; int spaceY = spacePosition[1];
        int[] newPosition = {spaceX - 1, spaceY};
        char[][] newBoard = copyMap(board);
        
        newBoard[spaceY][spaceX] = board[newPosition[1]][newPosition[0]];
        newBoard[newPosition[1]][newPosition[0]] = ' ';
        return depthFirstSearch(newPosition, newBoard);
    }

    private Boolean swapRight(int[] spacePosition, char[][] board){
        int spaceX = spacePosition[0]; int spaceY = spacePosition[1];
        int[] newPosition = {spaceX + 1, spaceY};
        char[][] newBoard = copyMap(board);

        newBoard[spaceY][spaceX] = board[newPosition[1]][newPosition[0]];
        newBoard[newPosition[1]][newPosition[0]] = ' ';
        return depthFirstSearch(newPosition, newBoard);
    }
    
    private Boolean swapDown (int[] spacePosition, char[][] board){
        int spaceX = spacePosition[0]; int spaceY = spacePosition[1];
        int[] newPosition = {spaceX, spaceY + 1};
        char[][] newBoard = copyMap(board);

        newBoard[spaceY][spaceX] = board[newPosition[1]][newPosition[0]];
        newBoard[newPosition[1]][newPosition[0]] = ' ';
        return depthFirstSearch(newPosition, newBoard);
    }
    
    private Boolean swapUp(int[] spacePosition, char[][] board){
        int spaceX = spacePosition[0]; int spaceY = spacePosition[1];
        int[] newPosition = {spaceX, spaceY - 1};
        char[][] newBoard = copyMap(board);

        newBoard[spaceY][spaceX] = board[newPosition[1]][newPosition[0]];
        newBoard[newPosition[1]][newPosition[0]] = ' ';
        return depthFirstSearch(newPosition, newBoard);
    }


    private Boolean reachedTarget(char[][] latestBoard){
        return TARGET.equals(mapToString(latestBoard));
    }

    private Boolean enteredLoop(char[][] latestBoard){
        for(String map : this.recordedSteps){
            if(map.equals(mapToString(latestBoard))){
              return true;  
            }
        }
        return false;
    }

    private Boolean canSwapLeft(int[] spacePosition){
        return (spacePosition[0] > LOWER_BOUND);
    }

    private Boolean canSwapRight(int[] spacePosition){
        return (spacePosition[0] < UPPER_BOUND);
    }
    
    private Boolean canSwapDown(int[] spacePosition){
        return (spacePosition[1] < UPPER_BOUND);
    }

    private Boolean canSwapUp (int[] spacePosition){
        return (spacePosition[1] > LOWER_BOUND);
    }

    private void printSolutioin(){
        for (String mapInStrings : recordedSteps){
            drawPuzzleMap(stringToMap(mapInStrings));
        }
    }

    private void exec(){
        this.generateDefaultPuzzle();
        this.solvePuzzle();
        this.printSolutioin();
    }

    public static void main(String[] args){
        BlockPuzzle newPuzzle = new BlockPuzzle();
        newPuzzle.exec(); 
    }
}
