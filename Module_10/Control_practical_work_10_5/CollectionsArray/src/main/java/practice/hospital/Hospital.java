package practice.hospital;

public class Hospital {
    public static final float MIN_TEMPERATURE = 32.0f;
    public static final float MAX_TEMPERATURE = 40.0f;
    public static final float INTERVAL_TEMPERATURE = MAX_TEMPERATURE - MIN_TEMPERATURE;
    public static final float MIN_NORMAL_TEMPERATURE = 36.2f;
    public static final float MAX_NORMAL_TEMPERATURE = 36.9f;

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] patientsTemperatures = new float[patientsCount];

        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = Math.round((MIN_TEMPERATURE + INTERVAL_TEMPERATURE * Math.random()) * 10.0f) / 10.0f;
        }

        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {

        StringBuilder temperature = new StringBuilder();
        float sum = 0.0f;
        int numberOfHealthyPeople = 0;

        for (float temperatureDatum : temperatureData) {
            temperature.append(temperatureDatum).append(" ");
            sum += temperatureDatum;
            if (temperatureDatum >= MIN_NORMAL_TEMPERATURE && temperatureDatum <= MAX_NORMAL_TEMPERATURE) {
                numberOfHealthyPeople++;
            }
        }

        return "Температуры пациентов: " + temperature.toString().trim() +
        "\nСредняя температура: " + Math.round((sum / temperatureData.length) * 100.0f) / 100.0f +
        "\nКоличество здоровых: " + numberOfHealthyPeople;
    }
}
