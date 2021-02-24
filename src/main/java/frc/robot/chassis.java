/*----------------------------------------------------------------------------*/
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.biblioteca.basesubsystem.MecanumDrive;
import frc.robot.biblioteca.HuskyTalon;

public class chassis
{
    MecanumDrive m_driveTrain;
   
    HuskyTalon front_left;
    HuskyTalon back_left;
    HuskyTalon front_right;
    HuskyTalon back_right;

    double forwardVal = 0.0;
    double twistVal = 0.0;
    double strafeVal = 0.0;

    public chassis()
    {

    }

    public void chassisInit()
    {
        m_driveTrain = new MecanumDrive(front_left, front_right, back_left, back_right);

    }

    public void chassisDoActions()
    {
        m_driveTrain.setForward(forwardVal);
        m_driveTrain.setTwist(twistVal);
        m_driveTrain.setStrafe(strafeVal);
    }

    public void setVals(double forward, double twist, double strafe)
    {
        forwardVal = forward;
        twistVal = twist;
        strafeVal = strafe;
    }
}
