package task_02;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Getter
@Setter
public class Buyer {
    String fullName;
    LocalDate birthDate;
    String phone;

    public Buyer(String fullName, LocalDate birthDate, String phone) {
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.phone = phone;
    }

    // метод для вычисления возраста сотрудника
    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Покупатель:\n" +
                "ФИО - " + fullName +
                ", возраст - " + getAge() +
                ", телефон - " + phone;
    }
}
