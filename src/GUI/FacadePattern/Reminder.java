package GUI.FacadePattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reminder extends JFrame implements ActionListener, GUI {

    LocalDate date;
    JPanel jp = new JPanel();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JLabel jl1 = new JLabel("Lägg till påminnelse");
    JTextArea jta1 = new JTextArea(10, 40);
    JButton jb1 = new JButton("Spara");
    JButton jb2 = new JButton("Stäng");

    public void Draw(LocalDate date) {
        this.date = date;
        setTitle("Påminnelser");
        jp.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());
        jp3.setLayout(new FlowLayout());
        jp4.add(jta1);

        jp2.add(jl1, BorderLayout.NORTH);
        jp2.add(jp3, BorderLayout.SOUTH);

        //så att det byter rad automatiskt och lagrar utan radbyte
        jta1.setLineWrap(true);

        jp1.add(jb1);
        jp1.add(jb2);

        jp.setLayout(new BorderLayout());
        jp.add(jp2, BorderLayout.NORTH);
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
        if (e.getSource() == jb1) {
            String reminder = jta1.getText();
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/GUI/Reminders.txt", true));) {
                bw.write(date + ": " + reminder + "\n");

            } catch (Exception exc) {
                exc.printStackTrace();
            }
            setVisible(false);

        }
        if (e.getSource() == jb2) {
            setVisible(false);
        }
    }

}