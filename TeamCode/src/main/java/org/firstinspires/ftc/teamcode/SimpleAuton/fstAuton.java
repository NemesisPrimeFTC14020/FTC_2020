package org.firstinspires.ftc.teamcode.SimpleAuton;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.BP;

@Autonomous(name = "fstAtn", group = "Linear OpMode")
public class fstAuton extends LinearOpMode {
    public BP bp = new BP();
    @Override
    public void runOpMode() throws InterruptedException {
        bp.HW.initHW(this);
        waitForStart();

// Lv1 Foundation:



//Lv4:
//Move forward x meters
//Collect skystone with claw
//Drive x meters left towards skybridge
//Place on Foundation
//Go back
//Park



    }
}
