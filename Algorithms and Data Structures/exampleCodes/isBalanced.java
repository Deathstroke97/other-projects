package com.example.packages.exampleCodes;
import com.example.packages.dataStructures.stack.StackLinkedListImplementation;
import java.util.*;

public class isBalanced {
    public static void main(String[] args) {
        StackLinkedListImplementation<String> stack = new StackLinkedListImplementation<>();
        Scanner scanner = new Scanner(System.in);
        String[] splitted = scanner.nextLine().split("");

        for (int i = 0; i < splitted.length; i++) {
            if (splitted[i].equals("[") || splitted[i].equals("(") || splitted[i].equals("{")) {
                stack.push(splitted[i]);
            }
            else if (splitted[i].equals("]"))  {
                String popped = stack.pop();
                if (!popped.equals("[")) {
                    System.out.println(false);
                    return;
                }
            }
            else if (splitted[i].equals(")")) {
                String popped = stack.pop();
                if (!popped.equals("(")) {
                    System.out.println(false);
                    return;
                }
            }
            else if (splitted[i].equals("}")) {
                String popped = stack.pop();
                if (!popped.equals("{")) {
                    System.out.println(false);
                    return;
                }
            }

        }
        if(stack.size() == 0){
            System.out.println(true);
            return;
        }
        else{
            System.out.println(false);
            return;
        }
    }
}
