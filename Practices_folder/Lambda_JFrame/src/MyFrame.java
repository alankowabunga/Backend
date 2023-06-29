import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame {

    JButton myBtn = new JButton("My Button");

    MyFrame() {

        myBtn.setBounds(100,100,200,100);
//        myBtn.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("You click the button.");
//            }
//        });
        // Lambda Expression
        myBtn.addActionListener(e -> System.out.println("You click the button."));

        this.add(myBtn);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(420,420);
        this.setLayout(null);
        this.setVisible(true);
    }
}
