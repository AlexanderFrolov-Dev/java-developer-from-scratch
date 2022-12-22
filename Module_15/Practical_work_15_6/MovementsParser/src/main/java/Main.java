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
    public static final int INDEX_OPERATION_DESCRIPTION = 5;
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

        System.out.println(rows.size());
        System.out.println(rowsWithoutTitles.size());
        System.out.println(getOperationDescription(rows.get(4)));
        for (String s : uniqueOperationDescriptions) {
            System.out.println(s);
        }
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

    private static Map<String, Integer> getSumReceiptAndSpendingMoneyByTypes() {
        return null;
    }
}
