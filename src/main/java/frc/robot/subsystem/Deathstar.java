package frc.robot.subsystem;
import frc.robot.biblioteca.*;
import frc.robot.RobotConstants;

public class Deathstar extends Output {
    public Deathstar() {
        super();
        m_shootMotors = new MotorController[] {new SparkMax(RobotConstants.shootLeftPort, true), new SparkMax(RobotConstants.shootRightPort, true), new HuskyVictor(RobotConstants.spinnerPort)};
        m_rotateMotor = new HuskyVictor(RobotConstants.aimPort);
        m_potentiometer = new Potentiometer(RobotConstants.aimPotentiometerPort);
    }
}