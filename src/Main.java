import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String sudokuString = "007530000010040725000827060451960800036000040000074000075006003309208500248053010";
        int [][] sudokuArray = new int[9][9];
        Point [][] pointsArray = new Point[9][9];


        Methods met = new Methods();
        // naplnenie pola objektami
        Point[][] gameBoard = met.creatingGameboardOfPoints(sudokuString,sudokuArray,pointsArray);

        //vykreslenie pola
        met.printing(gameBoard);

        //checkovanie pola
        boolean change = met.checkingPoints(gameBoard);
        System.out.println("change "+change);
        if(change){
            met.printing(gameBoard);
        }









    }
}
