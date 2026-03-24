package calculator;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ScannerManager scannerManager = new ScannerManager();
        Calculator calculator = new Calculator();
        int number1 = 0;
        int number2 = 0;
        OperatorType operation;
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
            int choice = scannerManager.inputNumber();


            switch(choice) {
                case 1:
                    while(true) {
                        System.out.print("첫 번째 수를 입력해주세요 : ");
                        number1 = scannerManager.inputNumber();
                        System.out.print("두 번째 수를 입력해주세요 : ");
                        number2 = scannerManager.inputNumber();
                        try {
                            operation = scannerManager.inputOperator();
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());
                            continue;
                        }

                        try{
                            result = calculator.calculate(number1, number2, operation);
                            System.out.println("계산 결과 : " + result);
                            System.out.println();

                            while(true) {

                                System.out.print("기존 계산 결과를 이어서 계속하시겠습니까? (y/n) : ");
                                String continueAnswer = scannerManager.inputAnswer();
                                if(continueAnswer.equals("y") || continueAnswer.equals("Y")) {
                                    System.out.print("두 번째 수를 입력해주세요 : ");
                                    number2 = scannerManager.inputNumber();
                                    try {
                                        operation = scannerManager.inputOperator();
                                    } catch(IllegalArgumentException e) {
                                        System.out.println(e.getMessage());
                                    }

                                    try{
                                        result = calculator.calculate(result, number2, operation);
                                        System.out.println("계산 결과 : " + result);
                                        System.out.println();
                                    } catch (ArithmeticException e) {   // ArithmeticException발생 시 계산 결과 출력X, 오류 메세지 출력
                                        System.out.println(e.getMessage());
                                        break;  // 오류가 났을 경우 이어서 계산하기 못하게 하기 위함
                                    }
                                } else if(continueAnswer.equals("n") || continueAnswer.equals("N")) {
                                    break;
                                } else {
                                    System.out.println("잘못된 입력입니다.");
                                    continue;
                                }
                            }
                        } catch (ArithmeticException e) {   // ArithmeticException발생 시 계산 결과 출력X, 오류 메세지 출력
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
                        index = scannerManager.inputIndex("조회", indexCount);
                        calculator.getSingleArrayList(index-1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        indexCount = calculator.listSize();
                        index = scannerManager.inputIndex("수정", indexCount);
                        String correction = scannerManager.inputCorrection();
                        calculator.setArrayList(index-1, correction);
                        System.out.println(index + "번 째 계산 결과가 수정되었습니다.");
                    } catch(IllegalArgumentException e) {
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

            System.out.println();
            System.out.print("계산을 계속하시겠습니까? (계속 -> y, 종료 -> exit) : ");
            String endAnswer = scannerManager.inputAnswer();
            System.out.println();
            if(endAnswer.equals("exit")) break;
            else if(endAnswer.equals("y") || endAnswer.equals("Y")) {
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("계산기를 종료합니다.");

    }
}
