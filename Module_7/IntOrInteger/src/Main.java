public class Main {
    public static void main(String[] args) {
        Container container = new Container();
        container.addCount(5672);
        System.out.println(container.getCount());

        // TODO: ниже напишите код для выполнения задания:
        //  С помощью цикла и преобразования чисел в символы найдите все коды
        //  букв русского алфавита — заглавных и строчных, в том числе буквы Ё.

        char uppercaseA = 'А';
        char ya = 'я';
        char yo = 'ё';
        char uppercaseYo = 'Ё';

        for (int i = 0; i <= yo; i++) {
            if ((i >= uppercaseA && i <= ya) || i == yo || i == uppercaseYo) {
                System.out.println(i + " - " + (char) i);
            }
        }
    }
}
