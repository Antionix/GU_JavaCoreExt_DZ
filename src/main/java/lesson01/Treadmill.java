package lesson01;

import static java.lang.String.format;

public class Treadmill implements Information{
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return format("Беговая дорожка %d м", length);
    }

    public int getLength() {
        return length;
    }

//    public void setLength(int length) {
//        this.length = length;
//    }

    public void toMake(RunThrough runThrough) {
        System.out.println();
    }

    @Override
    public void getInfo() {
        System.out.println(this);
    }

    @Override
    public boolean isDoContinue() {
        return true;
    }
}
