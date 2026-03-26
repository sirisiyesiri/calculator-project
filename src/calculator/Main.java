package calculator;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        ScannerManager scannerManager = new ScannerManager();
        HistoryList resultList = new HistoryList();
        Calculator<Integer> calculatorInt = new Calculator<>(resultList);
        Calculator<Double> calculatorDouble = new Calculator<>(resultList);
        Number number1 = 0;
        Number number2 = 0;
        OperatorType operation;
        double resultDouble = 0;
        int resultInt = 0;
        Number result = 0;
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
            System.out.println("6. 특정 값보다 큰 결과 조회");

            System.out.println();
            System.out.print("선택 : ");
            int choice = (Integer)scannerManager.inputNumber();
            // inputNumber 함수에서 Double 인지 Integer인지 구분하는 코드가 안 먹어서 전부 Double타입으로 반환되는 오류가 났었음...
            // Double -> Integer는 불가능 했기 때문에 .intValues()함수를 이용 했었는데 해당 코드를 손 봐서 캐스팅이 됨.


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
                            if(number1 instanceof Double && number2 instanceof Double) {
                                // calculate함수의 매개변수 형이 Double인데(제네릭이니까 생성자 제네릭 타입에 따라감), number1, number2는 Object니까 다운 캐스팅 필요함.
                                resultDouble = (double)calculatorDouble.calculate((Double)number1, (Double) number2, operation);
                                result = resultDouble;
                            } else if(number1 instanceof Double && number2 instanceof Integer) {
                                resultDouble = (double)calculatorDouble.calculate((Double)number1,number2, operation);
                                result = resultDouble;
                            } else if(number1 instanceof Integer && number2 instanceof Double) {
                                resultInt = (int)calculatorInt.calculate((Integer) number1, number2, operation);
                                result = resultInt;
                            }
                            else {
                                resultInt = (int)calculatorInt.calculate((Integer) number1, (Integer) number2, operation);
                                result = resultInt;
                            }
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
                                        if(result instanceof Double && number2 instanceof Double) {
                                            // calculate함수의 매개변수 형이 Double인데(제네릭이니까 생성자 제네릭 타입에 따라감), number1, number2는 Object니까 다운 캐스팅 필요함.
                                            resultDouble = (double)calculatorDouble.calculate((Double)result, (Double) number2, operation);
                                            result = resultDouble;
                                        } else if(result instanceof Double && number2 instanceof Integer) {
                                            resultDouble = (double)calculatorDouble.calculate((Double)result,number2, operation);
                                            result = resultDouble;
                                        } else if(result instanceof Integer && number2 instanceof Double) {
                                            resultDouble = (double)calculatorInt.calculate((Integer) result, number2, operation);
                                            result = resultDouble;
                                        }
                                        else {
                                            resultInt = (int)calculatorInt.calculate((Integer) result, (Integer) number2, operation);
                                            result = resultInt;
                                        }
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
                    resultList.getArrayList();
                    break;
                case 3:
                    try {
                        indexCount = resultList.listSize();
                        index = scannerManager.inputIndex("조회", indexCount);
                        resultList.getSingleArrayList(index-1);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        indexCount = resultList.listSize();
                        index = scannerManager.inputIndex("수정", indexCount);
                        String correction = scannerManager.inputCorrection();
                        resultList.setArrayList(index-1, correction);
                        System.out.println(index + "번 째 계산 결과가 수정되었습니다.");
                    } catch(IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        resultList.removeArrayList();
                        System.out.println("1번 째 계산 결과가 삭제되었습니다.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("기준값 입력 : ");
                    Number input = scannerManager.inputNumber();

                    resultList.biggerThenInput(input);
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
