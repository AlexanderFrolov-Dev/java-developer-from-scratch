// SwimmingPool

public class Main {
    public static void main(String[] args) {
        int volume = 1200;
        int fillingSpeed = 30; //30 litres per minute
        int devastationSpeed = 10; //10 litres per minute
        int actualFillingSpeed = fillingSpeed - devastationSpeed;
        int currentVolume = 0;
        int minuteCounter = 0;

        // Мой вариант
//        while (currentVolume != volume) {
//            currentVolume += actualFillingSpeed;
//            minuteCounter++;
//        }

        // По заданию
        while (true) {
            currentVolume += fillingSpeed - devastationSpeed;
            minuteCounter++;

            if (currentVolume == volume) {
                break;
            }
        }

        System.out.println("Бассейн полностью наполнится водой за " + minuteCounter + " минут.");
    }
}