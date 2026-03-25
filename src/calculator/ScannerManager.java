package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerManager{
    Scanner scanner = new Scanner(System.in);

    public Number inputNumber() {
        while(true) {
            try {
                // trim() : 문자열 앞 뒤의 공백을 지워주는 함수
                String number = scanner.nextLine().trim();
//                Number num1 = number.contains(".")? Double.parseDouble(number) : Integer.parseInt(number);
                // scanner 비우기를 위한 scanner.nextLine()이 어떨 때는 enter를 쳐야되고,
                // 어떨 때는 그냥 버퍼 비우기 기능만 실행되고, 왔다갔다 해서
                // 버퍼 처리 필요 없는 함수 사용함

                // 이 미친 것이 입력 받은 String에 '.'이 포함되면 Double타입으로, 포함 X이면 Integer로 저장하라고 했는데
                // 지 맘대로 Double 타입으로 저장하는 문제 발생...
                // 그래서 형 결정 방식을 바꿔볼려고 함.

                try {
                    return Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    try {
                        return Double.parseDouble(number);
                    } catch (NumberFormatException ex) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요 : ");
                    }
                }

                System.out.println("입력값: [" + number + "]");

//                return num1;
            } catch (NumberFormatException e) {
                System.out.print("잘못된 입력입니다. 정수를 입력해주세요. : ");
            }
        }
    }

    public OperatorType inputOperator() throws IllegalArgumentException {
        while (true) {
            try {
                System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                char operator = scanner.nextLine().charAt(0);
                switch(operator) {
                    case '+' : return OperatorType.ADD;
                    case '-' : return OperatorType.SUB;
                    case '*' : return OperatorType.MUL;
                    case '/' : return OperatorType.DIV;
                    default:
                        throw new IllegalArgumentException("지원하지 않는 연산 기능 입니다.");
                }
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("입력이 비어 있습니다.");
            }
        }
    }

    public String inputAnswer() {
        String answer = scanner.nextLine();
        return answer;
    }

    public int inputIndex(String choice, int indexCount){
        while(true) {
            try {
                System.out.print(choice + " 하고 싶은 계산 결과 번호(1 ~ " + indexCount + ") : ");
                int index = Integer.parseInt(scanner.nextLine());
                if(index < 1 || index > indexCount) {
                    System.out.println("유효하지 않은 인덱스입니다.");
                } else {
                    return index;
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
            }
        }
    }

    public String inputCorrection() {
        System.out.print("수정 값 ((ex) 1. 1 + 1 = 2) : ");
        String correction = scanner.nextLine();
        return correction;
    }


}

