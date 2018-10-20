package EDA1_1;

import java.util.StringTokenizer;

public class InfixToPost {
    static String Postfix;

    private static ArrayStack testPrecedence(String a, String b, ArrayStack Op, boolean verbose){
        String temp;


        // todas as regras de interação (prioridades etc.)
        if (a.equals("^")){
            Op.push(a);
            if (verbose){
                System.out.println("Coloca na Stack: "+a);
            }
            return Op;
        }

        else if (a.equals("*") || a.equals("/")){
            if (b.equals("^")){
                temp=" "+Op.pop();
                Postfix=Postfix.concat(temp);
                if (verbose){
                    System.out.println("Tira da Stack: "+temp);
                }
                if (Op.empty()){
                    Op.push(a);
                    if (verbose){
                        System.out.println("Coloca na Stack: "+a);
                    }
                }
                else Op=testPrecedence(a, ""+Op.top(), Op, verbose);
                return Op;
            }
            else if (b.equals("*") || b.equals("/")){
                temp=" "+Op.pop();
                Postfix=Postfix.concat(temp);
                if (verbose){
                    System.out.println("Tira da Stack: "+temp);
                }
                Op.push(a);
                if (verbose){
                    System.out.println("Coloca na Stack: "+a);
                }
                return Op;
            }
            else if (b.equals("+") || b.equals("-")){
                Op.push(a);
                if (verbose){
                    System.out.println("Coloca na Stack: "+a);
                }
                return Op;
            }
        }

        else if (a.equals("+") || a.equals("-")){
            if (b.equals("^") || b.equals("*") || b.equals("/")){
                temp=" "+Op.pop();
                Postfix=Postfix.concat(temp);
                if (verbose){
                    System.out.println("Tira da Stack: "+temp);
                }
                if (Op.empty()){
                    Op.push(a);
                    if (verbose){
                        System.out.println("Coloca na Stack: "+a);
                    }
                }
                else Op=testPrecedence(a, ""+Op.top(), Op, verbose);
                return Op;
            }
            else if (b.equals("+") || b.equals("-")){
                temp=" "+Op.pop();
                Postfix=Postfix.concat(temp);
                if (verbose){
                    System.out.println("Tira da Stack: "+temp);
                }
                Op.push(a);
                if (verbose){
                    System.out.println("Coloca na Stack: "+a);
                }
                return Op;
            }
        }
        return Op;
    }


     public static String InfixToPost(String Cal, boolean verbose){
         ArrayStack Op= new ArrayStack();
         Postfix= "";
         StringTokenizer NewCal= new StringTokenizer(Cal, "+-*/()^", true);
         while (NewCal.hasMoreElements()){
             String s = NewCal.nextToken();

             if (!(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") || s.equals(")") || s.equals("^"))){
                 Postfix = Postfix.concat(" "+s);//usar as regras em cima para determinar a ordem de interação
             }

             else if (Op.empty() || Op.top().equals("(")){
                 Op.push(s);
                 if (verbose){
                     System.out.println("Coloca na Stack: "+s);
                 }
             }

             // colocar todos os elementos a interagir eu estão entre parentes

             else if (s.equals("(")){
                 Op.push("(");
                 if (verbose){
                     System.out.println("Coloca na Stack: "+s);
                 }
             }

             else if (s.equals(")")){
                 boolean enough = false;
                 while (!enough){
                     String temp ="" + Op.pop();
                     if (verbose){
                         System.out.println("Tira da Stack: "+temp);
                     }
                     if (temp.equals("(")){
                         enough=true;
                     }
                     else Postfix=Postfix.concat(" "+temp);
                 }
             }

             else Op = testPrecedence(s,""+Op.top(), Op, verbose);
         }
         while (!Op.empty()){
             String temp=""+Op.pop();
             Postfix=Postfix.concat(" "+temp);
             if (verbose){
                 System.out.println("Tira da Stack: "+temp);
             }
         }

         return Postfix;

     }

    public static void main(String[] args) {
        String a=InfixToPost("6*(4+2^5)-34", true);
        System.out.println("\nExpressão final em PostFix: "+a+"\n");
        System.out.println("\n"+EvalPostfix.EvalPostfix(a, true));

    }

}
