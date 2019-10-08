public class Point {

    private int value = 0;
    private int line =0;
    private int column = 0;

    public Point( int value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = line;
    }

    public Point() {
    }

    public boolean checkRow(Point num){

        return false;
    }

    public boolean checkColumn(Point num){
        return false;
    }

    public boolean checkCell(Point num){
        return false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


}
