package calculator;

import java.util.ArrayList;

public class Calculator {
    private int result;
    private ArrayList<String> arraylist = new ArrayList<>();


    // 생성자

    // 기능
    public int calculate(int num1, int num2, OperatorType operation){
        try {
            result = operation.apply(num1, num2);
            arraylist.add((arraylist.size()+1) + ". " + num1 + " " + operation.getOperator() + " " + num2 + " = " + result);
            return result;
        } catch (ArithmeticException e) {
            arraylist.add((arraylist.size()+1) + ". " + num1 + " " + operation.getOperator() + " " + num2 + " = " + "계산 불가");
            throw e;
        }
    }

    public void getArrayList() {   // 계산 결과 전체 조회
        for(String list : arraylist) {
            System.out.println(list);
        }
    }

    public void getSingleArrayList(int index) { // 계산 결과 리스트 단일 조회
        System.out.println(arraylist.get(index));
    }

    public void setArrayList(int index, String element) {   // 계산 결과 수정
        this.arraylist.set(index, element);
    }

    public void removeArrayList() { // 가장 먼저 저장된 계산 결과 삭제
        if(arraylist.size() == 0) {
            throw new IllegalArgumentException("리스트가 비어 있어 삭제할 수 없습니다.");
        } else {
            arraylist.remove(0);
            for(String list : arraylist) {

            }
        }
    }
    public int listSize() {
        return arraylist.size();
    }

}
