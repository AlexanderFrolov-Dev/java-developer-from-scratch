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
    static Pattern operationDescription = Pattern.compile("([\\\\/])(((\\w+>?\\w*)+(\\s+))+)((\\d{2}\\.){2}\\d{2})");

    public static void main(String[] args) {

        try {
            rows = Files.readAllLines(Path.of("src/main/resources/movementList.csv"), StandardCharsets.UTF_8);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        columnsCount = getTitles(rows.get(0)).size();
        rowsWithoutTitles = rows.subList(1, rows.size());
        uniqueOperationDescriptions = getUniqueOperationDescription(rows);

        for (Map.Entry<String, Double> entry : getSumOfTransactionsByTypes(rowsWithoutTitles, INDEX_RECEIPT_OF_MONEY_COLUMN).entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }

//        System.out.println(rows.size());
//        System.out.println(rowsWithoutTitles.size());
//        System.out.println(getOperationDescription(rows.get(4)));
//        for (String s : uniqueOperationDescriptions) {
//            System.out.println(s);
//        }

    }

    private static List<String> getTitles(String firstRow) {
        return Arrays.asList(firstRow.split(","));
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

            if (matcher.find()) {
                sumOfTransactionsByTypes
                        .put(currentTypeOfOperation, sumOfTransactionsByTypes.containsKey(currentTypeOfOperation)
                                ? sumOfTransactionsByTypes.get(currentTypeOfOperation) + Double.parseDouble(valuesOfCurrentRow.get(indexOfOperationColumn))
                                : Double.parseDouble(valuesOfCurrentRow.get(indexOfOperationColumn)));

            }

//            if (matcher.find()) {
//                sumOfTransactionsByTypes
//                        .put(currentTypeOfOperation, () -> {
//                            if (sumOfTransactionsByTypes.containsKey(currentTypeOfOperation)) {
//                                return sumOfTransactionsByTypes.get(currentTypeOfOperation) + Double.parseDouble(valuesOfCurrentRow.get(indexOfOperationColumn));
//                            } else {
//                                return Double.parseDouble(valuesOfCurrentRow.get(indexOfOperationColumn));
//                            }
//
//                        });
//
//            }
//.get(currentTypeOfOperation)

        }

        return sumOfTransactionsByTypes;
    }

}
