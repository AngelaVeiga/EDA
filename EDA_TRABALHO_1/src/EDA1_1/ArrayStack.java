package EDA1_1;

import java.util.*;

public class ArrayStack<E> implements Stack<E> {
    E[] list;
    int top=0;
    public static final int maxCap=200;



    public ArrayStack(int maxCap) {
        list = (E[]) new Object[maxCap];//criar uma stack com maxCap
    }
    public ArrayStack(){
        this (maxCap);//cria uma stack com um valor pre definido de 200
    }


    public void push(E o){
        if (top==maxCap){
            throw new ArrayIndexOutOfBoundsException();//lança exepção ao adicionar stack cheia
        }
        list[top]=o;// colocar o objecto o no topo da lista
        top++;//o topo fica difinido um espaço acima
    }


    public E top(){
        return list[top-1];//mostra o valor no topo da lista
    }


    public E pop(){
        if (top==0){
            throw new EmptyStackException();//Se esta vazio
        }
        top--;
        E temp=list[top];//temp é igual ao ultimo elemento na setack
        return temp;

    }
    public int size(){
        return top;
    }

    public boolean empty(){
        if (top==0){
            return true;
        }
        else {
            return false;
        }

    }

    // Simplesmente passar o objecto para string
    public String toString(){
        if (top!=0) {
            String ok = "[";
            for (int i = 0; i < top - 1; i++) {
                ok = ok.concat(list[i].toString()+", ");
            }
            ok = ok.concat(list[top-1].toString()+"]");
            return ok;

        }
        return "[]";
    }


}