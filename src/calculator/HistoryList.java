package calculator;

import java.util.ArrayList;

public class HistoryList {
    ArrayList<String> historyList = new ArrayList<>();
    ArrayList<Double> resultList = new ArrayList<>();
    // 비상 : 분모가 0인 나누기 계산의 경우, historyList는 "계산 불가"라고 결과를 저장하지만,
    // resultList의 경우 결과를 저장할 수 없음 => 두 list의 길이가 달라서 조회, 수정, 삭제 시 서로 다른 결과값을 취급할 수 있다는 문제가 발생함.

    public void getArrayList() {// 계산 결과 전체 조회
        int i = 1;
        for(String list : historyList) {
            System.out.println(i++ + ". " + list);
        }
    }

    public void getSingleArrayList(int index) { // 계산 결과 리스트 단일 조회
        System.out.println(historyList.get(index));
    }

    public void setArrayList(int index, String element) {   // 계산 결과 수정
        this.historyList.set(index, element);
    }

    public void removeArrayList() { // 가장 먼저 저장된 계산 결과 삭제
        if(historyList.size() == 0) {
            throw new IllegalArgumentException("리스트가 비어 있어 삭제할 수 없습니다.");
        } else {
            historyList.remove(0);
        }
    }
    public int listSize() {
        return historyList.size();
    }

    public void addList(String list) {
        historyList.add(list);
    }

    public void addResultList(double result) {
        resultList.add(result);
    }
}
