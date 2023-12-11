package GUI;

import GUI.ButtonDecorator.ButtonDecorator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class DayButton extends JButton implements ActionListener {

    boolean filled;
    LocalDate date;
    ButtonDecorator buttonDecorator;

    public DayButton(LocalDate date, boolean filled, ButtonDecorator buttonDecorator){
        this.filled = filled;
        this.date = date;
        this.buttonDecorator = buttonDecorator;
        buildButton();
    }

    public DayButton(LocalDate date, boolean filled){
        this.filled = filled;
        this.date = date;
        buildButton();
    }

    public void buildButton(){
        if(filled){
            if(date.equals(LocalDate.now())){
                setBackground(Color.green);
            }
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
        //System.out.println(date);
        AnnotationSelection as = new AnnotationSelection(date);

        //DayFrame df = new DayFrame(date);
    }

    public LocalDate getDate() {
        return date;
    }
}
