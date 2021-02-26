package frc.robot;

import frc.robot.biblioteca.HuskyJoystick;

public class NewJoystick
{
    HuskyJoystick m_driveControl;

    public NewJoystick()
    {
        
    }

    public void newJoystickInit()
    {
        m_driveControl = new HuskyJoystick(0);
    }

    public void newJoystickDoActions()
    {
        m_driveControl.getAxis(RobotConstants.forwardAxis);
        m_driveControl.getAxis(RobotConstants.twistAxis); 
        m_driveControl.getAxis(RobotConstants.strafeAxis);
    } 

}