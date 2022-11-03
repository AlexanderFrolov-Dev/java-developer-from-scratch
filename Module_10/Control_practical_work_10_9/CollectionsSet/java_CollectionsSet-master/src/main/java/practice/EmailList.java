package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailList {

    private Set<String> set = new TreeSet<>();

    public void add(String email) {
        Pattern pattern = Pattern.compile("\\w+@\\w+\\.\\w+");
        Matcher matcher = pattern.matcher(email.toLowerCase());

        if (matcher.matches() && !set.contains(email.toLowerCase())) {
            set.add(email.toLowerCase());
        }
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
//        TreeSet<String> set = new TreeSet<>();
//        for (String s : list) {
//            set.add(s);
//        }
//
//        list.clear();
//
//        for (int i = 0; i < set.size(); i++) {
//            if (set.iterator().hasNext()) {
//                list.add(set.iterator().next());
//            }
//        }


        return new ArrayList<>(set);
    }

}
