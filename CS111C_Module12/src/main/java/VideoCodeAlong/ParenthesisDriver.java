package VideoCodeAlong;

import java.util.Stack;

public class ParenthesisDriver {

    public static void main(String[] args) {

        String checkString1 = "(34 + 3 )";
        String checkString2 = "(34 + 3 ) 8 * (3 - 4 )}";
        String checkString3 = "(34 + 3 )({ 8 * (3 - 4 )}";
        String checkString4 = "(34 + 3 )( 8 * (3 - 4 )}";
        String checkString5 = "(34 + 3  8 * (3 - 4 )}";
        String checkString6 = "(34 + 3 )){ 8 * (3 - 4 )}";

        System.out.println(checkString1 + " is balanced? " + isbalanced(checkString1) + "\n");
        System.out.println(checkString2 + " is balanced? " + isbalanced(checkString2) + "\n");
        System.out.println(checkString3 + " is balanced? " + isbalanced(checkString3) + "\n");
        System.out.println(checkString4 + " is balanced? " + isbalanced(checkString4) + "\n");
        System.out.println(checkString5 + " is balanced? " + isbalanced(checkString5) + "\n");

    }//main

    public static boolean isbalanced(String checkString){
        Stack<Parenthesis> parStack = new Stack<>();

        for (int i = 0; i < checkString.length(); i++) {
            char curentChar = checkString.charAt(i);
            Parenthesis currentParenthesis;

            if(Parenthesis.isParenthesis(curentChar)){
                currentParenthesis = new Parenthesis(curentChar);
                if (currentParenthesis.isOpen()){
                    parStack.push(currentParenthesis);
                } else {

                    if (parStack.empty()){
                        System.out.println("Extra closed parenthesis");
                        return false;
                    }
                   if(!currentParenthesis.isMatch(parStack.pop())){
                       System.out.println("Parenthesis mismatch ");

                       return false;
                   }
                }
            }
        }

        if (parStack.empty()){
            return true;
        } else {
            System.out.println("Extra open parenthesis");
            return false;
        }

    }

}//ParenthesisDriver
