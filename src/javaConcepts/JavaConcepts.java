package javaConcepts;

public class JavaConcepts {

    public static void main(String[] args){
        Parent parent = new Child();
        //no overriding shown
        parent.method();
        //overriding shown
        parent.method2();


    }

}

class Parent{
    static void method(){
        System.out.println("static Parent method");
    }

    void method2(){
        System.out.println("normal Parent method");
    }
}

class Child extends Parent{
    static void method(){
        System.out.println("Child method");
    }

    void method2(){
        System.out.println("normal child method");
    }
}


