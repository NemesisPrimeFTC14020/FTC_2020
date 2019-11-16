package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "Level1FoundationRed", group = "Linear OpMode")
public class Level1FoundationRed extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        //Lv1:
        bp.curveClaw(0);
        sleep(1000);
        //Move sideways 9 inches
        bp.encDriveSin(1, 9, this);
    }
}