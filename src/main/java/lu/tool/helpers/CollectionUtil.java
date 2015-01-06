package lu.tool.helpers;

import org.apache.commons.beanutils.PropertyUtils;

import java.util.*;

/**
 * Created by xiaozi on 1/6/15.
 */
public class CollectionUtil {
    @SuppressWarnings("unchecked")
    public static <T>Collection<T> pluck(Collection<?> c, String propName, Collection<T> result) {
        if (c == null) {
            return result;
        }
        try {
            for (Iterator<?> it = c.iterator(); it.hasNext();) {
                Object element = it.next();
                T value = (T) PropertyUtils.getProperty(element, propName);
                result.add(value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @SuppressWarnings("unchecked")
    public static <K, T>Map <K, List<T>> groupBy(List<T> c, String propName, Class<K> clazz) throws Exception {
        if (c == null) {
            return new LinkedHashMap<K, List<T>>();
        }
        try {
            Map<K, List<T>> grouped = new LinkedHashMap<K, List<T>>();
            for (Iterator<T> it = c.iterator(); it.hasNext(); ) {
                T element = it.next();
                K key = (K) PropertyUtils.getProperty(element, propName);
                List<T> l = grouped.get(key);
                if (l == null) {
                    l = new ArrayList<T>();
                    grouped.put(key, l);
                }
                l.add(element);
            }
            return grouped;
        } catch (Exception e) {
            throw new Exception("Error while getting the object property.", e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> Collection<T> unique(Collection<T> c, Collection<T> result) {
        if (c == null) {
            return result;
        }
        Set<T> s = new LinkedHashSet<T>(c);
        result.addAll(s);
        return result;
    }
}
