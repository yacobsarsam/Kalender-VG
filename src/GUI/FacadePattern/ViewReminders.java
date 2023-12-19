package GUI.FacadePattern;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ViewReminders extends JFrame implements ActionListener, GUI {

    LocalDate date;
    JPanel jp = new JPanel();
    JPanel jp1 = new JPanel();
    JPanel jp2 = new JPanel();
    JPanel jp3 = new JPanel();
    JPanel jp4 = new JPanel();
    JLabel jl1 = new JLabel("Mina påminnelser");
    JTextArea jta1 = new JTextArea(10, 40);
    JButton jb2 = new JButton("Stäng");

    public void Draw(LocalDate date) {
        this.date = date;
        setTitle("Påminnelser");
        jp.setLayout(new BorderLayout());
        jp2.setLayout(new BorderLayout());
        jp3.setLayout(new FlowLayout());
        jta1.setFocusable(false);
        jp4.add(jta1);


        jp2.add(jl1, BorderLayout.NORTH);
        jp2.add(jp3, BorderLayout.SOUTH);

        jp1.add(jb2);
        jb2.addActionListener(this);

        jp.setLayout(new BorderLayout());
        jp.add(jp2, BorderLayout.NORTH);
        jp.add(jp4, BorderLayout.CENTER);
        jp.add(jp1, BorderLayout.SOUTH);
        add(jp);

        readReminders();

        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }


    private void readReminders() {
        try (BufferedReader br = new BufferedReader(new FileReader("/src/GUI/Reminders.txt"));) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts.length >= 2) {
                    LocalDate reminderDate = LocalDate.parse(parts[0].trim());
                    String reminderText = parts[1].trim();

                    if (reminderDate.equals(date)) {
                        // Lägg till påminnelsen för det aktuella datumet
                        jta1.append("\u25CF " + reminderText + "\n");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==jb2) {
            setVisible(false);
        }
    }
}