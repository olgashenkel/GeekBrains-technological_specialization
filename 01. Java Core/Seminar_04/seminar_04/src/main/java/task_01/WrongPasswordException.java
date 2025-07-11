package task_01;

public class WrongPasswordException extends RuntimeException{
    private int passwordLength;

    public WrongPasswordException(int passwordLength) {
        super();
        this.passwordLength = passwordLength;
    }

    @Override
    public String getMessage() {
        return String.format("Длина пароля должна составлять не менее 20 символов. " +
                "Длина введенного пароля - %d", passwordLength);
    }
}
