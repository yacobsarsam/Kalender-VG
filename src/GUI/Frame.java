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
    private final JPanel eastPanel;
    private final JPanel westPanel;

    //Buttons
    private final JButton nextMonth;
    private final JButton previousMonth;

    //Paths
    private final ImageIcon icon;

    private LocalDate date;

    //TODO Remove Main
    public static void main(String[] args){
        @SuppressWarnings("unused")
        Frame calendarFrame = new Frame();
    }

    public Frame(){
        northPanel = new JPanel();
        centerPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();

        nextMonth = new JButton(">>");
        previousMonth = new JButton("<<");

        icon = new ImageIcon("Icons/Calendar.png");

        date = LocalDate.now();

        buildFrame();
    }

    private void buildFrame(){
        setSize(new Dimension(1000, 600));
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("MyCalendar");
        setIconImage(icon.getImage());
        setVisible(true);

        buildNorthPanel();
        buildCenterPanel();
        buildSidePanels();
    }

    public void buildNorthPanel(){
        //Weekdays, Month or Year info.
        add(northPanel, BorderLayout.NORTH);
    }

    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(6, 7));
        centerPanel.setBorder(new LineBorder(Color.GRAY, 4));
        buildDays();
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildDays(){
        centerPanel.removeAll();
        DayOfMonth dayOfMonth = new DayOfMonth(date);
        List<LocalDate> localDateList = dayOfMonth.getDateList();
        boolean currentMonth;

        for(LocalDate localDate : localDateList){
            currentMonth = localDate.getMonth().equals(date.getMonth());
            DayButton dayButton = new DayButton(localDate, currentMonth);
            centerPanel.add(dayButton);
        }
    }

    public void buildSidePanels(){
        Dimension buttonSize = new Dimension(50, this.getHeight());

        nextMonth.setPreferredSize(buttonSize);
        eastPanel.add(nextMonth);
        add(eastPanel, BorderLayout.EAST);
        nextMonth.addActionListener(e -> {
            date = date.plusMonths(1);
            buildDays();
            repaint();
            revalidate();
        });

        previousMonth.setPreferredSize(buttonSize);
        westPanel.add(previousMonth);
        add(westPanel, BorderLayout.WEST);
        previousMonth.addActionListener(e -> {
            date = date.minusMonths(1);
            buildDays();
            repaint();
            revalidate();
        });

    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
