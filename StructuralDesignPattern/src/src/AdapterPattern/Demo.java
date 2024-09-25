package AdapterPattern;

public class Demo {
    public static void main(String[] args) {
        System.out.println("-- Adapter Pattern -----");
        EnemyTank rx7Tank = new EnemyTank();
        EnemyRobot robo = new EnemyRobot();
        EnemyRobotAdapter adapterRobot = new EnemyRobotAdapter(robo);

        System.out.println("-- Enemy Tank---");
        rx7Tank.driveForward();
        rx7Tank.fireWeapon();

        System.out.println("-- Robot Enemy ---");
        robo.walkForward();
        robo.smashWithHands();

        System.out.println("--- Adapter ----");
        System.out.println(" the adapter has method of the class to which client talks ie. EnemyTank but implements like Adaptee(EnemyRobot)");
        System.out.println("-- driveForward() --- fireWeapon()");
        adapterRobot.driveForward();
        adapterRobot.fireWeapon();

    }
}
