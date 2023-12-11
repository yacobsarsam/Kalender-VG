package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayFrame extends JFrame implements ActionListener {
    LocalDate date;
    JPanel jp = new JPanel();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JLabel jl1= new JLabel("DAGBOK");
    JLabel jl2 = new JLabel("Rubrik:");
    JTextArea jta2 = new JTextArea(1,25); //Rubrik
    JTextArea jta1=new JTextArea(20,50); //Huvudfönster
    JButton jb1= new JButton("Spara");
    JButton jb2= new JButton("Ångra");
    String temp = "";


    public DayFrame(LocalDate date){
        this.date = date;
        jp.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());
        jp3.setLayout(new FlowLayout());
        jta1.setLineWrap(true);
        jta1.setWrapStyleWord(true);
        jp4.add(jta1);
        jp3.add(jl2);
        jp3.add(jta2);

        jp2.add(jl1,BorderLayout.NORTH);
        jp2.add(jp3,BorderLayout.SOUTH);

        jp1.add(jb1);
        jp1.add(jb2);

        jp.setLayout(new BorderLayout());
        jp.add(jp2,BorderLayout.NORTH);
        jp.add(jp4, BorderLayout.CENTER);
        jp.add(jp1, BorderLayout.SOUTH);
        add(jp);
        jb1.addActionListener(this);
        jb2.addActionListener(this);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb1){
            temp = String.valueOf(date);
            temp = temp + "¤" + jta2.getText();
            temp = temp + "¤" + jta1.getText() + "¤\n";
            try(BufferedWriter bw = new BufferedWriter(new FileWriter(".\\src\\GUI\\diary.txt", true));){
                bw.write(temp);
            }
            catch (Exception exc){
                exc.printStackTrace();
            }
            setVisible(false);
        }
        if(e.getSource()==jb2){
            setVisible(false);
        }
    }
}