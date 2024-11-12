package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MyException {
        String s = Input();
        String s1 = calc(s);
        System.out.println(s1);
    }

    public static String Input() {
        System.out.println("Введите числа: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static String calc(String inp) throws MyException {
        String[] s = inp.split(" ");
        if (s.length < 3) {
            throw new MyException("т.к. строка не является математической операцией");
        } else if (s.length > 3) {
            throw new MyException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }

        int result;
        int first = Integer.parseInt(s[0]);
        int second = Integer.parseInt(s[2]);
        String sign = s[1];

        switch (sign) {
            case "+":
                result = first + second;
                return Integer.toString(result);
            case "-":
                result = first - second;
                return Integer.toString(result);
            case "*":
                result = first * second;
                return Integer.toString(result);
            case "/":
                result = first / second;
                return Integer.toString(result);
        }
        return null;

    }
}

class MyException extends Exception {
    public MyException(String description){
        super(description);
    }
}
