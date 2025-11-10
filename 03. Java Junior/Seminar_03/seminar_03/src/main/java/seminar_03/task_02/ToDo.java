package seminar_03.task_02;

import lombok.Getter;
import lombok.Setter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

@Getter
@Setter
public class ToDo implements Externalizable {

// region Поля
    /**
     * Наименование задачи
     */
    private String title;

    /**
     * Статус задачи
     */
    private boolean isDone;
    // endregion


    public ToDo() {
    }

    public ToDo(String title) {
        this.title = title;
        isDone = false;
    }

    //region Externalizable implementation

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(title);
        out.writeBoolean(isDone);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = (String) in.readObject();
        isDone = in.readBoolean();
    }
    //endregion


    // region Методы

    /**
     * Получить статус выполнения задачи
     *
     * @return статус выполнения задачи
     */
    public boolean isDone() {
        return isDone;
    }


    // endregion

}
