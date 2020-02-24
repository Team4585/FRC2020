package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.basesubsystem.Drive;
import frc.robot.RobotConstants;
import frc.robot.Robot;
import frc.robot.biblioteca.*;


public class AutoTaskLimeLightRotate extends AutoTask {
    private Drive m_drive;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_pid;
    private LimeLightCamera m_limeLight;
    public AutoTaskLimeLightRotate() {
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
        m_pid.setPosition(-m_limeLight.getXDistance());
        m_pid.setTarget(0);
        m_drive.setForward(m_pid.calculateError()/3);
        if(m_pid.getError() < 0.1) {
            m_isComplete = true;
        }
    }
    @Override
    public void OnComplete() {
    }

}
