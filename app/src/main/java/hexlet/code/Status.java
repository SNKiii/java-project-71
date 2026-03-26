package hexlet.code;

import lombok.Getter;
import lombok.Setter;

//Класс хранения данных при сравнении
@Getter
@Setter
public class Status {
    public static final String DELETED = "deleted";
    public static final String ADDED = "added";
    public static final String CHANGED = "changed";
    public static final String UNCHANGED = "unchanged";

    private String statusName;
    private Object oldValue;
    private Object newValue;
    private String key;

    Status(String statusNameNew, String keyNew, Object oldValueNew, Object newValueNew) {
        this.statusName = statusNameNew;
        this.key = keyNew;
        this.oldValue = oldValueNew;
        this.newValue = newValueNew;
    }

    Status(String statusNameNew, String keyNew, Object oldValueNew) {
        this.statusName = statusNameNew;
        this.key = keyNew;
        this.oldValue = oldValueNew;
    }
}
