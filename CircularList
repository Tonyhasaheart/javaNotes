import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CircularList<T> {
    private T[] nodes;
    //private ArrayList<T> node;
    private Object[] node;

    // Firstly use two pseudo pointers to "construct" a linear structure.
    // And then we can convert the linear structure into the circular structure by using model operator
    private int linear_tail_index = -1;
    private int linear_head_index = -1;
    private int capacity;
    private int size = 0;

    public CircularList (int arg_capacity){
        //unit test tag: 101
        capacity = arg_capacity;
        linear_tail_index = 0;
        linear_head_index = 0;
        size = 0;
        node = new Object[capacity];
        nodes = (T[]) node;
        //node = new ArrayList<>(capacity);
        //nodes = node.toArray();
    }

    public void addLast (T i) {
        //unit test tag: 102
        if(size < capacity){
            nodes[linear_tail_index%capacity]=i;
            //note the linear tail index would point to nothing.
            //The last element is [linear_tail_index - 1], and we ues circular tail index to point to the last one.
            linear_tail_index=(linear_tail_index+1)%capacity;
        }else{
            expandAndCopy(); // if the List is already full, we double the memory space
            nodes[linear_tail_index%capacity]=i;
            linear_tail_index=(linear_tail_index+1)%capacity;
        }
        size++;
    }

    public T removeFirst() {
        //103
        //if we can successfully remove the value, we return the removed value and head++.
        if(!isEmpty()){
            T temp;
            temp = nodes[linear_head_index%capacity];
            linear_head_index = (linear_head_index+1)%capacity;
            size--;
            return temp;
        }else{
            System.out.println("Remove failed! Because there is no element in the list.");
            return null;
        }

    }

    public void clear() {
        //104
        linear_head_index = 0;
        linear_tail_index = 0;
        size = 0;
        node = new Object[capacity];
        nodes = (T[]) node;
    }

    public int size() {
        return size;
    }

    public int capacity(int i) {
        //105
        if(i>=size){
            capacity = i;
            return capacity;
        }else{
            System.out.println("Can not reassign capacity to a number smaller than size!");
            return -1;
        }


    }
    public int capacity() {
        //105
        return capacity;
    }

    public T get(int arg_index) {
        //test tag: 106
        //The rule : head index is pointed to null. The element right after the head index is the first one.
        if(arg_index<0) return null;
        if(!isEmpty()){
            return nodes[(linear_head_index + arg_index%size)%capacity];
        }else{
            System.out.println("Cannot get a value from an empty list!");
            return null;
        }

    }

    public T getFirst() {
        //test tag 107
        if(!isEmpty()){
            return nodes[linear_head_index%capacity];
        }else{
            System.out.println("Cannot get a value from an empty list!");
            return null;
        }

    }

    public T getLast() {
        //tag 107
        if(!isEmpty()){
            return nodes[(linear_tail_index - 1 + capacity)%capacity];
        }else{
            System.out.println("Cannot get a value from an empty list!");
            return null;
        }
    }

    public void addFirst(T i) {
        //tag 102
        if(size < capacity){
            nodes[(linear_head_index-1 + capacity)%capacity]=i;
            // Node that the head_index can be smaller than 0 so we need to plus capacity
            linear_head_index= (linear_head_index + capacity - 1)%capacity;
        }else{
            expandAndCopy(); // if the List is already full, we double the memory space
            nodes[(linear_head_index-1 + capacity)%capacity]=i;
            linear_head_index= (linear_head_index + capacity - 1)%capacity;
        }
        size++;
    }

    public T removeLast() {
        //if we can successfully remove the value, we return the removed value and tail--.
        if(!isEmpty()){
            T temp;
            temp = nodes[(linear_tail_index-1+capacity)%capacity];
            linear_tail_index = (linear_tail_index-1+capacity)%capacity;
            size--;
            return temp;
        }else{
            System.out.println("Remove failed! Because there is no element in the list.");
            return null;
        }
    }

    public T sampleUniform() {
        Random random  = new Random();
        double temp = random.nextDouble();
        temp = temp * capacity;
        int random_index = (int)Math.floor(temp);

        return get(random_index);
    }
    private void expandAndCopy(){
        //108
        //there are two steps:firstly we double the space,
        //secondly we copy the list in the first half of new space
        Object[] new_nodes = new Object[2 * capacity];
        for(int i = 0 ; i < size; i++){
            new_nodes[i] = nodes[(linear_head_index + i)%capacity];
        }
        // Substitute new arguments into the list.
        nodes = (T[]) new_nodes;
        linear_head_index = 0;
        linear_tail_index = linear_head_index + size;
        capacity = 2 * capacity;

    }

    private boolean isEmpty(){
        if(size == 0){
            return true;
        }else{
            return false;
        }
    }

}
