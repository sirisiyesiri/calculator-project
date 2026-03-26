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
                // 처음에 위에와 같이 코드를 썼는데 왜인지 모르지만 타입 구분이 안되고, 다 Double로 return이 되어서 아래와 같이 타입구분 방식을 변경함.

                try {
                    return Integer.parseInt(number);
                } catch (NumberFormatException e) {
                    try {
                        return Double.parseDouble(number);
                    } catch (NumberFormatException ex) {
                        System.out.print("잘못된 입력입니다. 숫자를 입력해주세요 : ");
                    }
                }
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
        System.out.print("수정 값 ((ex) 1 + 1 = 2) : ");
        String correction = scanner.nextLine();
        return correction;
    }


}

