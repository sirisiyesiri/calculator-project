package calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int number1 = 0;
        int number2 = 0;
        char operation = ' ';
        int index;
        boolean flag = true;

        System.out.println("=== Java 계산기 ===");

        while(true) {

            System.out.println("=== 계산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 결과 전체 조회");
            System.out.println("3. 계산 결과 단일 조회");
            System.out.println("4. 계산 결과 수정");
            System.out.println("5. 계산 결과 삭제");

            System.out.println();
            System.out.print("계산을 종료하시겠습니까? (계속 -> y, 종료 -> exit) : ");
            String endAnswer = scanner.nextLine();
            if(endAnswer.equals("exit")) break;

            System.out.println();
            System.out.print("선택 : ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice) {
                case 1:
                    while(true) {
                        try {   // 잘못된 자료형의 입력을 받을 시 예외처리
                            System.out.print("첫 번째 수를 입력해 주세요. : ");
                            number1 = scanner.nextInt();
                        } catch(RuntimeException e) {
                            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                        }
                        try {
                            System.out.print("두 번째 수를 입력해 주세요. : ");
                            number2 = scanner.nextInt();
                        } catch (RuntimeException e) {
                            System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                        }
                        scanner.nextLine(); // scanner 비우기
                        try {
                            System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                            operation = scanner.nextLine().charAt(0);  // 입력한 문자열의 맨 첫 번째 글자 operation 변수에 입력
                        } catch (RuntimeException e) {
                            System.out.println("잘못된 입력입니다. 계산 기호를 입력해주세요.");
                        }


                        calculator.calculate(number1, number2, operation); // 사칙연산
                        int result = calculator.getResult();
                        System.out.println("계산 결과 : " + result);

                        while(true) {
                            scanner.nextLine(); // scanner 비우기
                            System.out.print("기존 계산 결과를 이어서 계속하시겠습니까? (y/n) : ");
                            String continueAnswer = scanner.nextLine();
                            if(continueAnswer.equals("y")) {
                                try {
                                    System.out.print("두 번째 수를 입력해 주세요. : ");
                                    number2 = scanner.nextInt();
                                } catch (RuntimeException e) {
                                    System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                                }
                                scanner.nextLine(); // scanner 비우기
                                try {
                                    System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                                    operation = scanner.nextLine().charAt(0);  // 입력한 문자열의 맨 첫 번째 글자 operation 변수에 입력
                                } catch (RuntimeException e) {
                                    System.out.println("잘못된 입력입니다. 계산 기호를 입력해주세요.");
                                }
                                calculator.calculate(result, number2, operation);
                                result = calculator.getResult();
                                System.out.println("계산 결과 : " + result);
                            }
                            else break;
                        }
                        break;

                    }
                    break;
                case 2:
                    calculator.getArrayList();
                    break;
                case 3:
                    System.out.print("조회 하고 싶은 계산 결과 번호 : ");
                    index = scanner.nextInt();
                    calculator.getSingleArrayList(index - 1);
                    break;
                case 4:
                    System.out.print("수정하고 싶은 계산 결과 번호 : ");
                    index = scanner.nextInt();
                    scanner.nextLine(); // scanner 비우기
                    System.out.println("수정 값 : ");
                    String correction = scanner.nextLine();
                    calculator.setArrayList(index-1, correction);
                    System.out.println(index + "번 째 계산 결과가 수정되었습니다.");
                    break;
                case 5:
                    calculator.removeArrayList();
                    System.out.println("1번 째 계산 결과가 삭제되었습니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("계산기를 종료합니다.");

        scanner.close();
    }
}
