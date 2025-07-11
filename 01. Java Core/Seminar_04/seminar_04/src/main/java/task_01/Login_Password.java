package task_01;

public class Login_Password {

    public static boolean dataVerification(String login, String password, String confirmPassword) {
        try {
            if (login.length() >= 20) {
                throw new WrongLoginException(login.length());
            } else if (password.length() < 20) {
                throw new WrongPasswordException(password.length());
            } else if (!password.equals(confirmPassword)) {
                System.out.println("\nПароли не совпадают!");
                return false;
            }
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
    }
}
