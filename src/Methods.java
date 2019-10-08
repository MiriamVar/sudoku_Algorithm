import java.util.ArrayList;

public class Methods {

    public boolean checkRow(Point num, Point[][] arr){
        ArrayList<Integer> list = new ArrayList<>();
        if(num.getValue() ==0){
            int line = num.getLine();
            for (int i=0;i<9;i++){
                int numInLine = arr[line][i].getLine();
                if(i==numInLine){
                    System.out.println("Nachadza sa v riakdu");
                    return false;
                }else{
                    list.add(numInLine);
                }
            }
            num.setOptions(list);
            return true;
        }
        return false;
    }

    public boolean checkColumn(Point num, Point[][]arr){
        ArrayList<Integer> list = new ArrayList<>();
        if(num.getValue() ==0){
            int col = num.getColumn();
            for (int i=0;i<9;i++){
                int numInCol = arr[col][i].getColumn();
                if(i==numInCol){
                    System.out.println("Nachadza sa v stlpci");
                    return false;
                }else{
                    list.add(numInCol);
                }
            }
            num.setOptions(list);
            return true;
        }
        return false;
    }

    public boolean checkCell(Point num, Point[][] arr){
        ArrayList<Integer> list = new ArrayList<>();
        if(num.getValue()==0){
            int line = num.getLine();
            int col = num.getColumn();
            int lineX = (line%3)*3;
            int colX= (col%3)*3;
            int counter = 1;

            for (int i=lineX; i<lineX+3; i++){
                for (int j=colX; j<colX+3;j++){
                    int tempNum = arr[i][j].getValue();
                    if (tempNum == counter){
                        System.out.println("nachadza sa v bunke");
                        return false;
                    }else{
                        list.add(counter);
                        counter++;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public Point[][] creatingGameboardOfPoints(String sudoku, int [][] arr, Point [][] pointsArray){
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

    public boolean checkingPoints(Point[][] arr) {
        int i, j;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                Point tempPoint = new Point(arr[i][j].getValue(), arr[i][j].getLine(), arr[i][j].getColumn(), arr[i][j].getOptions());
                int value = tempPoint.getValue();
                ArrayList options = tempPoint.getOptions();
                if (value == 0) {
                    boolean result = checkRow(tempPoint, arr);
                    //checuje riadok
                    if (result) {
                        if(options.size() ==1){
                            tempPoint.setValue(value); // ak sedi iba jedna moznost
                        } else {
                            result = checkColumn(tempPoint, arr);
                            //checkujem stlpec

                            if (result) {
                                if (options.size() == 1) {
                                    tempPoint.setValue(value); // ak sedi iba jedna moznost
                                } else {
                                    result = checkCell(tempPoint, arr);
                                    //checkujem bunku

                                    if (result) {
                                        if(options.size() == 1) {
                                            tempPoint.setValue(value); // ak sedi vsade zmenim hodnoto
                                        }
                                    }
                                }
                            }

                        }
                    }
                }
            }
        }
        return false;
    }
}
