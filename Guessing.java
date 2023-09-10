package prodigyInfoTech;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Guessing extends JFrame implements ActionListener {

    JTextField f1,f2,f3;
    JLabel l1,l2,l3;
    JButton b1,b2,b3;
    Random rand = new Random();
    int r = rand.nextInt(100);

    int count=0;
    Guessing(){
        l1 = new JLabel("Best Score");
        l1.setBounds(20,20,100,30);
        l1.setFont(new Font("Times New Roman",Font.BOLD,16));

        f1 = new JTextField();
        f1.setBounds(30,50,50,30);
        f1.setEditable(false);

        l2 = new JLabel("Guesses");
        l2.setBounds(300,20,75,30);
        l2.setFont(new Font("Times New Roman",Font.BOLD,16));

        f2 = new JTextField();
        f2.setBounds(300,50,50,30);
        f2.setEditable(false);

        ImageIcon image = new ImageIcon("E:\\Study\\Java\\src\\prodigyInfoTech\\h.png");
        JLabel i = new JLabel();
        i.setBounds(150,50,100,100);
        i.setIcon(image);

        JLabel label = new JLabel("Guess the number?");
        label.setBounds(100,150,300,50);
        label.setFont(new Font("Bell MT",Font.BOLD,25));
        label.setForeground(Color.red);

        JLabel label1 = new JLabel("Enter a number between 1-100");
        label1.setBounds(90,175,300,50);
        label1.setFont(new Font("Times New Roman",Font.BOLD,17));

        f3 = new JTextField();
        f3.setBounds(160,220,50,30);

        l3 = new JLabel();
        l3.setBounds(130,250,300,40);
        l3.setFont(new Font("Times New Roman",Font.PLAIN,17));

        b1 = new JButton("Guess");
        b1.setBounds(140,320,100,40);
        b1.setFont(new Font("Times New Roman",Font.BOLD,17));
        b1.addActionListener(this);

        b2 = new JButton("Give up!");
        b2.setBounds(50,380,100,40);
        b2.setFont(new Font("Times New Roman",Font.BOLD,17));
        b2.addActionListener(this);

        b3 = new JButton("Play Again!");
        b3.setBounds(225,380,120,40);
        b3.setFont(new Font("Times New Roman",Font.BOLD,17));
        b3.addActionListener(this);

        this.add(f1);
        this.add(l1);
        this.add(l2);
        this.add(f2);
        this.add(i);
        this.add(label);
        this.add(label1);
        this.add(f3);
        this.add(l3);
        this.add(b1);
        this.add(b2);
        this.add(b3);

        ImageIcon icon = new ImageIcon("E:\\Study\\Java\\src\\prodigyInfoTech\\guess icon.png");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,500);
        this.setTitle("Guessing Game");
        this.setIconImage(icon.getImage());
        this.getContentPane().setBackground(Color.cyan);
        this.setLayout(null);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        new Guessing();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int bestScore = 100;
        if (e.getSource() == b1){
            int a = Integer.parseInt(f3.getText());
            count++;
            if (a==r){
                l3.setText("Congrats! YOU WIN");
                if (count<bestScore){
                    bestScore=count;
                    f1.setText(bestScore+"");
                }
                else{
                    f1.setText(bestScore+"");
                }
                f3.setEditable(false);
            }
            else if(a<r){
                l3.setText(a+" is too low. Try Again!");
            }
            else{
                l3.setText(a+" is too high. Try Again!");
            }
            f3.requestFocus();
            f3.selectAll();
            f2.setText(count+"");
        }

       else if (e.getSource() == b2){
            f2.setText("");
            l3.setText(r+" is the answer!");
            f3.setText("");
            f3.setEditable(false);
        }

       else if (e.getSource() == b3){
           r = rand.nextInt(100);
           f3.setText("");
           f2.setText("");
           l3.setText("");
           count=0;
           f3.setEditable(true);
           f3.requestFocus();
        }
    }
}
