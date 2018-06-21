package com.example.packages.exampleCodes;
import java.util.*;
import com.example.packages.dataStructures.stack.StackArrayImplementation;
import sun.plugin.javascript.navig.Array;

/*
class example4 {

    static class INDEX {
        int index;
    }

    static class IndexForRightSubTree extends INDEX {
        int index = 0;
    }

    static class IndexForLeftSubTree extends INDEX {
        int index = 0;
    }

    public static <U extends INDEX>void test(U indx) {
        indx.index++;
        System.out.println(indx.index);
    }

    public static void main(String[] args) {
        IndexForRightSubTree R = new IndexForRightSubTree();
        IndexForLeftSubTree L = new IndexForLeftSubTree();
        test(R);
        System.out.println("NOW " + R.index);
        System.out.println("Now " + L.index);

    }
}
*/





/*    class Phone{}

    class Parcel<T> {
        private T t;

        public void set(T t) {
            this.t = t;
        }

        public T get() {
            return t;
        }
    }*/


/*    class example {
        public static void main(String[] args) {*/
           /* *//*Parcel<Phone> parcel = new Parcel<Phone>();

            parcel.set(new Phone());

            Phone phone = parcel.get();
*//*
            Parcel<Phone> parcel = new Parcel();

            parcel.set(new Phone());

            Phone phone = parcel.get();*/

     /*       class Parcel<T> {
                public <X> void deliver(X x) {
                    System.out.println(x.getClass());
                }
                public static void main(String args[]) {
                    Parcel<String> parcel = new Parcel<>();
                    *//*parcel.<Integer>deliver(new Integer(10));*//*
                    parcel.deliver(10);

                    parcel.deliver("Hello");
                }
            }

*/
     class Interoperability {
         public static void pushItems(Stack stackParam, Object item) {
             stackParam.push(item);
         }
         public static void main(String args[]) {
             Stack<String> stackObj = new Stack<String>();
             stackObj.push("Paul");
             pushItems(stackObj, new Integer(77));
             String value = stackObj.pop();
             System.out.println(value);
         }
     }






























