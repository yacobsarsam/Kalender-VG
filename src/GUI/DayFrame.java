import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DayFrame extends JFrame implements ActionListener {
    public List<DiaryEntry> diaryEntryList = new ArrayList<>();
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
    String temp1 = "";
    String temp2 = "";
    String temp3 = "";


    JScrollPane scroll = new JScrollPane(jta1);
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

            temp1 = String.valueOf(date);
            //temp1 = String.valueOf(LocalDate.now());
            temp2 = jta2.getText();
            temp3 = jta1.getText();
            DiaryEntry de = new DiaryEntry(temp1, temp2, temp3);
            de.diaryEntryList.add(de);

            temp = String.valueOf(LocalDate.now());
            temp = temp + "%" + jta2.getText();
            temp = temp + "%" + jta1.getText();
            setVisible(false);
            //System.out.println(temp);
            for (int i = 0; i < de.diaryEntryList.size(); i++) {
                System.out.println(de.diaryEntryList.get(i).date.toString());
                System.out.println(de.diaryEntryList.get(i).header.toString());
                System.out.println(de.diaryEntryList.get(i).body.toString());
            }
        }
        if(e.getSource()==jb2){

            setVisible(false);
        }
    }
}