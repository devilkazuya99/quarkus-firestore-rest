package org.acme.rest.json;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class Store {

    public String name;
    public ZonedDateTime createTime;
    public ZonedDateTime updateTime;
    public Map<String, Object> fields = new HashMap<String, Object>();
    
    public Store() {}

    public Store(Integer born, String first, String last) {
//        this.name = name;
        this.fields.put("born", new IntegerValue(born));
        this.fields.put("first", new StringValue(first));
        this.fields.put("last", new StringValue(last));
    }
 
    public static class StringValue {
        public String stringValue;
        public StringValue(String stringValue) {
            this.stringValue = stringValue;
        }
    }
    
    public static class IntegerValue {
        public Integer integerValue;
        public IntegerValue(Integer integerValue) {
            this.integerValue = integerValue;
        }
    }
}
