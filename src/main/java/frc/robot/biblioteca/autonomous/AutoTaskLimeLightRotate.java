package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.basesubsystem.Drive;
import frc.robot.RobotConstants;
import frc.robot.biblioteca.*;


public class AutoTaskLimeLightRotate extends AutoTask {
    private Drive m_drive;
    private double m_currentHeading;
    private double m_targetHeading;
    private BasicPID m_pid;
    private LimeLightCamera m_limeLight;
    private int m_timeIn;
    public AutoTaskLimeLightRotate(Drive drive, LimeLightCamera camera) {
        m_drive = drive;
        m_limeLight = camera;
        m_pid = new BasicPID();
        m_pid.setP(RobotConstants.aimXP);
        m_pid.setI(RobotConstants.aimXI);
        m_pid.setD(RobotConstants.aimXD);
        m_pid.setMinOutput(-0.5);
        m_pid.setMaxOutput(0.5);
    }
    @Override
    public void Init() {
        m_isComplete = false;
        m_timeIn = 0;
    }
    @Override
    public void Run() {
        m_pid.setPosition(m_limeLight.getXDistance());
        m_pid.setTarget(0);
        m_drive.setTwist(m_pid.calculateError());
        if(Math.abs(m_pid.getError()) < RobotConstants.aimXTolerance) {
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
    }

}
