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
                            } catch(InputMismatchException e) {
                                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                                scanner.nextLine();
                                // scanner비우기 -> 비우지 않으면 number1 = scanner.nextInt() 구문에 도달할 때 마다 예외 발생
                                continue;
                            }
                            try {
                                System.out.print("두 번째 수를 입력해 주세요. : ");
                                number2 = scanner.nextInt();
                            } catch (InputMismatchException e) {
                                System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                                scanner.nextLine();
                                continue;
                            }
                            scanner.nextLine(); // scanner 비우기
                            try {
                                System.out.print("계산 기호를 입력해주세요.(+, -, *, /) : ");
                                operation = scanner.nextLine().charAt(0);  // 입력한 문자열의 맨 첫 번째 글자 operation 변수에 입력
                            } catch (RuntimeException e) {
                                System.out.println("잘못된 입력입니다. 계산 기호를 입력해주세요.");
                                scanner.nextLine();
                                continue;
                            }
                            flag = false;
                        }

                        try{
                            result = calculator.calculate(number1, number2, operation);
                            System.out.println("계산 결과 : " + result);
                        } catch (ArithmeticException e) {   // ArithmeticException발생 시 계산 결과 출력X, 오류 메세지 출력
                            System.out.println(e.getMessage());
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                        }

                        while(true) {
//                            scanner.nextLine(); // scanner 비우기

                            // continueAnswer의 입력 검증 과정 필요
                            // 현재 y 이외의 모든 답은 그냥 while문을 빠져나가는 문제 존재
                            // n 이외의 답을 입력하면 처리하는 과정 필요

                            System.out.print("기존 계산 결과를 이어서 계속하시겠습니까? (y/n) : ");
                            String continueAnswer = scanner.nextLine();
                            if(continueAnswer.equals("y")) {
                                try {
                                    System.out.print("두 번째 수를 입력해 주세요. : ");
                                    number2 = scanner.nextInt();
                                } catch (InputMismatchException e) {
                                    System.out.println("잘못된 입력입니다. 정수를 입력해주세요.");
                                    scanner.nextLine(); // scanner 비우기
                                    continue;
                                }
                                scanner.nextLine(); // scanner 비우기
                                try {
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
                                } catch (ArithmeticException e) {   // ArithmeticException발생 시 계산 결과 출력X, 오류 메세지 출력
                                    System.out.println(e.getMessage());
                                } catch (IllegalArgumentException e) {
                                    System.out.println(e.getMessage());
                                }
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
                    indexCount = calculator.listSize();
                    if(indexCount != 0) {
                        System.out.print("조회 하고 싶은 계산 결과 번호 (1 ~ " + indexCount + ") : ");
                        index = scanner.nextInt();
                        if(index < 1 || index > indexCount) {
                            System.out.println("잘못된 번호입니다.");
                            break;
                        }
                        calculator.getSingleArrayList(index - 1);
                    } else {
                        System.out.println("조회할 계산 결과가 존재하지 않습니다.");
                    }
                    break;
                case 4:
                    indexCount = calculator.listSize();
                    if(indexCount != 0) {
                        System.out.print("수정하고 싶은 계산 결과 번호 (1 ~ " + indexCount + ") : ");
                        index = scanner.nextInt();
                        scanner.nextLine(); // scanner 비우기
                        if(index < 1 || index > indexCount) {
                            System.out.println("잘못된 번호입니다.");
                            break;
                        }
                        System.out.println("수정 값 : ");
                        String correction = scanner.nextLine();
                        calculator.setArrayList(index-1, correction);
                        System.out.println(index + "번 째 계산 결과가 수정되었습니다.");
                    } else {
                        System.out.println("수정할 계산 결과가 존재하지 않습니다.");
                    }
                    break;
                case 5:
                    if(calculator.listSize() != 0) {
                        calculator.removeArrayList();
                        System.out.println("1번 째 계산 결과가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 계산 결과가 존재하지 않습니다.");
                    }
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
            System.out.println();
            System.out.print("계산을 계속하시겠습니까? (계속 -> y, 종료 -> exit) : ");
            String endAnswer = scanner.nextLine();
            if(endAnswer.equals("exit")) break;
        }

        System.out.println("계산기를 종료합니다.");

        scanner.close();


        // 조금 더 객체 지향적으로 한다면 scannermanager class를 만들어서 원하는 scanner 기능을 사용
        // ex) 해당 scanner 매서드는 어떤 exception을 처리하는지 등

        // 1. index번호 관리 필요
        // 2. 계산 결과가 오류가 났을 시, 이어서 계산하기 기능을 사용하지 못하게 바꿔야 할 것 같음
        // 3. contiuneAnswer 입력 검증 필요
        // 4. 현재 number1, number2를 따로 따로 받아서 따로따로 try-catch를 하고 있는데,
        // 한 try-catch문에서 한 번에 입력받게 변경 필요 있음
        // -> 각각 try-catch를 하면 한 변수는 입력되었는데 한 변수는 에러가 나서 쓰레기 값이 입력된 상태로 실행될 수 있음
        // 5. 현재 index 범위 및 사이즈 체크 & list가 비어 있는지를 main에서만 하고 있는데,
        // 이럴 경우 다른 사람들이 내 Calculator클래스를 사용할 시 list가 비어있는지, index범위 및 사이즈 체크가 되지 않음
        // => index 범위 및 사이즈 체크 & list 비어있는지를 main이 아닌 Calculator 매서드에서 하게 바꿔야 할 필요 있음


    }
}
