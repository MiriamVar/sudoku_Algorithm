import java.util.ArrayList;

public class Methods {

    public boolean checkRow(Point num, Point[][] arr){
//        ArrayList<Integer> list = new ArrayList<>();
//        if(num.getValue() ==0){
//            int line = num.getLine();
//            System.out.println("Line "+line);
//            num.setValue(1);
//            int value = num.getValue();
//            System.out.println("hodnota na zaciatku "+ value);
//            for (int i=1;i<9;i++){
//                int numInLine = arr[line][i].getLine();
//                System.out.println("hodnota cisel v riadku "+numInLine);
//                if(value==numInLine){
//                    System.out.println("Nachadza sa v riakdu");
//                    return false;
//                }else{
//                    list.add(numInLine);
//                }
//                value++;
//                System.out.println("zvysenie value "+value);
//            }
//            num.setOptions(list);
//            return true;
//        }
//        return false;
        int line = num.getLine();
        int value = num.getValue();
        for (int i =0; i<9; i++){
            if (value == arr[line][i].getValue()){
                System.out.println("nachadza sa v riadku");
                return true;
            }
        }
        return false;

    }

    public boolean checkColumn(Point num, Point[][]arr){
//        ArrayList<Integer> list = new ArrayList<>();
//        if(num.getValue() ==0){
//            int col = num.getColumn();
//            num.setValue(1);
//            int value = num.getValue();
//            for (int i=0;i<9;i++){
//                int numInCol = arr[col][i].getColumn();
//                if(value==numInCol){
//                    System.out.println("Nachadza sa v stlpci");
//                    return false;
//                }else{
//                    list.add(numInCol);
//                }
//                value++;
//            }
//            num.setOptions(list);
//            return true;
//        }
//        return false;
        int col = num.getColumn();
        int value = num.getValue();
        for (int i =0; i<9; i++){
            if (value == arr[i][col].getValue()){
                System.out.println("nachadza sa v stlpci");
                return true;
            }
        }
        return false;
    }

    public boolean checkCell(Point num, Point[][] arr){
//        ArrayList<Integer> list = new ArrayList<>();
//        if(num.getValue()==0){
//            int line = num.getLine();
//            int col = num.getColumn();
//            num.setValue(1);
//            int value = num.getValue();
//            int lineX = (line%3)*3;
//            int colX= (col%3)*3;
//
//            for (int i=lineX; i<lineX+3; i++){
//                for (int j=colX; j<colX+3;j++){
//                    int tempNum = arr[i][j].getValue();
//                    if (tempNum == value){
//                        System.out.println("nachadza sa v bunke");
//                        return false;
//                    }else{
//                        list.add(value);
//                        value++;
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
        int line = num.getLine();
        int col = num.getColumn();
        int value = num.getValue();
        int lineX = (line%3)*3;
        int colX= (col%3)*3;

        for (int i=lineX; i<lineX+3; i++) {
            for (int j = colX; j < colX + 3; j++) {
                int tempNum = arr[i][j].getValue();
                if (tempNum == value) {
                    System.out.println("nachadza sa v bunke");
                    return true;
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
        int i, j,k;
        int val = 1;
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                Point tempPoint = new Point(arr[i][j].getValue(), arr[i][j].getLine(), arr[i][j].getColumn(), arr[i][j].getOptions());
                int value = tempPoint.getValue();
                if (value == 0) {
                    System.out.println("idem checkovat riadok");
                    boolean resultRow = checkRow(tempPoint, arr);
                    System.out.println("resultRow " + resultRow);

                    if(!resultRow){
                        System.out.println("idem checkovat stlpec");
                        boolean resultCol = checkColumn(tempPoint,arr);
                        System.out.println("resultCol "+resultCol);

                        if (!resultCol){
                            System.out.println("idem checkovat bunku");
                            boolean resultCell = checkCell(tempPoint,arr);
                            System.out.println("reslutCell "+resultCell);

                            if (!resultCell){
                                System.out.println("idem menit hodnotu");
                                tempPoint.setValue(val);
                                return true;
                            }
                        }
                    }
                    val++;
                }
            }
        }
        return false;
    }
}
