package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.BasicPID;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskGoToRotation extends AutoTask {
    private Drive m_drive;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_pid;
    public AutoTaskGoToRotation(Drive drive, double targetHeading) {
        m_drive = drive;
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
    }
    @Override
    public void Run() {
        m_currentHeading = m_drive.getHeading();
        m_pid.setPosition(m_currentHeading);
        m_pid.setTarget(m_targetHeading);
        m_drive.setTwist(m_pid.calculateError());
        if(m_pid.getError() < 0.1) {
            m_isComplete = true;
        }
    }
    @Override
    public void OnComplete() {
    }
}
