package calculator;

import java.util.ArrayList;

public class Calculator {
    // 속성
    private int result;
    private ArrayList<String> arraylist = new ArrayList<>();
    
    // 생성자
    
    // 기능
    public void calculate(int num1, int num2, char operation) {
        switch(operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                try{
                    result = num1 / num2;
                } catch(RuntimeException e) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                }
                break;
            default:
                System.out.println("지원하지 않는 연산 기능입니다.");
        }
        arraylist.add(num1 + " " + operation + " " + num2 + " = " + result);
    }

    public int getResult() {    // 계산 결과
        return result;
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
        arraylist.remove(0);
    }
    
    
    


}