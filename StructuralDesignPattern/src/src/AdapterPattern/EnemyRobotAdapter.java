package AdapterPattern;

public class EnemyRobotAdapter implements EnemyAttacker {
    EnemyRobot enemyRobot;
    public EnemyRobotAdapter(EnemyRobot enemyRobot) {
        this.enemyRobot = enemyRobot;
    }

    public void driveForward() {
        enemyRobot.walkForward();
    }

    public void fireWeapon() {
        enemyRobot.smashWithHands();
    }
}
