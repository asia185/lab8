package wizut.tpsi.calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int calculate(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return add(a,b);
            case "-":
                return  subtract(a,b);
            case "*":
                return multiply(a,b);
        }
        throw new IllegalArgumentException("Nieznana operacja:" + operation);
    }
}
