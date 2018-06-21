package com.example.packages.exercises.StacksAndQueues;
import java.util.*;

class MyNode {
    int value;
    MyNode above;
    MyNode below;
    MyNode(int value) {
        this.value = value;
    }
}
class MyStack {
    private int capacity;
    public MyNode top, bottom;
    public int size = 0;

    public MyStack(int capacity) {
        this.capacity = capacity;
    }
    public boolean isAtCapacity() {return capacity == size; }

    public void join(MyNode above, MyNode below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(int v) {
        if (size >= capacity) return false;
        size++;
        MyNode n = new MyNode(v);
        if(size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public int pop() {
        MyNode t = top;
        top  = top.below;
        size--;
        return t.value;
    }

    public boolean isEmpty() {return size == 0;}

    public int removeBottom() {
        MyNode b = bottom;
        bottom  = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.value;
    }
    public int size() {
        return size;
    }
}

class SetOfStacksCH3 {

     ArrayList<MyStack> stacks = new ArrayList<MyStack>();
     private int capacity;


     public SetOfStacksCH3(int capacity){
         this.capacity = capacity;
     }

     public MyStack getLastStack() {
         if (stacks.size() == 0) return null;
         return stacks.get(stacks.size() - 1);
     }
     public void push(int v) {
         MyStack last = getLastStack();
         if (last != null && last.isAtCapacity()){
             last.push(v);
         }
         else {
             MyStack stack = new MyStack(3);
             stack.push(v);
             stacks.add(stack);
         }
     }


     public int pop() {
         MyStack last = getLastStack();
         int v = (int)last.pop();
         if (last.size() == 0) stacks.remove(stacks.size() - 1);
         return v;

     }

     public int popAt(int index) {
         return leftShift(index, true);
     }

     public int leftShift(int index, boolean removeTop) {
         MyStack stack = stacks.get(index);
         int removed_item;
         if(removeTop) removed_item = (int)stack.pop();
         else removed_item = stack.removeBottom();
         if(stack.isEmpty()){
             stacks.remove(index);
         }
         else if(stacks.size() > index + 1) {
             int v = leftShift(index + 1, false);
             stack.push(v);
         }
         return removed_item;
     }
}


