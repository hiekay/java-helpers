package lu.tool.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by xiaozi on 1/6/15.
 */
public class Launcher {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<Person>();
        for (int i = 10; i > 0; i--) {
            Person person = new Person();
            person.setName("hehe" + i % 3);
            person.setAge(i);
            persons.add(person);
        }
        List<Integer> ages = (List<Integer>) CollectionUtil.pluck(persons, "age", new ArrayList<Integer>());
        System.out.println(ages);
        try {
            Map<String, List<Person>> groupedPersons = CollectionUtil.groupBy(persons, "name", String.class);
            System.out.println(groupedPersons);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<String> ids = Arrays.asList("ni", "ni", "mei", "mei");
        List<String> uniquedIds = (List<String>) CollectionUtil.unique(ids, new ArrayList<String>());
        System.out.println(uniquedIds);

        String a1 = "a";
        String a2 = "a";
        System.out.println(a1 == a2);
    }
}
