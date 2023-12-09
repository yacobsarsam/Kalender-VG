package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DayButton extends JButton implements ActionListener {

    boolean filled;
    LocalDate date;

    public DayButton(LocalDate date, boolean filled){
        this.filled = filled;
        this.date = date;
        buildButton();
    }

    public void buildButton(){
        if(filled){
            dayButton();
            //TODO remove - endast test
            this.addActionListener(this);
            //this.addActionListener(e -> System.out.println(date));
        }
        else{
            emptyButton();
        }
    }

    public void dayButton(){
        setText(String.valueOf(date.getDayOfMonth()));
    }

    public void emptyButton(){
        setOpaque(false);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createEmptyBorder());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //raden nedan kan tas bort, behålller den för att es datumet i konsol
        System.out.println(date);
        // skickar "date" till konstruktor för att kunna hantera spesifikt dam i ActionListener
        DayFrame df = new DayFrame(date);
    }
}
