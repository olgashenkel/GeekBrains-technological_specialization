package task_01;

public class WrongLoginException extends RuntimeException{
    private int loginLength;

    public WrongLoginException(int loginLength) {
        super();
        this.loginLength = loginLength;
    }

    @Override
    public String getMessage() {
        return String.format("Длина логина не должна превышать 20 символов. " +
                "Длина введенного логина - %d", loginLength);
    }
}
