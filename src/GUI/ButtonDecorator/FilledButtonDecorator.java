package GUI.ButtonDecorator;

import GUI.DayButton;
import java.awt.*;

public class FilledButtonDecorator extends ButtonDecorator {

    public FilledButtonDecorator(DayButton button){
        super(button);
    }

    public void fillButton(){
        button.setBackground(Color.CYAN);
    }
}
