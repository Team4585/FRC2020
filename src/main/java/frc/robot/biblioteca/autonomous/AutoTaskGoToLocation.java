package frc.robot.biblioteca.autonomous;

import frc.robot.biblioteca.HuskyVector2D;
import frc.robot.biblioteca.basesubsystem.Drive;

public class AutoTaskGoToLocation extends AutoTask {
    private Drive m_drive;
    private HuskyVector2D m_currentPosition;
    private HuskyVector2D m_targetPosition;
    private double m_currentHeading;
    private double m_targetHeading;
    public AutoTaskGoToLocation(HuskyVector2D targetPosition) {
        m_targetPosition = targetPosition;
    }
    @Override
    public void Init() {
        isComplete = false;
    }
    @Override
    public void Run() {
        //TODO Change this to PID
        m_currentPosition.SetVals(m_drive.getLoc());
        m_currentHeading = m_drive.getHeading();

        m_drive.setTwist(m_currentHeading-m_targetHeading);
        if(Math.abs(m_currentHeading-m_targetHeading) < 0.1) {
            m_drive.setForward(0.5);
        }
    }
    @Override
    public void OnComplete() {
        isComplete = true;
    }
}
