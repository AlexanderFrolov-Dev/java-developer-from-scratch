package practice.hospital;

public class Main {
    public static void main(String[] args) {

        // используя данный метод, вы можете использовать ваши методы, и проверить их работу на разных
        // значений для проверки и отладки

        float[] temperatureData = Hospital.generatePatientsTemperatures(30);
        System.out.println(Hospital.getReport(temperatureData));

        //Пример вывода в консоль:
        //Температуры пациентов: 36.7 38.9 34.7
        //Средняя температура: 36.76
        //Количество здоровых: 1


    }
}
