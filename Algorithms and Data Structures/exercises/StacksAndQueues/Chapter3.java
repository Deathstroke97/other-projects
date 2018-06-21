    package com.example.packages.exercises.StacksAndQueues;
    import java.util.*;
    import com.example.packages.dataStructures.stack.StackArrayImplementation;
    import com.example.packages.stdlib.In;
    import javafx.beans.binding.ObjectExpression;

    class Node<Item> {
        Item data;
        Node next;
        Node (Item data) {
            this.data = data;
        }
    }

    class NodeWithMin {
        int value;
        int min;
        public NodeWithMin(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }

    class MyDequeue<Item> implements Iterable<Item> {
        Stack<Item> stack1 = new Stack<>();
        Stack<Item> stack2 = new Stack<>();


        void enqueue(Item data) {
            stack1.push(data);
        }

        Item dequeue() {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            Item removed = stack2.pop();

            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
            return removed;
        }




        public Iterator<Item> iterator() {
            return new MyDequeueIterator();
        }


        public Node reverse() {
            Iterator<Item> iterator = stack1.iterator();
            while(iterator.hasNext()) {
                stack2.push(iterator.next());
            }

            return stack2.first;
        }

        private class MyDequeueIterator implements Iterator<Item> {
            Node current = reverse();

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                Item item = (Item)current.data;
                current = current.next;
                return item;
            }

        }
    }

    class MyDequeue2<Item> {
        Stack<Item> stack1 = new Stack<>();
        Stack<Item> stack2 = new Stack<>();

        void enqueue(Item data) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            stack1.push(data);
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }

        Item dequeue() {
            return stack1.pop();
        }

        public Node reverse(Node x, Node first) {
            if (x == null) {
                return first;
            } else {
                Node oldFirst = first;
                first = x;
                first.next = oldFirst;
            }
            return reverse(x.next, x);
        }
    }


    class StackWithMin extends StackArrayImplementation<NodeWithMin> {
        void push(int value) {
            int newMin = Math.min(value, min());
            super.push(new NodeWithMin(value, newMin));
        }
        int min() {
            if(this.isEmpty())
                return Integer.MAX_VALUE;
            else{
                return peek().min;
            }
        }

    }

    class StackWithMin2 extends Stack<Integer> {
        Stack<Integer> stack2 = new Stack<>();

        public void push(int data) {
            if(data < min()){
                stack2.push(data);
            }
            super.push(data);
        }
        public int min() {
            if(stack2.isEmpty()){
                return Integer.MAX_VALUE;
            }
            return (int)stack2.peek().data;
        }

        public Integer pop() {
            int value = super.pop();
            if(value == min()) {
                stack2.pop();
            }
            return value;

        }



    }

    class Stack<Item> implements Iterable<Item> {
        private int N = 0;
        Node first = null;


        public void push(Item data) {
            Node oldFirst = first;
            first = new Node(data);
            first.next = oldFirst;
            N++;
        }

        public Item pop() {
            Node popped = first;
            first = first.next;
            N--;
            return (Item)popped.data;
        }

        boolean isEmpty() {
            return first == null;
        }

        public Node peek() {
            if(isEmpty())
                return null;
            return first;
        }

        public int size() {
            return N;
        }

        public  ArrayList<Integer> sort(Stack<Integer> stack) {

            ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack2 = new Stack<>();



            while(!stack.isEmpty()){
                int first = stack.pop();
                if(stack.isEmpty()) {
                    list.add(first);
                    break;
                }
                int second = stack.pop();

                if(first < second && stack.isEmpty()) {
                    while(!stack2.isEmpty()){
                        stack.push(stack2.pop());
                    }
                    stack.push(second);
                    list.add(first);
                }

                else if(first < second) {
                    stack2.push(second);
                    stack.push(first);
                }

                else {
                    while(!stack2.isEmpty()){
                        stack.push(stack2.pop());
                    }
                    stack.push(first);
                    list.add(second);

                }


            }
            return list;
        }

        public Iterator<Item> iterator() {
            return new StackIterator();
        }

        private class StackIterator implements Iterator<Item> {
            Node current = first;

            public boolean hasNext() {
                return current != null;
            }

            public Item next() {
                Item item = (Item) current.data;
                current = current.next;
                return item;
            }
        }


    }

     class SetOfStacks<Item> {
        private int size = 0;
        private class Stack<Item> {
            Node first = null;
            private int max = 3;
            private int n = 0;

            public void push(Item item) {
                Node oldfirst = first;
                first = new Node(item);
                first.next = oldfirst;
                n++;
            }

            public Item pop() {
                Node popped = first;
                first = first.next;
                n--;
                return (Item)popped.data;
            }
            public boolean isEmpty() {
                return first == null;
            }
            public boolean isFull() {
                return max == 3;
            }
            public int size() {
                return n;
            }
        }

        List<Stack<Item>> list = new ArrayList<Stack<Item>>();

        public void push(Item item) {
            Stack<Item> last = getLastStack();
            if(last != null && !last.isFull()) {
                last.push(item);
            }
            else{
                Stack<Item> newStack = new Stack<>();
                newStack.push(item);
                list.add(newStack);
            }
        }

        public Item pop() {
            Stack<Item> stack = getLastStack();
            Item popped = stack.pop();
            if(stack.isEmpty()){
                list.remove(list.size() - 1);
            }
            return popped;
        }

        public Stack<Item> getLastStack() {
            Stack<Item> last = null;
            for(Stack<Item> stack : list) {
                if(!stack.isFull()) {
                    last = stack;
                    break;
                }
            }
            return last;
        }

        public int size() {
            return list.size() * 3 + getLastStack().size();
        }

        public void setOfStacks() {
           for (Stack<Item> stack : list ) {
               System.out.println(stack);
           }
        }

        public void correctOrder(int index) {
            for(int i = index + 1 ; i < list.size(); i++) {
                Stack<Item> stack = list.get(i);
                Stack<Item> temp = new Stack<>();
                while(!stack.isEmpty()){
                    temp.push(stack.pop());
                }
                list.get(i - 1).push(temp.pop());

                while(!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
        }

        public Item popAt(int index) {
            Stack<Item> current = list.get(index);
            correctOrder(index);
            return (Item)current.pop();
        }


    }

    class Stack2 {
        int stackSize = 300;
        int[] buffer = new int[stackSize * 3];
        int[] stackPointer = {0, 0, 0};

        public void push(int stackNum, int value ) {
            int index = stackNum * stackSize + stackPointer[stackNum] + 1;
            stackPointer[stackNum]++;
            buffer[index] = value;
        }

        public int pop(int stackNum) {
            int index = stackNum * stackSize + stackPointer[stackNum];
            stackPointer[stackNum]--;
            buffer[index] = 0;
            return buffer[index];
        }

        public int peek(int stackNum) {
            int index  = stackSize * stackNum + stackPointer[stackNum];
            return buffer[index];
        }

        public boolean isEmpty(int stackNum) {
            return stackPointer[stackNum] == 0;
        }

    }




    public class Chapter3 {
        public static void main(String[] args) {

            Stack<Integer> stack = new Stack<>();
            stack.push(1);
            stack.push(4);
            stack.push(9);
            stack.push(3);
            stack.push(0);
            stack.push(11);
            stack.push(20);
            stack.push(0);
            stack.push(8);
            stack.push(5);

            SetOfStacks<Integer> bigstack = new SetOfStacks<>();
            bigstack.push(1);
            bigstack.push(4);
            bigstack.push(9);
            bigstack.push(3);
            bigstack.push(0);
            bigstack.push(11);
            bigstack.push(20);
            bigstack.push(0);
            bigstack.push(8);
            bigstack.push(5);









        }
    }
