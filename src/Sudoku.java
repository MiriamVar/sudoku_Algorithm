public class Sudoku {
    private String stringSudoku;
    private Gameboard gameboard;

    public Sudoku(String stringSudoku) {
        this.stringSudoku = stringSudoku;
        this.gameboard = new Gameboard(stringSudoku);
    }

    public void play(){
        while (!this.gameboard.isComplete()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    this.gameboard.checkingPoints(i,j);

                }
            }
        }
        this.gameboard.printing();
    }
}
