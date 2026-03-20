package calculator;

import java.util.ArrayList;

public class Calculator {
    // 속성
    private int result;
    private ArrayList<String> arraylist = new ArrayList<>();

    
    // 생성자
    
    // 기능
    public int calculate(int num1, int num2, char operation) throws ArithmeticException{
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
                if(num2 == 0) {
                    arraylist.add((arraylist.size()+1) + ". " + num1 + " " + operation + " " + num2 + " = 계산 불가");
                    throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    // 처음엔 exception이 나지 않기 위해서 여기서 try-catch를 하고, result = 0;을 return하게 코드를 짰었음
                    // 근데 그러니까 main에서 계산 불가임에도 불구하고, '계산 결과 : 0'으로 출력되며, 원하는 출력이 나오지 않게 됨
                    // 튜터님께 여쭤보니 차라리 exception을 발생시키고 throws를 이용해서 main에서 exception을 처리하라는 답을 주심
                }
                result = num1 / num2;
                break;
            default:
                System.out.println("지원하지 않는 연산 기능입니다.");
                arraylist.add((arraylist.size()+1) + ". 지원하지 않는 연산");
                return result = 0;
        }
        arraylist.add((arraylist.size()+1) + ". " + num1 + " " + operation + " " + num2 + " = " + result);
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
    public int listSize() {
        return arraylist.size();
    }
}