package calculator;

public class CalculatorResult {
    private String strResult;
    private Number result;
    private boolean fail;

    public CalculatorResult(String strResult, Number result, boolean fail) {
        this.strResult = strResult;
        this.result = result;
        this.fail = fail;
    }

    public String getStrResult() {
        return strResult;
    }

    public Number getResult() {
        return result;
    }

    public boolean isfail() {
        return fail;
    }

    public void setStrResult(String strResult) {
        this.strResult = strResult;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public void setFail(boolean fail) {
        this.fail = fail;
    }
}
