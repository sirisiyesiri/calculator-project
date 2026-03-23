package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();
        int number1 = 0;
        int number2 = 0;
        char operation = ' ';
        int result = 0;
        int index;
        int indexCount;

        System.out.println("=== Java 계산기 ===");

        while(true) {

            System.out.println("=== 계산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 결과 전체 조회");
            System.out.println("3. 계산 결과 단일 조회");
            System.out.println("4. 계산 결과 수정");
            System.out.println("5. 계산 결과 삭제");


            System.out.println();
            System.out.print("선택 : ");
            int choice = scanner.nextInt();
            scanner.nextLine();


            switch(choice) {
                case 1:
                    while(true) {
                        boolean flag = true;
                        while(flag) {
                            try {   // 잘못된 자료형의 입력을 받을 시 예외처리
                                System.out.print("첫 번째 수를 입력해 주세요. : ");
                                number1 = scanner.nextInt();
                                System.out.print("두 번째 수를 입력해 주세요. : ");
                                number2 = scanner.nextInt();
                            } catch(InputMismatchException e) {
                                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                                scanner.nextLine(); // scanner 비우기
                                continue;
                            }
                            scanner.nextLine(); // scanner비우기 -> 비우지 않으면 number1 = scanner.nextInt() 구문에 도달할 때 마다 예외 발생
                            System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                            operation = scanner.nextLine().charAt(0);  // 입력한 문자열의 맨 첫 번째 글자 operation 변수에 입력
                            // Calculator 클래스에서 연산 오류 잡으니까 try-catch 안 함.
                            flag = false;
                        }

                        try{
                            result = calculator.calculate(number1, number2, operation);
                            System.out.println("계산 결과 : " + result);
                            System.out.println();

                            while(true) {
//                            scanner.nextLine(); // scanner 비우기

                                System.out.print("기존 계산 결과를 이어서 계속하시겠습니까? (y/n) : ");
                                char continueAnswer = scanner.nextLine().charAt(0);
                                if(continueAnswer == 'y' || continueAnswer == 'Y') {
                                    try {
                                        System.out.print("두 번째 수를 입력해 주세요. : ");
                                        number2 = scanner.nextInt();
                                    } catch (InputMismatchException e) {
                                        System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                                        continue;
                                    }
                                    try {
                                        scanner.nextLine(); // scanner 비우기
                                        System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                                        operation = scanner.nextLine().charAt(0);  // 입력한 문자열의 맨 첫 번째 글자 operation 변수에 입력
                                    } catch (RuntimeException e) {
                                        System.out.println("잘못된 입력입니다. 계산 기호를 입력해주세요.");
                                        scanner.nextLine();  // scanner 비우기
                                        continue;
                                    }

                                    try{
                                        result = calculator.calculate(result, number2, operation);
                                        System.out.println("계산 결과 : " + result);
                                        System.out.println();
                                    } catch (ArithmeticException e) {   // ArithmeticException발생 시 계산 결과 출력X, 오류 메세지 출력
                                        System.out.println(e.getMessage());
                                    } catch (IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                    }
                                } else if(continueAnswer == 'n' || continueAnswer == 'N') {
                                    break;
                                } else {
                                    System.out.println("잘못된 입력입니다.");
                                    continue;
                                }
                            }
                        } catch (ArithmeticException e) {   // ArithmeticException발생 시 계산 결과 출력X, 오류 메세지 출력
                            System.out.println(e.getMessage());
                            break;  // 오류가 났을 경우 이어서 계산하기 못하게 하기 위함
                        } catch (IllegalArgumentException e) {  // 지원하지 않는 계산 기호 입력 시 계산 결과 출력X, 오류 메시지 출력
                            System.out.println(e.getMessage());
                            break;  // 오류가 났을 경우 이어서 계산하기 못하게 하기 위함
                        }
                        break;
                    }
                    break;
                case 2:
                    calculator.getArrayList();
                    break;
                case 3:
                    try {
                        indexCount = calculator.listSize();
                        System.out.print("조회 하고 싶은 계산 결과 번호(1 ~ " + indexCount + ") : ");
                        index = scanner.nextInt();
                        calculator.getSingleArrayList(index-1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e. getMessage());
                    }
                    break;
                case 4:
                    try {
                        indexCount = calculator.listSize();
                        System.out.print("수정하고 싶은 계산 결과 번호(1 ~ " + indexCount + ") : ");
                        index = scanner.nextInt();
                        scanner.nextLine(); // scanner 비우기
                        System.out.println("수정 값 ((ex) 1. 1 + 1 = 2) : ");
                        String correction = scanner.nextLine();
                        calculator.setArrayList(index-1, correction);
                        System.out.println(index + "번 째 계산 결과가 수정되었습니다.");
                    } catch(IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch(IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        calculator.removeArrayList();
                        System.out.println("1번 째 계산 결과가 삭제되었습니다.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
//            scanner.nextLine();
//            endAnswer 입력 받기 전 scanner비우기 위해 입력했던 건데,리스트 조회 시 enter를 눌러야 넘어가게되어서 한 번 없애 보려고 함.
            System.out.println();
            System.out.print("계산을 계속하시겠습니까? (계속 -> y, 종료 -> exit) : ");
            String endAnswer = scanner.nextLine();
            System.out.println();
            if(endAnswer.equals("exit")) break;
            else if(!endAnswer.equals("y") || !endAnswer.equals("Y")) {
                System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("계산기를 종료합니다.");

        scanner.close();


        // 조금 더 객체 지향적으로 한다면 scannermanager class를 만들어서 원하는 scanner 기능을 사용
        // ex) 해당 scanner 매서드는 어떤 exception을 처리하는지 등

    }
}
