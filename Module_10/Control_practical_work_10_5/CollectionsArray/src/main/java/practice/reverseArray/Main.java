package practice.reverseArray;

public class Main {
    public static void main(String[] args) {
        String line = "Каждый охотник желает знать, где сидит фазан";
        for (String s : ReverseArray.reverse(line.split(" "))) {
            System.out.println(s);
        }
    }
}
