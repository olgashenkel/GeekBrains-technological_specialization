package ru.gb.demo_spring_boot;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Component ("myUserRepositoryBean")
@Component
@Primary

//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@Scope("singleton") // "prototype"
/*
@Scope("singleton") в Java (с использованием Spring) означает,
что для данного класса будет создан только один экземпляр бина на весь контейнер
Spring ApplicationContext. Этот единственный экземпляр будет повторно использоваться
при каждом запросе, а не создаваться новый, как в случае с другими областями видимости,
например prototype.

Назначение: Гарантирует существование всего одного общего экземпляра бина для всего приложения.

Применение: Используется для бинов, которые не сохраняют состояние или для которых
важен один общий экземпляр, что повышает эффективность использования ресурсов.

Использование: Это область видимости по умолчанию, поэтому часто аннотацию @Scope("singleton")
можно опустить, просто используя @Component, @Service или @Repository.

Поведение: Если вы запросите этот бин несколько раз, Spring вернет один и тот же объект,
что обеспечивает глобальную точку доступа к этому экземпляру.
 */
public class UserRepository {

    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Igor"));
        users.add(new User("User # 2"));
        users.add(new User("User # 3"));
        users.add(new User("User # 4"));
        users.add(new User("User # 5"));
    }

    public List<User> getAllCopy() {
        return List.copyOf(users);
    }

    public List<User> getAllOriginal() {
        return users;
    }

    public User getByName(String name){
        return users.stream()
                .filter(it -> Objects.equals(it.getName(), name))     // измененный код
                .findFirst()
                .orElse(null);
    }


    public User getById(long id) {
        return users.stream()
//                .filter(it -> Objects.equals(it.getId()), id)   // код из лекции
                .filter(it -> it.getId() == id)     // измененный код
                .findFirst()
                .orElse(null);
    }

    public User deleteById(long id) {
        return users.remove((int) id);
    }

}
