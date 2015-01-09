package lu.tool.helpers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created by xiaozi on 1/9/15.
 */
public class CollectionUtilsTest {
    private List<Person> persons;

    @Before
    public void init() {
        persons = new ArrayList<Person>(10);
        for (int i = 10; i > 0; i--) {
            Person person = new Person();
            person.setName("hehe" + i % 3);
            person.setAge(i * 5);
            person.setId(i);
            persons.add(person);
        }
    }

    @Test
    public void testPluckWithoutKey() {
        List<Integer> ids = (List<Integer>) CollectionUtils.pluck(persons, "id", new ArrayList<Integer>());
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Assert.assertTrue(expected.size() == ids.size());
    }

    @Test
    public void testPluckWithKey() throws Exception {
        Map<Integer, String> idNames = (Map<Integer, String>) CollectionUtils.pluck(persons, "id", "name", new HashMap<Integer, String>());
        Map<Integer, String> expected = new HashMap<Integer, String>();
        for (Person person: persons) {
            expected.put(person.getId(), person.getName());
        }
        Assert.assertTrue(expected.equals(idNames));
    }

    @Test
    public void testKeyBy() throws Exception {
        Map<Integer, Person> keyed  = CollectionUtils.keyBy(persons, "id", Integer.class);
        Map<Integer, Person> expected = new HashMap<Integer, Person>();
        for (Person person: persons) {
            expected.put(person.getId(), person);
        }
        Assert.assertTrue(expected.equals(keyed));
    }

    @Test
    public void testGroupBy() throws Exception {
        Map<String, List<Person>> grouped = CollectionUtils.groupBy(persons, "name", String.class);
        Map<String, List<Person>> expected = new HashMap<String, List<Person>>();
        for (Person person: persons) {
            String personName = person.getName();
            List<Person> l = expected.get(personName);
            if (l == null) {
                l = new ArrayList<Person>();
                expected.put(personName, l);
            }
            l.add(person);
        }
        Assert.assertTrue(expected.equals(grouped));
    }

    @Test
    public void testUnique() {
        List<Integer> ids = Arrays.asList(1, 1, 2, 2, 2, 3);
        List<Integer> uniqued = (List<Integer>) CollectionUtils.unique(ids, new ArrayList<Integer>());
        List<Integer> expected = Arrays.asList(1, 2, 3);
        Assert.assertTrue(expected.size() == uniqued.size());
    }

}
