package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class AnnotationSelection extends JFrame implements ActionListener {
    LocalDate date;

    JFrame jf = new JFrame();
    JPanel jp = new JPanel();
    JButton jb1 = new JButton("Nytt dagboksinlägg");
    JButton jb2 = new JButton("Redigera dagboksinlägg");
    JButton jb3 = new JButton("Ny påminnelse");
    JButton jb4 = new JButton("Se påminnelser");

    public AnnotationSelection(LocalDate date){
        this.date = date;


        jf.add(jp);
        jf.setVisible(true);
        jp.setLayout(new GridLayout(4,1));
        jf.setSize(210,250);
        jf.setLocationRelativeTo(null);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jp.add(jb1);
        jp.add(jb2);
        jp.add(jb3);
        jp.add(jb4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb1){
            jf.setVisible(false);
            //DiaryFrame df = new DiaryFrame();
            DayFrame df = new DayFrame(date);

        }
        if(e.getSource()==jb2){

        }
        if(e.getSource()==jb3){
            jf.setVisible(false);
            Reminder r = new Reminder(date);
        }
        if(e.getSource()==jb4){
            ViewReminders vr = new ViewReminders(date);
        }
    }
}
