package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Java 계산기 ===");

        while(true) {
            System.out.println("첫 번째 수를 입력해 주세요. : ");
            int number1 = scanner.nextInt();
            System.out.println("두 번째 수를 입력해 주세요. : ");
            int number2 = scanner.nextInt();
            System.out.println("계산 기호를 입력해주세요.(+, -, *, /) : ");
            char operation = scanner.nextLine().charAt(0);  // 입력한 문자열의 맨 첫 번째 글자 operation 변수에 입력

            int result = 0;
            switch(operation) {
                case '+' :
                    result = number1 + number2;
                    break;
                case '-' :
                    result = number1 - number2;
                    break;
                case '*' :
                    result = number1 * number2;
                    break;
                case '/' :
                    try {
                        result = number1 / number2;
                    } catch(RuntimeException e) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            System.out.println("result = " + result);

            System.out.print("계산을 계속하시겠습니까? (exit 입력 시 종료) : ");
            String endAnswer = scanner.nextLine();
            if(endAnswer.equals("exit")) {
                break;
            }
        }

        System.out.println("계산기를 종료합니다.");

        scanner.close();
    }
}
