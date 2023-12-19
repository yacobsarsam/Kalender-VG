package GUI;

import GUI.ButtonDecorator.ButtonDecorator;
import GUI.ButtonDecorator.CyanButtonDecorator;
import GUI.ButtonDecorator.RedButtonDecorator;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class Frame extends JFrame {
    //Panels
    private final JPanel northPanel;
    private final JPanel centerPanel;
    private final JPanel eastPanel;
    private final JPanel westPanel;
    private final JPanel southPanel;
    //Labels
    JLabel monthLabel;
    JLabel yearLabel;

    //Buttons
    private final JButton nextMonth;
    private final JButton previousMonth;

    JButton addressBook = new JButton("Adressbok");

    //Paths
    private final ImageIcon icon;

    private LocalDate date;

    public Frame(){
        northPanel = new JPanel();
        centerPanel = new JPanel();
        eastPanel = new JPanel();
        westPanel = new JPanel();
        southPanel = new JPanel();
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

        buildNorthPanel();
        buildCenterPanel();
        buildSidePanels();
        buildSouthPanel();
        setVisible(true);
    }

    private void buildSouthPanel() {
        //Adressbok knappen.
        southPanel.setLayout(new BorderLayout());
        southPanel.add(addressBook);
        add(southPanel,BorderLayout.SOUTH);
        addressBook.addActionListener(e -> {AdressBook ab = new AdressBook();});
    }

    public void buildNorthPanel(){
        //Weekdays, Month or Year info.
        northPanel.setLayout(new GridLayout(3, 1));

        monthLabel = new JLabel(String.valueOf(date.getMonth()), SwingConstants.CENTER);
        monthLabel.setFont(new Font("Sans Serif", Font.BOLD, 22));
        northPanel.add(monthLabel);

        yearLabel = new JLabel(String.valueOf(date.getYear()), SwingConstants.CENTER);
        yearLabel.setFont(new Font("Sans Serif", Font.BOLD, 14));
        northPanel.add(yearLabel);



        JPanel weekDayPanel = new JPanel(new BorderLayout());
        JPanel weekDays = new JPanel(new GridLayout(1, 7));
        String[] weekDayNames = {
                "Måndag",
                "Tisdag",
                "Onsdag",
                "Torsdag",
                "Fredag",
                "Lördag",
                "Söndag",
        };

        for (String weekDayName : weekDayNames) {
            JLabel label = new JLabel(weekDayName, SwingConstants.CENTER);
            weekDays.add(label);
//            label.setBorder(new LineBorder(Color.BLACK, 2));
        }

        //Create empty Panels the width of the next and previous buttons - svenska eller engelska idk
        JPanel emptyPanel = new JPanel();
        emptyPanel.setPreferredSize(new Dimension(60, 1));

        JPanel emptyPanel2 = new JPanel();
        emptyPanel2.setPreferredSize(new Dimension(60, 1));

        weekDayPanel.add(emptyPanel, BorderLayout.WEST);
        weekDayPanel.add(emptyPanel2, BorderLayout.EAST);
        weekDayPanel.add(weekDays, BorderLayout.CENTER);
        northPanel.add(weekDayPanel);
        add(northPanel, BorderLayout.NORTH);
    }

    public void buildCenterPanel(){
        centerPanel.setLayout(new GridLayout(6, 7));
        buildDays();
        add(centerPanel, BorderLayout.CENTER);
    }

    public void buildDays(){
        centerPanel.removeAll();
        DayOfMonth dayOfMonth = new DayOfMonth(date);
        List<LocalDate> localDateList = dayOfMonth.getDateList();
        boolean currentMonth;

        PostDatabase postDatabase = new PostDatabase();

        for(LocalDate localDate : localDateList){
            currentMonth = localDate.getMonth().equals(date.getMonth());
            DayButton dayButton = new DayButton(localDate, currentMonth);
            String date = localDate.toString();
            //HÄR SKRIVER JAG LITE GALET
            dayButton.setBackground(Color.WHITE);

            //if(postDatabase.findDataAtPost(date)||postDatabase.findDataAtReminder(date)){

                if(postDatabase.findDataAtPost(date)){
                    ButtonDecorator buttonDecorator = new CyanButtonDecorator(dayButton);
                    buttonDecorator.fillButton();


                }
                if (postDatabase.findDataAtReminder(date)) {
                    ButtonDecorator buttonDecorator = new RedButtonDecorator(dayButton);
                    buttonDecorator.SetButtonBorderColor();
                    }





            centerPanel.add(dayButton);
        }
    }

    public void buildSidePanels(){
        Dimension buttonSize = new Dimension(50, this.getHeight() - 150);

        nextMonth.setPreferredSize(buttonSize);
        nextMonth.setBackground(Color.lightGray);
        eastPanel.add(nextMonth);
        add(eastPanel, BorderLayout.EAST);
        nextMonth.addActionListener(e -> {
            date = date.plusMonths(1);
            changeMonthDetails();
        });

        previousMonth.setPreferredSize(buttonSize);
        previousMonth.setBackground(Color.lightGray);
        westPanel.add(previousMonth);
        add(westPanel, BorderLayout.WEST);
        previousMonth.addActionListener(e -> {
            date = date.minusMonths(1);
            changeMonthDetails();

        });
    }

    public void changeMonthDetails(){
        buildDays();

        monthLabel.setText(String.valueOf(date.getMonth()));
        yearLabel.setText(String.valueOf(date.getYear()));
        repaint();
        revalidate();
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
