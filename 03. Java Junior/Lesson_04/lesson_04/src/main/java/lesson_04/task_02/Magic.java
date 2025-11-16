package lesson_04.task_02;

import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "test.magic")
@Setter

public class Magic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "название")
    private String name;

    @Column(name = "повреждение")
    private int damage;

    @Column(name = "атака")
    private int attBonus;

    @Column(name = "броня")
    private int attArmor;


    public Magic(String name, int damage, int attBonus, int attArmor) {
        this.name = name;
        this.damage = damage;
        this.attBonus = attBonus;
        this.attArmor = attArmor;
    }

    public Magic() {
    }

    @Override
    public String toString() {
        return "Magic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", attBonus=" + attBonus +
                ", attArmor=" + attArmor +
                '}';
    }
}
