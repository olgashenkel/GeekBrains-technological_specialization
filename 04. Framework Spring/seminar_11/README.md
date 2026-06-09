### 1. **Перед запуском убедитесь**
- Убедитесь, что Docker установлен и запущен.
- Проверьте, что Docker работает корректно через Docker Desktop.

---

### 2. **Запуск приложения**
1. Перейдите в папку проекта.
2. Найдите файл `MonitoringApplication.java` в папке `src/main/java/com/example/monitoring`.
3. Запустите приложение, дважды щелкнув по файлу и выбрав `Run` в вашей IDE (например, IntelliJ IDEA).

---

### 3. **Проверка работы**

1. Откройте браузер и проверьте доступность метрик:
   ```text
   http://localhost:8080/actuator/prometheus
   ```

2. Перейдите в интерфейс Prometheus:
   ```text
   http://localhost:9090
   ```

3. Перейдите в интерфейс Grafana:
   ```text
   http://localhost:3000
   ```
    - Логин: `admin`
    - Пароль: `admin`

4. Настройте источник данных в Grafana:
    - URL: `http://prometheus:9090`.
    - Импортируйте дашборд с ID `4701` для отображения метрик Spring Boot.
