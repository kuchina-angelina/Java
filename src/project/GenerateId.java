package project;

import java.util.List;

public class GenerateId {
    public static int generateId(List ids) {
        if (!ids.isEmpty()) {
            return Planner.ids.remove(0); // из списка ids возвращается 0 элемент и удаляется
            //затем этот 0 - ой элемент становится номером задачи
        }
        return 0;
    }
}
