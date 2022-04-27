package codegym.vn.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculator(String operator, double operand1, double operand2) {
        double result =0;
        switch (operator) {
            case "Add(+)":
                result = operand1 + operand2;
                break;
            case "Sub(-)":
                result = operand1 - operand2;
                break;
            case "Multi(*)":
                result = operand1 * operand2;
                break;
            case "Div(/)":
                result = operand1 / operand2;
                break;
            default:
                break;

        }
        return result;
    }
}
