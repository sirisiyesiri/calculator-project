package calculator;

public enum OperatorType {
    // enum은 프로그램 시작 시 이미 객체가 생성되어 있음(ADD, SUB, MUL, DIV)
    // ADD, SUB, MUL, DIV는 OperatorType을 상속한 익명클래스 객체들.
    ADD('+') {
        // 추상 매서드 Override 해 놓은 것임.
        @Override
        public int applyInt(int a, int b) {
            return a + b;
        }

        @Override
        public double applyDouble(double a, double b) {
            return a + b;
        }
    },
    SUB('-') {
        @Override
        public int applyInt(int a, int b) {
            return a - b;
        }

        @Override
        public double applyDouble(double a, double b) {
            return a - b;
        }
    },
    MUL('*') {
        @Override
        public int applyInt(int a, int b) {
            return a * b;
        }

        @Override
        public double applyDouble(double a, double b) {
            return a * b;
        }
    },
    DIV('/') {
        @Override
        public int applyInt(int a, int b) {
            if(b == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return a / b;
        }

        @Override
        public double applyDouble(double a, double b) {
            if(b == 0) throw new ArithmeticException("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
            return a / b;
        }
    };

    private char operator;   // 속성

    OperatorType (char operator) {  // 생성자
        this.operator = operator;
    }

    // 기능
    public char getOperator() {
        return operator;
    }

    // 추상 매서드 : 구현X but, 자식 클래스는 매서드 구현 강제
    public abstract double applyDouble (double a, double b);
    public abstract int applyInt (int a, int b);

}

