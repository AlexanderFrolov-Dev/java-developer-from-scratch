package practice;

public class GeometryCalculator {

    // если значение radius меньше 0, метод должен вернуть -1
    public static double getCircleSquare(double radius) {
        double square = Math.PI * Math.pow(radius, 2);
        return radius >= 0 ? square : -1;
    }

    // если значение radius меньше 0, метод должен вернуть -1
    public static double getSphereVolume(double radius) {
        double volume = ((double) 4 / 3) * Math.PI * Math.pow(radius, 3);
        return radius >= 0 ? volume : -1;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        return (a + b) > c && (a + c) > b && (b + c) > a;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        double p = (a + b + c) / 2;
        double square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return isTrianglePossible(a, b, c) ? square : -1;
    }
}
