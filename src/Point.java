import java.util.ArrayList;
import java.util.List;

public class Point {

    private List<Integer> temp_numbers = new ArrayList<Integer>();
    private int value = 0;
    private int[][] position;

    public Point(List<Integer> temp_numbers, int value, int[][] position) {
        this.temp_numbers = temp_numbers;
        this.value = value;
        this.position = position;
    }

    public Point(int value, int [][] position) {
        this.value = value;
        this.position = position;
    }

    public List<Integer> getTemp_numbers() {
        return temp_numbers;
    }

    public void setTemp_numbers(List<Integer> temp_numbers) {
        this.temp_numbers = temp_numbers;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int[][] getPosition() {
        return position;
    }

    public void setPosition(int[][] position) {
        this.position = position;
    }
}
