package frc.robot.subsystem;

import frc.robot.biblioteca.*;
//use HuskyVictor, Solenoid, and LightSensor

public class Intake extends RoboBaseClass {
    private int totalIn;
    protected MotorController[] m_intakeMotors;
    protected MotorController[] m_helixMotors;
    protected HuskySolenoid m_activator;

    private double m_intakeSpeed;
    private double m_helixSpeed;
    private boolean m_activated;
    private boolean m_piston;
    public void gatherInfo() {
        
    }
    public void doActions() {
        if(m_activated && m_piston) {
            for(MotorController intakeMotor : m_intakeMotors) {
                intakeMotor.setValue(m_intakeSpeed);
            }
        } else {
            for(MotorController intakeMotor : m_intakeMotors) {
                intakeMotor.setValue(0);
            }
        }
        for(MotorController helixMotor : m_helixMotors) {
            helixMotor.setValue(m_helixSpeed);
        }
        m_activator.setValue(m_piston);
    }
    public void intake(double intakeSpeed, double helixSpeed) {
        m_intakeSpeed = intakeSpeed;
        m_helixSpeed = helixSpeed;
    }
    public void activatePiston(boolean up) {
        m_piston = up;
    }
    public int getTotalIn() {
        return totalIn;
    }
}
