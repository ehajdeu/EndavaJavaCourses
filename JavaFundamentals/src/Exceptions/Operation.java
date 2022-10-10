package Exceptions;

public enum Operation {
    AMOUNT("Amount"),
    THRESHOLD("Threshold");

    private final String code;

    public String getCode() {
        return code;
    }

    Operation(String amoount) {
        this.code = amoount;
    }
}
