// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

abstract class Bike {
    abstract void run();
}

//        透過extends抽象類別(abstract class)的非抽象類別來實現生成物件。
class Remote extends Bike {
    void run() {
        System.out.println("remote class running");
    }

    public static void main(String args[]) {
        Bike obj = new Remote(); // 前 abstract class、後new extends class!!
        obj.run();
    }
}