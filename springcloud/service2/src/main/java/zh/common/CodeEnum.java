package zh.common;


public enum CodeEnum {
    SUCCESS(200),
    FAIL(500);

    private int code;

    CodeEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
