package frc.robot.subsystem;

import frc.robot.biblioteca.RoboBaseClass;
import frc.robot.biblioteca.HuskyColor;
import frc.robot.biblioteca.MotorController;
import frc.robot.biblioteca.ColorInput;

public class ControlPanel extends RoboBaseClass {

    protected MotorController m_MotorController;
    protected ColorInput m_colorSensor;
    private double m_speedOfMotorController;
    private boolean m_isControlled;
    private HuskyColor m_sensedColor;
    private HuskyColor m_targetColor;
    protected double m_colorTolerance;
    private double m_autoMotorControllerSpeed;

    /**
     *
     * @param MotorController the MotorController that moves the robot
     * @param sensor senses color
     * @param tolerance compares color, if the compared color is too different then it's not tolerated and not used
     */
    public ControlPanel() {
        m_autoMotorControllerSpeed = 1;
        m_isControlled = true;
        m_speedOfMotorController = 0;
    }

    /**
     * getting the value of a sensed color
     */
    public void gatherInfo() {
        m_sensedColor = m_colorSensor.getValue();
    }

    /**
     * if the robot is being controlled, use the MotorController to find the correct color
     * if the color that is being sensed is the correct color set MotorController to 1.
     */
    public void doActions() {
        if(m_isControlled){
            m_MotorController.set(m_speedOfMotorController);
        } else {
            if(Math.abs(m_sensedColor.getRed() - m_targetColor.getRed()) > m_colorTolerance &&
                    Math.abs(m_sensedColor.getBlue() - m_targetColor.getBlue()) > m_colorTolerance &&
                    Math.abs(m_sensedColor.getGreen() - m_targetColor.getGreen()) > m_colorTolerance){
                m_MotorController.set(m_autoMotorControllerSpeed);
            }
        }
    }

    /**
     * making the robot move
     * @param speed i.e. "I am speed"
     */
    public void setMotorController(double speed) {
        m_isControlled = true;
        m_speedOfMotorController = speed;
    }

    /**
     * getting a color method
     * @return the color sensed
     */
    public HuskyColor getColor() {
        return m_sensedColor;
    }

    /**
     * takes a color..
     * @param color  ..and sets it
     */
    public void goToColor(HuskyColor color) {
        m_isControlled = false;
        m_targetColor = color;
    }
}
