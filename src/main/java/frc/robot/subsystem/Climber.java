package frc.robot.subsystem;
import frc.robot.biblioteca.*;
//this class will probably have two victorspx motors
public class Climber extends RoboBaseClass {
    private Motor[] m_railMotors;
    private Motor[] m_traversalMotors;
    private double m_railSpeed;
    private double m_traversalSpeed;
    public Climber(Motor[] railMotors, Motor[] traversalMotors) {
        m_railMotors = railMotors;
        m_traversalMotors = traversalMotors;
    }
    @Override
    public void doActions() {
        for(Motor railMotor : m_railMotors) {
            railMotor.set(m_railSpeed);
        }
        for(Motor traversalMotor : m_traversalMotors) {
            traversalMotor.set(m_traversalSpeed);
        }
    }
    public void move(double speed) {
        m_railSpeed = speed;
    }
    public void traverse(double speed) {
        m_traversalSpeed = speed;
    }
}