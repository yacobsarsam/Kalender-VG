package GUI;

import javax.swing.*;
import java.time.LocalDate;

public class DayButton extends JButton {

    boolean currentMonth;
    LocalDate date;

    public DayButton(LocalDate date){
        currentMonth = true;
        this.date = date;
        buildButton();
    }

    public void buildButton(){
        if(currentMonth){
            dayButton();
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
    }
}
