package GUI.ButtonDecorator;

import GUI.DayButton;

import java.awt.*;

public class RedButtonDecorator extends ButtonDecorator {
    public RedButtonDecorator(DayButton button){
        super(button, Color.RED);
    }
}
