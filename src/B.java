import java.util.HashMap;

class A {
     void print(){
         System.out.println("B");
     }
}

public class B extends A{

    void print(){
        System.out.println("B");
    }

    public static  void main(String[] args){
        A a = new B();
        a.print();

        HashMap<String,Integer> map = new HashMap<>();
        map.put(new String("A"),1);
        map.put(new String("A"),2);
        System.out.println(map);

    }
}
