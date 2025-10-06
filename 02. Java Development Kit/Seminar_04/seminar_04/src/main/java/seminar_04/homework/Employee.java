package seminar_04.homework;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Employee {
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int startPositionForID = 0;

    @Setter(AccessLevel.NONE)
    private int personnelNumber;    // Табельный номер сотрудника
    private String phoneEmployee;           // Телефон
    private String nameEmployee;            // Имя
    private int experienceEmployee;         // Стаж (лет)

    public Employee(String phoneEmployee, String nameEmployee, int experienceEmployee) {
        this.personnelNumber = ++startPositionForID;
        this.phoneEmployee = phoneEmployee;
        this.nameEmployee = nameEmployee;
        this.experienceEmployee = experienceEmployee;
    }

    @Override
    public String toString() {
        return "Табельный номер: " + personnelNumber +
                "; Номер телефона: " + phoneEmployee +
                "; Имя: " + nameEmployee +
                "; Стаж (лет): " + experienceEmployee + "\n";

    }
}
