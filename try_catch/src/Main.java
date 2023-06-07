public class Main {
    public static void main(String[] args) {

        try {

        int[] num = {1,2,3};
        System.out.println(num[10]); //索引值 10 不存在
        }catch(Exception e){
            System.out.println("Error Happen, 執行 catch");
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally statement 一定會執行");
        }
    }
}