import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        String name= JOptionPane.showInputDialog("Enter your name");
        JOptionPane.showMessageDialog(null,"hello ~"+name);

//      接收輸入的內容，showInputDialog 得到的是字串，需要轉為整數型態。
        int age = Integer.parseInt(JOptionPane.showInputDialog("How old are you?"));
        JOptionPane.showMessageDialog(null,"I'm also "+age);

    }
}