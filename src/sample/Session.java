package sample;

import java.util.HashMap;
import java.util.Map;

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

    public void add(String key, Integer value) {
        try {
            data.put(key, value);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public int get(String key) {
        try {
            return data.get(key);
        } catch (Exception e) {
            System.err.println(e);
        }
        return 0;
    }


}
