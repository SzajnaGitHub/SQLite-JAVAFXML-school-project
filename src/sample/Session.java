package sample;

import java.util.HashMap;
import java.util.Map;

public class Session {

    public static Session CurrentSession = null;
    private Map<String, CData> data = new HashMap<>();

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

    public void add(String key, CData cdata) {
        try {
            data.put(key, cdata);
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    public String get(CData cdata){
        try {
            return data.get(cdata.getName());
        } catch (Exception e) {
            System.err.println(e);
        }
        return "";
    }


}
