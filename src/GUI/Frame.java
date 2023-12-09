package GUI;

import java.util.List;
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

    private LocalDate date;

    //TODO Remove Main
    public static void main(String[] args){
        Frame calendarFrame = new Frame();
    }

    public Frame(){
        northPanel = new JPanel();
        centerPanel = new JPanel();
        icon = new ImageIcon("Icons/Calendar.png");

        date = LocalDate.now();

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
        centerPanel.setBorder(new LineBorder(Color.GRAY, 4));
        buildDays();
    }

    public void buildDays(){
        DayOfMonth dayOfMonth = new DayOfMonth(date);
        List<LocalDate> localDateList = dayOfMonth.getDateList();
        boolean currentMonth;

        for(LocalDate localDate : localDateList){
            currentMonth = localDate.getMonth().equals(date.getMonth());
            DayButton dayButton = new DayButton(localDate, currentMonth);
            centerPanel.add(dayButton);
        }
    }
}
