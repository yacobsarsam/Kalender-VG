package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.time.LocalDate;

public class Frame extends JFrame {
    //Panels
    private final JPanel northPanel;
    private final JPanel centerPanel;

    //Paths
    private final ImageIcon icon;

    //TODO Remove Main
    public static void main(String[] args){
        Frame calendarFrame = new Frame();
    }

    public Frame(){
        northPanel = new JPanel();
        centerPanel = new JPanel();
        icon = new ImageIcon("Icons/Calendar.png");
        buildFrame();
    }

    private void buildFrame(){
        setSize(new Dimension(1400, 800));
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());
        setVisible(true);

        buildNorthPanel();
        add(northPanel, BorderLayout.NORTH);

        buildCenterPanel();
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildNorthPanel(){

        //Weekdays, Month or Year info.
    }

    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(6, 7));
        centerPanel.setBorder(new LineBorder(Color.BLACK, 4));
        buildDays(centerPanel, 42);
    }

    public void buildDays(JPanel monthPanel, int amount){
        //Ska ersättas av paneler av en egen klass ev.
        for(int i = 0; i < amount; i++){
            DayButton dayButton = new DayButton(LocalDate.now());
            monthPanel.add(dayButton);
        }
    }
}
