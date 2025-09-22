
# Урок 2. Программные интерфейсы


### План урока:

- Программные интерфейсы — понятие и принцип работы;
- Ключевое слово implements;
- Наследование и множественное наследование интерфейсов;
- Реализация, реализации по-умолчанию;
- Частичная реализация интерфейсов, адаптеры;
- Анонимные классы;
- Исключения в графических фреймворках.


## Практическое задание

### Задание 1 

Задача: Полностью разобраться с кодом.


### Задание 2   
[решение для приложения "Circkes"]()   
[решение для приложения "Bricks"]()

Задача: Для приложения с шариками описать появление и убирание шариков по клику мышки левой и правой кнопкой соответственно.

```
package lesson_02.circles.view;


    public void addSprite(int x, int y) {
        if (countSprites >= MAX_COUNT_SPRITES) {
            throw new BallsOverflowException();
        }
        interactable[countSprites++] = new Ball(x, y);
    }

    public void removeSprite(){
        if (countSprites <= 1){
            return;
        }
        countSprites--;
    }
```

```
package lesson_02.circles.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseListener extends MouseAdapter {
    private MianWindow mianWindow;

    public MouseListener(MianWindow mianWindow) {
        this.mianWindow = mianWindow;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            mianWindow.removeSprite();
        } else if (e.getButton() == MouseEvent.BUTTON3) {
            mianWindow.addSprite(e.getX(), e.getY());
        }
    }
}
```

### Задание 3   
[решение для приложения "Circkes"]()   
[решение для приложения "Bricks"]()

Задача: Написать, выбросить и обработать такое исключение, которое не позволит создавать более, чем 15 шариков.

```
public class BallsOverflowException extends RuntimeException{
    public BallsOverflowException(){
        JOptionPane.showMessageDialog(
                null, "Невозможно создать более 15 объектов",
                "Exception", JOptionPane.ERROR_MESSAGE
        );
    }
}
```

### Задание 4**
[решение для приложения "Images"]()

Задача: Описать ещё одно приложение, в котором на белом фоне будут перемещаться изображения формата png, лежащие в папке проекта.
