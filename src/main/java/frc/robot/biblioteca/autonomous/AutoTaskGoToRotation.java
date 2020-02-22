package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.HuskyVector2D;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskGoToRotation extends AutoTask {
    private Drive m_drive;
    private double m_currentHeading;
    private double m_targetHeading;
    public AutoTaskGoToRotation(double targetHeading) {
        m_targetHeading = targetHeading;
    }
    @Override
    public void Init() {
        isComplete = false;
    }
    @Override
    public void Run() {
        //TODO Change this to PID
        m_currentHeading = m_drive.getHeading();
        m_drive.setTwist(m_currentHeading-m_targetHeading);
    }
    @Override
    public void OnComplete() {
        isComplete = true;
    }
}
