package frc.robot.subsystem;

import frc.robot.biblioteca.RoboBaseClass;
import frc.robot.biblioteca.HuskyColor;
import frc.robot.biblioteca.Motor;
import frc.robot.biblioteca.ColorInput;

public class ControlPanel extends RoboBaseClass {

    private Motor m_motor;
    private ColorInput m_colorSensor;
    private double m_speedOfMotor;
    private boolean m_isControlled;
    private HuskyColor m_sensedColor;
    private HuskyColor m_targetColor;
    private double m_colorTolerance;
    private double m_autoMotorSpeed;

    /**
     *
     * @param motor the motor that moves the robot
     * @param sensor senses color
     * @param tolerance compares color, if the compared color is too different then it's not tolerated and not used
     */
    public ControlPanel(Motor motor, ColorInput sensor, double tolerance) {
        m_motor = motor;
        m_colorSensor = sensor;
        m_colorTolerance = tolerance;
        m_autoMotorSpeed = 1;
        m_isControlled = true;
        m_speedOfMotor = 0;
    }

    /**
     * getting the value of a sensed color
     */
    public void gatherInfo() {
        m_sensedColor = m_colorSensor.getValue();
    }

    /**
     * if the robot is being controlled, use the motor to find the correct color
     * if the color that is being sensed is the correct color set motor to 1.
     */
    public void doActions() {
        if(m_isControlled){
            m_motor.set(m_speedOfMotor);
        } else {
            if(Math.abs(m_sensedColor.getRed() - m_targetColor.getRed()) > m_colorTolerance &&
                    Math.abs(m_sensedColor.getBlue() - m_targetColor.getBlue()) > m_colorTolerance &&
                    Math.abs(m_sensedColor.getGreen() - m_targetColor.getGreen()) > m_colorTolerance){
                m_motor.set(m_autoMotorSpeed);
            }
        }
    }

    /**
     * making the robot move
     * @param speed i.e. "I am speed"
     */
    public void setMotor(double speed) {
        m_isControlled = true;
        m_speedOfMotor = speed;
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
