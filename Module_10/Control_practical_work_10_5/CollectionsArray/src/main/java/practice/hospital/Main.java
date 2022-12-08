package practice.hospital;

public class Main {
    public static void main(String[] args) {
        float[] temperatureData = Hospital.generatePatientsTemperatures(30);
        System.out.println(Hospital.getReport(temperatureData));
    }
}
