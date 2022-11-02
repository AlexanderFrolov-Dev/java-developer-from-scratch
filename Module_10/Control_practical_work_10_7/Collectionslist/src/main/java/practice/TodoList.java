package practice;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> list = new ArrayList<>();

    public void add(String todo) {
        list.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if (index >= 0 && index < list.size()) {
            list.add(index, todo);
            System.out.println("Добавлено дело \"" + todo + "\"");
        } else {
            add(todo);
        }
    }

    public void edit(int index, String todo) {
        if (index >= 0 && index < list.size()) {
            System.out.println("Дело \"" + list.set(index, todo) + "\" заменено на \"" + todo + "\"");
        }
    }

    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            String caseBeingDeleted = list.get(index);
            list.remove(index);
            System.out.println("Дело \"" + caseBeingDeleted + "\" удалено");
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(String.valueOf(i).concat(" - ").concat(list.get(i)));
        }
        return list;
    }

}