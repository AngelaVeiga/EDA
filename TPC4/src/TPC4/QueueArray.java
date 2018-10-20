package TPC4;
import java.util.*;
public class QueueArray <E> implements Queue <E> {
    E[] queue;
    private int top=0;
    private int last=-1;
    private static final int maxCap=50;


    public QueueArray(int maxCap){queue=(E[]) new Object[maxCap];}
    public QueueArray(){this (maxCap);}

    public void enqueue(E o) throws OverflowQueueException{
        if (size()==maxCap){
            throw new OverflowQueueException("Está cheio, como a tua mae XD");
        }
        last++;
        queue[last]=o;


    }
    public E front() throws EmptyQueueException{
        if(size()==0){
            throw new EmptyQueueException("Esta vazio pá!");
        }
        E temp=queue[top];
        return temp;
    }
    public E dequeue() throws EmptyQueueException{
        if(size()==0){
            throw new EmptyQueueException("Esta vazio pá!");
        }
        E temp=queue[top];
        top++;
        if(top>maxCap){
            top-=maxCap;
        }
        return temp;
    }

    public int size(){
        if(last+1<top){
            return last+1-top+maxCap;
        }
        return last+1-top;}
    public boolean empty(){
        if (top==last+1){
            return true;
        }
        else{return false;}
    }


}
