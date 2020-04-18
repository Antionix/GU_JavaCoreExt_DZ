package lesson01;

import static java.lang.String.format;

public class Walls implements Information {
    private float height;

    public Walls(float height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return format("Стена высотой %.2f м", height);
    }

    public float getHeight() {
        return height;
    }

    @Override
    public void getInfo() {
        System.out.println(this);
    }

    @Override
    public boolean isDoContinue() {
        return true;
    }

//    public void setHeight(float height) {
//        this.height = height;
//    }
}
