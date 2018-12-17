package sample;

import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to transport variables between classes.
 */
public class Session {

    public static Session CurrentSession = null;
    private Map<String, Integer> data = new HashMap<>();

    public Session() {
        try {
            if (CurrentSession == null) {
              //  throw new Exception("Session already initalize");
            }
            CurrentSession = this;
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static Session getCurrentSession() {
        try {
            if (CurrentSession == null) {
                throw new Exception("Session is null");
            }
            return CurrentSession;
        } catch (Exception e) {
            System.err.println(e);
        }
        return null;
    }

    /**
     * This method add data to HashMap
     * @param key
     * @param value
     */
     public void add(String key, Integer value) {
        try {
            data.put(key, value);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    /**
     * This method get value from Hashmap by passing key
     * @param key
     * @return key to HashMap current session
     */
    public int get(String key) {
        try {
            return data.get(key);
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }


}
