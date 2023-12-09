package GUI;

import javax.swing.*;
import java.time.LocalDate;

public class DayButton extends JButton {

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
            this.addActionListener(e -> System.out.println(date));
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

}
