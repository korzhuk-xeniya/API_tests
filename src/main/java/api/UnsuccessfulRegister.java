package api;

public class UnsuccessfulRegister {
    private String error;

    public UnsuccessfulRegister(String error) {
        this.error = error;
    }

    public UnsuccessfulRegister() {
    }

    public String getError() {
        return error;
    }
}
