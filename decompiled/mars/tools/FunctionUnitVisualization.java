package mars.tools;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FunctionUnitVisualization extends JFrame {

    private final JPanel contentPane;
    private final String instruction;
    private final int register = 1;
    private final int control = 2;
    private final int aluControl = 3;
    private final int alu = 4;
    private int currentUnit;

    /**
     * Launch the application.
     */


    /**
     * Create the frame.
     */
    public FunctionUnitVisualization(String instruction, int functionalUnit) {
        this.instruction = instruction;
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 840, 575);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        if (functionalUnit == register) {
            currentUnit = register;
            UnitAnimation reg = new UnitAnimation(instruction, register);
            contentPane.add(reg);
            reg.startAnimation(instruction);
        } else if (functionalUnit == control) {
            currentUnit = control;
            UnitAnimation reg = new UnitAnimation(instruction, control);
            contentPane.add(reg);
            reg.startAnimation(instruction);
        } else if (functionalUnit == aluControl) {
            currentUnit = aluControl;
            UnitAnimation reg = new UnitAnimation(instruction, aluControl);
            contentPane.add(reg);
            reg.startAnimation(instruction);
        }

    }

    public void run() {
        try {
            FunctionUnitVisualization frame = new FunctionUnitVisualization(instruction, currentUnit);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
