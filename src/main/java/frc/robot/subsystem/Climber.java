package frc.robot.subsystem;
import frc.robot.biblioteca.*;
//this class will probably have two victorspx MotorControllers
public class Climber extends RoboBaseClass {
    private MotorController[] m_railMotorControllers;
    private MotorController[] m_traversalMotorControllers;
    private double m_railSpeed;
    private double m_traversalSpeed;
    public Climber(MotorController[] railMotorControllers, MotorController[] traversalMotorControllers) {
        m_railMotorControllers = railMotorControllers;
        m_traversalMotorControllers = traversalMotorControllers;
    }
    @Override
    public void doActions() {
        for(MotorController railMotorController : m_railMotorControllers) {
            railMotorController.set(m_railSpeed);
        }
        for(MotorController traversalMotorController : m_traversalMotorControllers) {
            traversalMotorController.set(m_traversalSpeed);
        }
    }
    public void move(double speed) {
        m_railSpeed = speed;
    }
    public void traverse(double speed) {
        m_traversalSpeed = speed;
    }
}