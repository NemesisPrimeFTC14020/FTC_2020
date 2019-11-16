package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "Level2FoundationBlue", group = "Linear OpMode")
public class Level2FoundationBlue extends LinearOpMode {
    public BP bp = new BP();

    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();
        int forwarddis = 34;
        int resistance = 10;
        int backwarddis = -1 * (forwarddis + resistance);
        //Lv2:
        /*bp.encDriveFin(1, 29, this);
        bp.curveClaw(0);
        sleep(2000);
        bp.encDriveFin(1, -30, this);
        bp.curveClaw(0.5);
        sleep(2000);
        bp.encDriveSin(1, -26.25, this);
        bp.curveClaw(0.25);
        sleep(2000);
        bp.encDriveSin(1, -50.75, this);
        */
        // moves left 12 in
        bp.encDriveSin(1, -12, this);
        // elevator up 2.5 in
        bp.yClawTime('+', 2.5, this);
        // moves forward 34 in
        bp.encDriveFin(1, forwarddis, this);
        // elevator down 2.5 in
        bp.yClawTime('-', 2.5, this);
        // moves backward 28 in
        bp.encDriveFin(1, backwarddis, this);
        // elevator up 2 in
        bp.yClawTime('+', 2, this);
        // moves right 48 in
        bp.encDriveSin(1, 48, this);
        bp.encDriveFin(1, 24, this);

    }
}