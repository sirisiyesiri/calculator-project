package calculator;

import java.util.ArrayList;

public class HistoryList {
    private ArrayList<CalculatorResult> arraylist = new ArrayList<>();

    public void getArrayList() {// 계산 결과 전체 조회
        int i = 1;
        for(CalculatorResult list : arraylist) {
            // CalculatorResult list는 새로운 객체를 생성한 것이 아닌 arraylist에 있는 CalculatorResult객체들을 list라는 변수에 담을 것이다라는 뜻
            // 즉 새로운 객체를 생성하는 것이 아니기 때문에 생성자 형태를 지키지 않아도 오류X
            System.out.println(i++ + ". " + list.getStrResult());
        }
    }

    public void getSingleArrayList(int index) { // 계산 결과 리스트 단일 조회
        System.out.println(arraylist.get(index).getStrResult());
    }

    public void setArrayList(int index, String strElement) {// 계산 결과 수정
        String[] parts = strElement.split("="); // '=' 기호 기준으로 문자열 쪼개기

        // trim()은 문자열 앞 뒤의 공백을 없애기 함수
        String resultStr = parts[1].trim();

        Number resultElement;
        boolean tf = true;

        if(resultStr.equals("계산 불가")) {
            resultElement = null;
            tf = false;
        } else {
            if(resultStr.contains(".")) {
                resultElement = Double.parseDouble(resultStr);
            } else {
                resultElement = Integer.parseInt(resultStr);
            }
        }

        CalculatorResult correctionlist = new CalculatorResult(strElement, resultElement, tf);


        this.arraylist.set(index, correctionlist);
    }

    public void removeArrayList() { // 가장 먼저 저장된 계산 결과 삭제
        if(arraylist.size() == 0) {
            throw new IllegalArgumentException("리스트가 비어 있어 삭제할 수 없습니다.");
        } else {
            arraylist.remove(0);
        }
    }
    public int listSize() {
        return arraylist.size();
    }

    public void addList(String list, Number result, boolean fail) {
        CalculatorResult addlist = new CalculatorResult(list, result, fail);
        arraylist.add(addlist);
    }

    public void biggerThenInput(Number input) {
        arraylist.stream()
                .filter(res -> res.getResult() != null && res.getResult().doubleValue() > input.doubleValue())
                .forEach(res -> System.out.println(res.getResult()));   // 바로바로 출력
        // forEach : 모든 요소에 대하여 실행하라. (= for 반복문)
        // res : 리스트에서 방금 막 꺼낸 객체 하나
        // 즉, filter를 통해 걸러 막 꺼낸 객체들 하나하나에 대하여 return받은 결과값을 출력해라
    }
}
