public class Methods {


    public Point[][] addNumbersToArrayObj(String sudoku, int [][] arr, Point [][] pointsArray){
        int i,j;
        int k = 0;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                arr[i][j]=Integer.parseInt(String.valueOf( sudoku.charAt(k)));
                Point number = new Point();
                int value = arr[i][j];
                number.setValue(value);
                number.setLine(i);
                number.setColumn(j);

                pointsArray[i][j] = number;
                k++;
            }
        }
        return  pointsArray;
    }

    public void printing(Point[][] arr){
        int i,j;
        for (i =0; i<9; i++){
            for (j=0; j<9; j++){
                System.out.print(arr[i][j].getValue()+" ");
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
}
