public class Main {
    public static void main(String[] args) {
        String sudokuString = "007530000010040725000827060451960800036000040000074000075006003309208500248053010";
        Sudoku hra = new Sudoku(sudokuString);
        hra.play();
    }
}
