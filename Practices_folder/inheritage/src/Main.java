
class Vehicle {
    protected String brand = "Ford";

    public void honk() {
        System.out.println("Tut");
    }


    class Car extends Vehicle { // Car 類別繼承了 Vehicle類別的屬性&方法
        private String modelName = "Mustang";

        public static void main(String[] args) {

//            一般情況要使用其他類別的屬性或方法，需要建立其類別的物件-> 如: Vehicle myObj = new Vehicle()
//            但因為 已經繼承了 Vehicle 了，因此建立本身類別的物件就可以。
            Car myObj = new Car();

            // Call the honk() method (from the Vehicle class) on the myCar object
            myObj.honk();

// Display the value of the brand attribute (from the Vehicle class) and the value of the modelName from the Car class
            System.out.println(myObj.brand + "  " + myObj.modelName);
        }
    }
}