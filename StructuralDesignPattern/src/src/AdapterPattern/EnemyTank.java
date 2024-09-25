package AdapterPattern;

public class EnemyTank implements  EnemyAttacker {
    @Override
    public void driveForward() {
        System.out.println("Enemy Tank drives forward");
    }

    @Override
    public void fireWeapon() {
        System.out.println("Enemy Tank fires...");
    }
}
