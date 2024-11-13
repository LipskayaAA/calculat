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
        scanner.close();
        return input;
    }

    public static String[] isValid(String input) {
        try {
            String[] arr = input.split(" ");

            if (arr.length != 3) {
                System.out.println("Не валидные данные");
                return null;
            }

            int firstNum = Integer.parseInt(arr[0]);
            int secondNum = Integer.parseInt(arr[2]);
            String sign = arr[1];

            return new String[]{String.valueOf(firstNum), sign, String.valueOf(secondNum)};


        } catch (NumberFormatException e) {
            System.out.println("Это не цифры!");
            return null;
        }

    }



    public static String calc(String input) throws MyException {

        String[] validStrings = isValid(input);
        if (validStrings == null) {
            throw new MyException("Это не цифры!");
        }

        int firstNum = Integer.parseInt(validStrings[0]);
        int secondNum = Integer.parseInt(validStrings[2]);
        String sign = validStrings[1];

        if (firstNum > 10 || secondNum > 10 || firstNum < 0 || secondNum < 0) {
            throw new MyException("Не корректные данные!");
        }

        return switch (sign) {
            case "+" -> Integer.toString(firstNum + secondNum);
            case "-" -> Integer.toString(firstNum - secondNum);
            case "*" -> Integer.toString(firstNum * secondNum);
            case "/" -> {
                if (secondNum == 0) {
                    throw new MyException("Деление на ноль");
                }
                yield Integer.toString(firstNum / secondNum);
            }
            default -> throw new MyException("Неизвестные операторы");
        };

    }
}

class MyException extends Exception {
    public MyException(String description){
        super(description);
    }
}
