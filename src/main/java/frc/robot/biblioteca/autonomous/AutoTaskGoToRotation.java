package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.BasicPID;
import frc.robot.biblioteca.HuskyPigeon;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskGoToRotation extends AutoTask {
    private Drive m_drive;
    private HuskyPigeon m_pigeon;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_pid;
    private int m_timeIn;
    public AutoTaskGoToRotation(Drive drive, HuskyPigeon pigeon, double targetHeading) {
        m_drive = drive;
        m_pigeon = pigeon;
        m_targetHeading = targetHeading;
        m_pid = new BasicPID();
        m_pid.setP(RobotConstants.rotateP);
        m_pid.setI(RobotConstants.rotateI);
        m_pid.setD(RobotConstants.rotateD);
        m_pid.setMinOutput(-0.5);
        m_pid.setMaxOutput(0.5);
    }
    @Override
    public void Init() {
        m_isComplete = false;
        m_pigeon.adjustToRange(0);
        m_timeIn = 0;
        System.out.println("Rotating to:"+m_targetHeading);
    }
    @Override
    public void Run() {
        m_pid.setPosition(m_pigeon.getValue().getX());
        m_pid.setTarget(m_targetHeading);
        m_drive.setTwist(m_pid.calculateError());
        if(Math.abs(m_pid.getError()) < RobotConstants.rotateTolerance) {
            m_timeIn ++;
        } else {
            m_timeIn = 0;
        }
        if(m_timeIn > 10) {
            m_isComplete = true;
        }
    }
    @Override
    public void OnComplete() {
        System.out.println("Rotation Complete!");
    }
}
