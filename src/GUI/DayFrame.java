package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DayFrame extends JFrame implements ActionListener {
    JPanel jp = new JPanel();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JLabel jl1= new JLabel("Skriv påminnelse eller dagbok");
    JTextArea jta1=new JTextArea(20,50);
    JButton jb1= new JButton("Spara påminnelse");
    JButton jb2= new JButton("Spara dagbok");
    JButton jb3= new JButton("Uppdatera");
    JButton jb4= new JButton("Stäng");


    JScrollPane scroll = new JScrollPane(jta1);
public DayFrame(LocalDate date){
    jp.setLayout(new BorderLayout());
    jp2.setLayout(new BorderLayout());
    jp2.add(jl1,BorderLayout.NORTH);
    jp2.add(scroll,BorderLayout.SOUTH);

    jp1.add(jb1);
    jp1.add(jb2);
    jp1.add(jb3);
    jp1.add(jb4);

    jp.setLayout(new BorderLayout());
    jp.add(jp2,BorderLayout.NORTH);
    jp.add(jp1, BorderLayout.CENTER);
    add(jp);
    jb1.addActionListener(this);
    jb2.addActionListener(this);
    jb3.addActionListener(this);
    jb4.addActionListener(this);

    pack();
    //   setSize(600,600);
    setVisible(true);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(HIDE_ON_CLOSE);

}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb1){

        }
        if(e.getSource()==jb2){

        }
        if(e.getSource()==jb3){

        }
        if(e.getSource()==jb4){

        }
    }
}
