package seminar_03.task_01;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserData implements Serializable {
    private String name;
    private int age;
    transient String password;

    public UserData(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }
}
