package calculator;

import java.util.ArrayList;

public class Calculator <T extends Number>{
    private Number result;
    private String list;
    HistoryList resultList = new HistoryList();


    // 생성자
    public Calculator(HistoryList resultList) {
        this.resultList = resultList;
    }

    // 기능
    public <T extends Number, S extends Number> Number calculate(T num1, S num2, OperatorType operation){
        // RuntimeException의 경우 예외 전파가 되기 때문에 throws를 굳이 안 써도 됨.
        // CheckedException의 경우 컴파일러가 예외를 잡기 때문에 예외 전파 자체가 되지 않아서 throws를 써야함.
        try {
            if(num1 instanceof Double || num2 instanceof Double) {
                result = operation.applyDouble(num1.doubleValue(), num2.doubleValue());
            } else {
                result = operation.applyInt(num1.intValue(), num2.intValue());
            }
            list = (num1 + " " + operation.getOperator() + " " + num2 + " = " + result);
            resultList.addList(list, result);
            return result;
        } catch (ArithmeticException e) {
            // Calculator 클래스에 존재하는 arraylist에 계산 결과를 저장하기 위해 catch를 진행함.
            list = (num1 + " " + operation.getOperator() + " " + num2 + " = " + "계산 불가");
            resultList.addList(list, null);
            throw e;    // 계산 결과만 저장하고, 예외는 main에서 잡을 거라서 throw함.
        }
    }
}
