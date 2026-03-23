package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerManager{
    Scanner scanner = new Scanner(System.in);

    public int inputNumber() {
        while(true) {
            try {
                int num1 = Integer.parseInt(scanner.nextLine());    // scanner.nextLine()로 입력받은 문자열('\n' 포함)을 숫자로 변환 시켜주는 함수
                // scanner 비우기를 위한 scanner.nextLine()이 어떨 때는 enter를 쳐야되고,
                // 어떨 때는 그냥 버퍼 비우기 기능만 실행되고, 왔다갔다 해서
                // 버퍼 처리 필요 없는 함수 사용함
                return num1;
            } catch (NumberFormatException e) {
                System.out.print("잘못된 입력입니다. 정수를 입력해주세요. : ");
            }
        }
    }

    public char inputOperator() {
        while (true) {
            try {
                System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                char operator = scanner.nextLine().charAt(0);
                return operator;
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

