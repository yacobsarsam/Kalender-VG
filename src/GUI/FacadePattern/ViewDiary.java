package GUI.FacadePattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViewDiary extends JFrame implements ActionListener, GUI {

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
    JButton jb1= new JButton("Redigera");
    JButton jb2= new JButton("Stäng");
    JButton jb3 = new JButton("Spara");
    JButton jb4 = new JButton("Ångra");
    List<String>diaryList = new ArrayList<>();

    int counter = 0;
    int postEntry = 0;
    String temp = "";
    String temp1 = "";
    String temp2 = "";
    String temp3 = "";


    public void Draw(LocalDate date) {
        this.date = date;
        jp.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());
        jp3.setLayout(new FlowLayout());
        jta1.setLineWrap(true);
        jta1.setWrapStyleWord(true);
        jp4.add(jta1);
        jp3.add(jl2);
        jp3.add(jta2);
        jp2.add(jl1, BorderLayout.NORTH);
        jp2.add(jp3, BorderLayout.SOUTH);
        jp1.add(jb1);
        jp1.add(jb2);
        jp.setLayout(new BorderLayout());
        jp.add(jp2, BorderLayout.NORTH);
        jp.add(jp4, BorderLayout.CENTER);
        jp.add(jp1, BorderLayout.SOUTH);
        add(jp);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        readDiary();
    }

    private void readDiary(){
        jta2.setFocusable(false);
        jta1.setFocusable(false);
        try (BufferedReader br = new BufferedReader(new FileReader("src/GUI/Diary.txt"));) {
            while ((temp = br.readLine()) != null) {
                counter++;
                String[] parts = temp.split("¤");
                if (parts.length >= 3) {
                    LocalDate reminderDate = LocalDate.parse(parts[0].trim());
                    String diaryHeader = parts[1].trim();
                    String diaryBody = parts[2].trim();

                    if (reminderDate.equals(date)) {
                        postEntry = counter;
                        jta2.append(diaryHeader);
                        jta1.append(diaryBody);
                    }
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getDiaryEntries(){
        try (BufferedReader br = new BufferedReader(new FileReader("src/GUI/Diary.txt"));) {
            String tempInput;
            while ((tempInput = br.readLine()) != null){
                diaryList.add(tempInput);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    private void editDiary(){
        temp1 = String.valueOf(date);
        temp2 = jta2.getText();
        temp3 = jta1.getText();
        diaryList.remove(postEntry-1);
        diaryList.add(postEntry-1,temp1 + "¤" + temp2 + "¤" + temp3 + "¤");
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/GUI/diary.txt"))){
            bw.write("");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("src/GUI/diary.txt", true))){
            for (int i = 0; i < diaryList.size(); i++) {
                bw.write(diaryList.get(i) + "\n");
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        jp1.remove(jb3);
        jp1.remove(jb4);
        jp1.add(jb1);
        jp1.add(jb2);
        jta1.setFocusable(false);
        jta2.setFocusable(false);
        jb3.setVisible(false);
        jb4.setVisible(false);
        setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jb1){
            jb1.setVisible(false);
            jb2.setVisible(false);
            jp1.remove(jb1);
            jp1.remove(jb2);
            jp1.add(jb3);
            jp1.add(jb4);
            jta1.setFocusable(true);
            jta2.setFocusable(true);
            getDiaryEntries();
        }
        if(e.getSource()==jb2){
            setVisible(false);
        }
        if(e.getSource()==jb3){
            editDiary();
        }
        if(e.getSource()==jb4){
            setVisible(false);
        }
    }

}
