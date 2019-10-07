import java.util.List;

public class Main {
    public static void main(String[] args) {
        String sudokuString = "007530000010040725000827060451960800036000040000074000075006003309208500248053010";
        int [][] sudokuArray = new int[9][9];
        int i = 0;
        int j = 0;
        int k = 0;
        int m = 0;


        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                sudokuArray[i][j]=Integer.parseInt(String.valueOf( sudokuString.charAt(k)));
                System.out.println(sudokuArray[i][j]);
                k++;
            }
        }

        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
             //   int value = sudokuArray[m];
                int [][] position =  new int [0][0];
               // Point number = new Point()

                sudokuArray[i][j]=Integer.parseInt(String.valueOf( sudokuString.charAt(k)));
                System.out.println(sudokuArray[i][j]);
                k++;
            }
        }







    }
}
