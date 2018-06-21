package com.example.packages.exampleCodes;
import com.example.packages.dataStructures.stack.StackArrayImplementation;

import java.util.Arrays;
import java.util.Scanner;

public class RomanNumbers {
    public static String romanToDecimal(java.lang.String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;
        String romanNumeral = romanNumber.toUpperCase();
        /* operation to be performed on upper cases even if user
           enters roman values in lower case chars */
        for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = romanNumeral.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return Integer.toString(decimal);
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }

        public static void main(String[] args)
        {

            StackArrayImplementation<String> StackArrayImplementation = new StackArrayImplementation<>();
            Scanner scanner = new Scanner(System.in);
            String[] splitted = scanner.nextLine().split(" ");
            System.out.println(Arrays.toString(splitted));

            StackArrayImplementation<String> ops = new StackArrayImplementation<String>();
            StackArrayImplementation<Double> vals = new StackArrayImplementation<Double>();


            for (int i = 0; i < splitted.length; i++)
            {

                String s = splitted[i];
                if (s.equals("(")) ;
                else if (s.equals("+")) ops.push(s);
                else if (s.equals("-")) ops.push(s);
                else if (s.equals("*")) ops.push(s);
                else if (s.equals("/")) ops.push(s);
                else if (s.equals("sqrt")) ops.push(s);
                else if (s.equals(")"))
                {

                    String op = ops.pop();
                    double v = vals.pop();
                    System.out.println(v);

                    if (op.equals("+")) v = vals.pop() + v;
                    else if (op.equals("-")) v = vals.pop() - v;
                    else if (op.equals("*")) v = vals.pop() * v;
                    else if (op.equals("/")) v = vals.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                }
                else {

                    s = romanToDecimal(s);
                    //System.out.println("Converted:" + s);

                    vals.push(Double.parseDouble(s));
                }
            }

            System.out.println(vals.pop());
        }

}

