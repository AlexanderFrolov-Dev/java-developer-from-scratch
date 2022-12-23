import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static List<String> rows;
    static List<String> rowsWithoutTitles;
    static Set<String> uniqueOperationDescriptions;
    static int columnsCount;
    public static final int INDEX_OPERATION_DESCRIPTION_COLUMN = 5;
    public static final int INDEX_RECEIPT_OF_MONEY_COLUMN = 6;
    public static final int INDEX_SPENDING_MONEY_COLUMN = 7;
    public static final int VALID_COLUMNS_COUNT = 8;
    static Pattern operationDescription = Pattern.compile("([\\\\/])(((\\w+>?\\w*)+(\\s+))+)((\\d{2}\\.){2}\\d{2})");

    public static void main(String[] args) {

        try {
            rows = Files.readAllLines(Path.of("src/main/resources/movementList.csv"), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        if (isValidColumnsCount(rows)) {
            columnsCount = getTitles(rows).size();
            rowsWithoutTitles = rows.subList(1, rows.size());
            uniqueOperationDescriptions = getUniqueOperationDescription(rows);

            System.out.println("Сумма по операциям " + getTitles(rows).get(INDEX_RECEIPT_OF_MONEY_COLUMN) + "а по типам:");
            for (Map.Entry<String, Double> entry : getSumOfTransactionsByTypes(rowsWithoutTitles, INDEX_RECEIPT_OF_MONEY_COLUMN).entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("--------------");
            System.out.println("Общая сумма по операциям " + getTitles(rows).get(INDEX_RECEIPT_OF_MONEY_COLUMN) + "а: "
                    + getTotalSumOfTransactionsByTypes(rowsWithoutTitles, INDEX_RECEIPT_OF_MONEY_COLUMN));

            System.out.println("===============");

            System.out.println("Сумма по операциям " + getTitles(rows).get(INDEX_SPENDING_MONEY_COLUMN) + "а по типам:");
            for (Map.Entry<String, Double> entry : getSumOfTransactionsByTypes(rowsWithoutTitles, INDEX_SPENDING_MONEY_COLUMN).entrySet()) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
            System.out.println("--------------");
            System.out.println("Общая сумма по операциям " + getTitles(rows).get(INDEX_SPENDING_MONEY_COLUMN) + "а: "
                    + getTotalSumOfTransactionsByTypes(rowsWithoutTitles, INDEX_SPENDING_MONEY_COLUMN));
        }

    }

    private static List<String> getTitles(List<String> rows) {
        return Arrays.asList(rows.get(0).split(","));
    }

    private static String getOperationDescription(String row) {
        Matcher matcher = operationDescription.matcher(row);

        if (matcher.find()) {
            return matcher.group(2).trim();
        } else {
            return "";
        }
    }

    private static Set<String> getUniqueOperationDescription(List<String> stringList) {
        Set<String> uniqueOperationDescription = new TreeSet<>();

        for (String s : stringList) {
            uniqueOperationDescription.add(getOperationDescription(s));
        }

        return uniqueOperationDescription;
    }

    private static Map<String, Double> getSumOfTransactionsByTypes(List<String> rows, int indexOfOperationColumn) {
        Map<String, Double> sumOfTransactionsByTypes = new TreeMap<>();

        for (String s : rows) {
            List<String> valuesOfCurrentRow = Arrays.asList(s.split(","));
            Matcher matcher = operationDescription.matcher(valuesOfCurrentRow.get(INDEX_OPERATION_DESCRIPTION_COLUMN));
            String currentTypeOfOperation = getOperationDescription(valuesOfCurrentRow.get(INDEX_OPERATION_DESCRIPTION_COLUMN));

            if (matcher.find() && isDoubleType(valuesOfCurrentRow.get(indexOfOperationColumn))) {
                sumOfTransactionsByTypes
                        .put(currentTypeOfOperation, sumOfTransactionsByTypes.containsKey(currentTypeOfOperation)
                                ? sumOfTransactionsByTypes.get(currentTypeOfOperation) + Double.parseDouble(valuesOfCurrentRow.get(indexOfOperationColumn))
                                : Double.parseDouble(valuesOfCurrentRow.get(indexOfOperationColumn)));
            }

        }

        return sumOfTransactionsByTypes;
    }

    private static double getTotalSumOfTransactionsByTypes(List<String> rows, int indexOfOperationColumn) {
        double totalSum = 0;

        for (String s : rows) {
            String[] currentRow = s.split(",");
            if (isDoubleType(currentRow[indexOfOperationColumn])) {
                totalSum += Double.parseDouble(currentRow[indexOfOperationColumn]);
            }
        }

        return totalSum;
    }

    private static boolean isValidColumnsCount(List<String> rows) {
        boolean validRow = true;

        for (String s : rows) {
            if (s.split(",").length != Main.VALID_COLUMNS_COUNT) {
                validRow = false;
                break;
            }
        }

        return validRow;
    }

    private static boolean isDoubleType(String value) {
        try {
            Double.parseDouble(value);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
