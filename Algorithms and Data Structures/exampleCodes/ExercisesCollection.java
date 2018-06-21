package com.example.packages.exampleCodes;
import java.util.*;

/*public class ExercisesCollection {
    static class Emp {
        int id;
        String name;

        Emp(int id, String name) {
            this.id = id;
            this.name = name;
        }
        public boolean equals(Object obj){
            *//*return obj.id == this.id*//*
            if (obj instanceof Emp) {
                Emp emp = (Emp)obj;
                if (emp.id == this.id && emp.name.equals(this.name))
                    return true;
            }
            return false;
        }
    }
    public static void main(String args[]) {
        ArrayList<Emp> list = new ArrayList<Emp>();


        list.add(new Emp(121, "Shreya"));
        list.add(new Emp(55, "Harry"));
        list.add(new Emp(15, "Paul"));
        list.add(new Emp(121, "Shreya"));
        System.out.println(list.size());

        Emp emp = new Emp (121, "Shreya");
        list.remove(emp);
        System.out.println(list.size());
    }*/
/*class RemoveArrayListElements {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        Integer age1 = 20;
        Integer age2 = 20;
        list.add(age1);
        list.add(age2);
        System.out.print(list.size() + ":");
        age1 = 30;
        list.remove(age1);
        System.out.print(list.size() + "\n");
        for(Integer i : list) {
            System.out.println(i);
        }
    }
}*/
class Emp {
    String name;
    Emp(String name) {
        this.name = name;
    }
    public int hashCode() {
        return name.hashCode();
    }
    public boolean equals(Object o) {
        if (o instanceof Emp)
            return ((Emp)o).name.equals(name);
        else
            return false;
    }
    public String toString() {
        return name;
    }
}


enum IceCream {STRAWBERRY, CHOCOLATE, WALNUT};


class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int compareTo(Person person) {
        return (person.age-this.age);
    }
    public String toString() {
        return name;
    }
}


class TestLinkedList {
    public static void main(String... args) {
/*        List<String> list = new LinkedList<String>();
        list.offer("Java");
        list.push("e");
        list.add(0, "Guru");
        list.remove("Guru");
        //list.remove("e");
        System.out.println(list);
        Arrays.asList(list);

      //  Map<String, Double> salaryMap = new HashMap<>();
        Map<String , Double> salaryMap = new HashMap<>();
        Map<String, Object> copySalaryMap = new HashMap<>(salaryMap);*/


/*        Map<Emp, Emp> empMgrMap = new HashMap<>();
        empMgrMap.put(new Emp("Shreya"), new Emp("Selvan"));
        System.out.println(empMgrMap.containsKey(new Emp("Shreya")));*/

        /*Map<Emp, Emp> empMgrMap = new HashMap<>();
        empMgrMap.put(new Emp("Shreya"), new Emp("Selvan"));
        System.out.println(empMgrMap.get(new Emp("Shreya")));*/

/*
        Map<String, Integer> colorMap = new HashMap<>();
        colorMap.put("red", 1);
        colorMap.put("blue", 2);
        colorMap.put("green", 8);
        colorMap.put("black", 28);
        colorMap.put("yellow", 18);
        colorMap.put("pink", 38);

        Set<String> setofkeys = colorMap.keySet();

        for(String str : setofkeys)
            System.out.println(str);

        Map<String, Integer> linkedColorMap = new LinkedHashMap<>();*/




/*        Map<IceCream, String> flavorMap = new TreeMap<>();
        flavorMap.put(IceCream.CHOCOLATE, "Paul");
        flavorMap.put(IceCream.STRAWBERRY, "Shreya");

        for (String s : flavorMap.values())
            System.out.println(s);*/



        TreeSet<Person> set = new TreeSet<>();
        set.add(new Person("Azat", 20));
        set.add(new Person("Saule", 21));
        set.add(new Person("Almas", 10));

        Iterator<Person> iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }













    }
}
