package GUI.ButtonDecorator;

import GUI.DayButton;
import java.awt.*;

public abstract class ButtonDecorator {
    protected DayButton button;

    public ButtonDecorator(DayButton button){
        this.button = button;
        fillButton();
    }

    public void fillButton(){
        button.setBackground(Color.WHITE);
    }
}
