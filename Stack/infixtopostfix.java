import java.util.*;

public class infixToPostfix {

    static int Prec(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixtopostfixUtil(String str) {
        String postfix = new String("");
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isLetterOrDigit(c))
                postfix += c;

            else if (c == '(')
                s.push(c);

            else if (c == ')') {
                while (!s.isEmpty() && s.peek() != '(')
                    postfix += s.pop();

                s.pop();
            } else {
                while (!s.isEmpty() && Prec(c) <= Prec(s.peek()))
                    postfix += s.pop();

                s.push(c);
            }

        }
        while (!s.isEmpty())
            postfix += s.pop();
        return postfix;

    }

    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        String str = obj.next();
        System.out.println(infixtopostfixUtil(str));
    }
} 