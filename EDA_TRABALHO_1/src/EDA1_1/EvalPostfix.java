package EDA1_1;

import java.util.StringTokenizer;

public class EvalPostfix {
    public static int EvalPostfix(String Post, boolean verbose){
        ArrayStack Cal= new ArrayStack();
        StringTokenizer PostDiv= new StringTokenizer(Post);
        while (PostDiv.hasMoreElements()) {
            String s = PostDiv.nextToken();

            if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")") || s.equals("^"))) {
                int temp_nr = Integer.parseInt(s);
                Cal.push(temp_nr);
            } else if (s.equals("+")) {
                int b = (int)Cal.pop();
                int a = (int)Cal.pop();
                int total = a + b;
                Cal.push(total);
                if (verbose){
                    System.out.println("Tira da Stack: "+b);
                    System.out.println("Tira da Stack: "+a);
                    System.out.println("Tira da Stack: "+total);
                }

            } else if (s.equals("-")) {
                int b = (int)Cal.pop();
                int a = (int)Cal.pop();
                int total = a - b;
                Cal.push(total);
                if (verbose){
                    System.out.println("Tira da Stack: "+b);
                    System.out.println("Tira da Stack: "+a);
                    System.out.println("Tira da Stack: "+total);
                }

            } else if (s.equals("*")) {
                int b = (int)Cal.pop();
                int a = (int)Cal.pop();
                int total = a * b;
                Cal.push(total);
                if (verbose){
                    System.out.println("Tira da Stack: "+b);
                    System.out.println("Tira da Stack: "+a);
                    System.out.println("Tira da Stack: "+total);
                }

            } else if (s.equals("/")) {
                int b = (int)Cal.pop();
                int a = (int)Cal.pop();
                int total = a / b;
                Cal.push(total);
                if (verbose){
                    System.out.println("Tira da Stack: "+b);
                    System.out.println("Tira da Stack: "+a);
                    System.out.println("Tira da Stack: "+total);
                }

            } else if (s.equals("^")) {
                int b = (int)Cal.pop();
                int a = (int)Cal.pop();
                int total = (int)Math.pow(a, b);
                Cal.push(total);
                if (verbose){
                    System.out.println("Tira da Stack: "+b);
                    System.out.println("Tira da Stack: "+a);
                    System.out.println("Tira da Stack: "+total);
                }

            }
        }
        return (int)Cal.pop();

    }

}
