interface FirstInterface {
    public void myMethod(); // does not have a body
}

interface SecondInterface {
    public void myOtherMethod(); // does not have a body
}

// implements to another subClass(seperate width coma , )
class DemoClass implements FirstInterface, SecondInterface {
    public void myMethod() {
        System.out.println("The body is provide here in implemented subClass\n");
    }

    public void myOtherMethod() {
        System.out.println("Just like abstract class needs 'extends', but implements can have several interfaces");
    }
}

// access the interface methods
class Main {
    public static void main(String[] args) {

        DemoClass myObj = new DemoClass();

        myObj.myMethod();
        myObj.myOtherMethod();
    }
}
