package stateMachine.Controller;

public class Father {

    String code;

    String Message;

    public Father() {
    }

    public Father(String code, String message) {
        this.code = code;
        Message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }
}
