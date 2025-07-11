package task_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // создание массива данных с вводом данных от пользователя
        String[] login_password = new String[3];
        System.out.print("Введите логин (не более 20 символов): ");
        login_password[0] = scanner.nextLine();
        System.out.print("Введите пароль (не менее 20 символов): ");
        login_password[1] = scanner.nextLine();
        System.out.print("Повторите пароль: ");
        login_password[2] = scanner.nextLine();

        System.out.println(Login_Password.dataVerification(login_password[0], login_password[1], login_password[2]));
    }
}
