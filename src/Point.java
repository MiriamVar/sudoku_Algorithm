import java.util.ArrayList;

public class Point {

    private int value = 0;
    private int line =0;
    private int column = 0;
    private ArrayList<Integer> options= new ArrayList<>();

    public Point( int value, int line, int column) {
        this.value = value;
        this.line = line;
        this.column = line;
    }

    public Point() {
    }

    public Point(int value, int line, int column, ArrayList<Integer> options) {
        this.value = value;
        this.line = line;
        this.column = column;
        this.options = options;
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

    public ArrayList<Integer> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Integer> options) {
        this.options = options;
    }
}
