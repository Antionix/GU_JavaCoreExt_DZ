package lesson01;

public class Robots implements JumpOver, RunThrough, Information {
    private String name;
    private boolean doContinue = true;
    private float maxHeight;
    private int maxRun;

    public Robots(String name, float maxHeight, int maxRun) {
        this.name = name;
        this.maxHeight = maxHeight;
        this.maxRun = maxRun;
    }

    @Override
    public String toString() {
        return "Робот " + name;
    }

    public void getInfo() {
        System.out.printf("%s может пробежать не более %d м и перепрыгнуть препятсвие высотой до %.1f м\n", this, maxRun, maxHeight);
    }

    public void run() {
        System.out.println(this + " бегает");
    }

    public void jump() {
        System.out.println(this + " прыгает");
    }

    @Override
    public void doJumpOver(Walls w) {
        if (w.getHeight() > maxHeight) {
            System.out.println(this + " не смог перепрыгнуть стену.");
            doContinue = false;
        } else {
            System.out.println(this + " смог перепрыгнуть стену.");
        }
    }

    @Override
    public void doRunThrough(Treadmill distance) {
        if (distance.getLength() > maxRun) {
            doContinue = false;
            System.out.println(this + " не смог пробежать дистанцию.");
        } else {
            System.out.println(this + " смог пробежать дистанцию.");
        }
    }

    public boolean isDoContinue() {
        return doContinue;
    }
}
