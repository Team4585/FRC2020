package frc.robot.biblioteca;

public class HuskyVector2D {

    private double m_x;
    private double m_y;
    private double m_equalTreshold = 0.0;

    public HuskyVector2D(double InitX, double InitY)
    {
        m_x = InitX;
        m_y = InitY;
    }

    public HuskyVector2D()
    {
        this(0.0, 0.0);
    }

    public HuskyVector2D(HuskyVector2D Orig)
    {
        m_x = Orig.GetX();
        m_y = Orig.GetY();
    }


    public double GetX() { return m_x; }
    public void SetX(double NewX) { m_x = NewX; }
    public double GetY() { return m_y; }
    public void SetY(double NewY) { m_y = NewY; }
    public double GetEqualThreshold() { return m_equalTreshold; }
    public void SetEqualThreshold(double NewThresh) { m_equalTreshold = NewThresh; }

    public void SetVals(double NewX, double NewY)
    {
        SetX(NewX);
        SetY(NewY);
    }

    public void SetVals(HuskyVector2D OtherVec)
    {
        SetX(OtherVec.GetX());
        SetY(OtherVec.GetY());
    }

    public double GetMagnitude()
    {
        return Math.sqrt((m_x * m_x) + (m_y * m_y));
    }

    public void AddVec(HuskyVector2D OtherVec)
    {
        SetX(GetX() + OtherVec.GetX());
        SetY(GetY() + OtherVec.GetY());
    }

    public void SubVec(HuskyVector2D OtherVec)
    {
        SetX(GetX() - OtherVec.GetX());
        SetY(GetY() - OtherVec.GetY());
    }

    public double DistanceTo(HuskyVector2D OtherVec)
    {
        double DeltaX = OtherVec.GetX() - GetX();
        double DeltaY = OtherVec.GetY() - GetY();
        double RawDist = Math.sqrt((DeltaX * DeltaX) + (DeltaY * DeltaY));
        return (RawDist <= m_equalTreshold) ? 0.0 : RawDist;
    }

    public HuskyVector2D VectorTo(HuskyVector2D OtherVec)
    {
        HuskyVector2D WorkVec = new HuskyVector2D(OtherVec);
        WorkVec.SubVec(this);
        return WorkVec;
    }


    // return the angle from the head of the vector to the head of the other vector
    public double AngleTo(HuskyVector2D OtherVec)
    {
        HuskyVector2D WorkVec = VectorTo(OtherVec);
        return Math.toDegrees(Math.atan2(WorkVec.GetX(), WorkVec.GetY()));
    }

    public String toString() {
        return "("+GetX()+", "+GetY()+")";
    }


}
