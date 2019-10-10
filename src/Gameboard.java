import java.util.ArrayList;

public class Gameboard {

    private Point[][] board;
    private String sudokuString;

    public Gameboard(String sudokuString) {
        this.sudokuString = sudokuString;
        this.board = new Point[9][9];
        creatingGameboardOfPoints();
    }

    public int[] checkRow(int x, int y){
        int[] out = new int[9];
        int value = 0;
        for (int i =0; i<9; i++){
            if (i == y){
                continue;
            }
            if (board[x][i].getValue() != 0){
                out[value] = board[x][i].getValue();
                value++;
            }
        }
        return out;

    }

    public int[] checkColumn(int x, int y){
        int[] out = new int[9];
        int value = 0;
        for (int i =0; i<9; i++){
            if (i == x){
                continue;
            }
            if (board[i][y].getValue() != 0){
                out[value] = board[i][y].getValue();
                value++;
            }
        }
        return out;
    }

    public int[] checkCell(int x, int y){
        int[] out = new int[9];
        int value = 0;
        int lineX = (x/3)*3;
        int colX= (y/3)*3;

        for (int i=lineX; i<lineX+3; i++) {
            for (int j = colX; j < colX + 3; j++) {
                if (x == i && y == j) {
                    continue;
                }
                int tempNum = board[i][j].getValue();
                if (tempNum != 0) {
                    out[value] = board[i][j].getValue();
                    value++;
                }
            }
        }
        return out;
    }

    public void creatingGameboardOfPoints(){
        char[] swap = this.sudokuString.toCharArray();
        int i,j;
        int k = 0;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                int number = Integer.parseInt(String.valueOf( swap[k]));
                k++;
                if (number != 0){
                    this.board[i][j] = new Point(number);
                } else {
                    this.board[i][j] = new Point();
                }
            }
        }
    }

    public void printing(){
        int i,j;
        for (i =0; i<9; i++){
            for (j=0; j<9; j++){
                System.out.print(this.board[i][j].getValue()+" ");
                if(j == 2 || j ==5 || j ==8){
                    System.out.print(" ");
                }
            }
            System.out.println();
            if(i == 2 || i ==5 || i ==8){
                System.out.println(" ");
            }
        }
    }

    public void checkingPoints(int x, int y) {
        if (this.board[x][y].getValue() != 0){
            return;
        }
        int[] usedInRow = this.checkRow(x,y);
        int[] usedInCol = this.checkColumn(x,y);
        int[] usedInCell = this.checkCell(x,y);

        ArrayList<Integer> possible = new ArrayList<>();

        for (int i = 1; i < 10; i++) {
            if (arrContains(usedInRow, i)){
                continue;
            }
            if (arrContains(usedInCol, i)){
                continue;
            }
            if (arrContains(usedInCell, i)){
                continue;
            }
            possible.add(i);
        }
        if (possible.size() == 1){
            this.board[x][y].setValue(possible.get(0));
        }
    }

    private boolean arrContains(int[] arr, int number){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number){
                return true;
            }
        }
        return false;
    }


    public boolean isComplete(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.board[i][j].getValue() == 0){
                    return false;
                }
            }
        }
        return true;
    }




}
