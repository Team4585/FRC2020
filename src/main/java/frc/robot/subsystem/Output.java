package frc.robot.subsystem;
import frc.robot.biblioteca.*;
import frc.robot.biblioteca.basesubsystem.*;

public class Output extends Turret {
    protected MotorController[] m_shootMotors;
    protected MotorController m_rotateMotor;
    protected Potentiometer m_potentiometer;
    public Output() {
        super(0, 0, 0, 45, true);
    }
    public void gatherInfo() {
        setCurrentX(0);
        setCurrentY(m_potentiometer.getValue());
    }
    public void shoot(double velocity) {
        for (MotorController shootMotor : m_shootMotors) {
            shootMotor.set(velocity);
        }
    }
    public void rotateX(double x) {
    }
    public void rotateY(double y) {
        m_rotateMotor.set(y);
    }
}