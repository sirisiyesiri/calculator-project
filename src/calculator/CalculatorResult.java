package calculator;

public class CalculatorResult {
    private String strResult;
    private Number result;

    public CalculatorResult(String strResult, Number result) {
        this.strResult = strResult;
        this.result = result;
    }

    public String getStrResult() {
        return strResult;
    }

    public Number getResult() {
        return result;
    }

    public void setStrResult(String strResult) {
        this.strResult = strResult;
    }

    public void setResult(Number result) {
        this.result = result;
    }
}
