package GUI.ButtonDecorator;

import GUI.DayButton;

import javax.swing.border.LineBorder;
import java.awt.*;

public abstract class ButtonDecorator {
    protected DayButton button;
    protected Color color;

    public ButtonDecorator(DayButton button, Color color){
        this.button = button;
        this.color = color;
    }

    public void fillButton(){
        button.setBackground(color);
    }
    public void SetButtonBorderColor(){
        button.setBorder(new LineBorder(color));
    }
}
