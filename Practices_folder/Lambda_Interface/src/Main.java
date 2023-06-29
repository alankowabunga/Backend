public class Main {
    public static void main(String[] args) {


//        MyInterface myInterface = new MyInterface() {
//            @Override
//            public void message() {
//               -> provide body here
//            }
//        }

        String name = "Alan";
        char symbol = '!';

        MyInterface myInterface = (n, s) -> {
            System.out.println("Hello Interface");
            System.out.println("I am " + n + s);
        };

        myInterface.message(name,symbol);

    }
}