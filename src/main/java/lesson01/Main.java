package lesson01;
/*
1. Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).
2. Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).
3. Создайте два массива​: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий.
4. * У препятствий есть длина (для дорожки) или высота (для стены), а ​участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
 */

import static java.lang.String.format;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== Home Work 01 =====");
        String HumanName[] = {"Алексей", "Генри", "Владимир", "Михаил", "Николай", "Эдуард", "Иван", "Петр", "Сергей"};
        String CatName[] = {"Барсик", "Гарфилд", "Дымок", "Изюм", "Кекс", "Котик", "Мурзик", "Перси", "Снехок"};
        String RobotName[] = {"Железка", "Вердер", "Ржпвый", "Хром", "Р2Д2", "3-пиО", "Бендер", "Глот", "Робот"};

//        Humans man1 = new Humans("Иван", 1f, 100);
//        Cats cat1 = new Cats("Барсик", 1.5f, 50);
//        Robots robot1 = new Robots("Вертер", 3f, 1000);
//        Treadmill treadmill1 = new Treadmill(100);
//        Walls wall1 = new Walls(2.5f);
//
//        man1.getInfo();
//        cat1.getInfo();
//        robot1.getInfo();
//
//        System.out.println(treadmill1);
//        System.out.println(wall1);
//
//        man1.doRunThrough(treadmill1);
//        man1.doJumpOver(wall1);
//        cat1.doRunThrough(treadmill1);
//        cat1.doJumpOver(wall1);
//        robot1.doRunThrough(treadmill1);
//        robot1.doJumpOver(wall1);
//

        System.out.println("--------------------------------------");
        Object[] team = new Object[(int) (Math.random() * 6 + 3)];
        for (int i = 0; i < team.length; i++) {
            switch ((int) (Math.random() * 10) % 3) {
                case 0: {
//                    Humans m = new Humans(format("Человек(%d)", i), (float) (Math.random() * 3), (int) (Math.random() * 1000));
                    Humans m = new Humans(HumanName[(int) (Math.random()*9)], (float) (Math.random() * 3), (int) (Math.random() * 1000));
                    team[i] = m;
                    break;
                }
                case 1: {
//                    Cats m = new Cats(format("Кот(%d)", i), (float) (Math.random() * 2), (int) (Math.random() * 1000));
                    Cats m = new Cats(CatName[(int) (Math.random()*9)], (float) (Math.random() * 2), (int) (Math.random() * 1000));
                    team[i] = m;
                    break;
                }
                case 2: {
//                    Robots m = new Robots(format("Робот(%d)", i), (float) (Math.random() * 5), (int) (Math.random() * 1000));
                    Robots m = new Robots(RobotName[(int) (Math.random()*9)], (float) (Math.random() * 5), (int) (Math.random() * 1000));
                    team[i] = m;
                    break;
                }
            }

        }
        for (Object obj : team) {
            if (Humans.class.equals(obj.getClass())) {
                Humans h = ((Humans) obj);
                h.getInfo();
            }
            if (Cats.class.equals(obj.getClass())) {
                Cats c = ((Cats) obj);
                c.getInfo();
            }
            if (Robots.class.equals(obj.getClass())) {
                Robots r = ((Robots) obj);
                r.getInfo();
            }
        }

        System.out.println("--------------------------------------");
        Object[] obstacleCourse = new Object[(int) (Math.random() * 5 + 3)];
        for (int i = 0; i < obstacleCourse.length; i++) {
            switch ((int) ((Math.random() * 20) % 2)) {
                case 0: {
                    Treadmill tr = new Treadmill((int) (Math.random() * 1000));
                    obstacleCourse[i] = tr;
                    break;
                }
                case 1: {
                    Walls wl = new Walls((float) (Math.random() * 2));
                    obstacleCourse[i] = wl;
                    break;
                }
            }
        }
        for (Object obj : obstacleCourse) {
            if (Walls.class.equals(obj.getClass())) {
                Walls w = ((Walls) obj);
                w.getInfo();
            }
            if (Treadmill.class.equals(obj.getClass())) {
                Treadmill t = ((Treadmill) obj);
                t.getInfo();
            }
        }

        for (Object teamUnit : team) {
            System.out.println("--------------------------------------");
            if (Humans.class.equals(teamUnit.getClass())) {
                Humans unitHuman = ((Humans) teamUnit);
                System.out.println(unitHuman + ">>");
                for (Object dist : obstacleCourse) {
                    if (unitHuman.isDoContinue()) {
                        if (Walls.class.equals(dist.getClass())) {
                            Walls w = ((Walls) dist);
                            unitHuman.doJumpOver(w);
                        } else if (Treadmill.class.equals(dist.getClass())) {
                            Treadmill r = ((Treadmill) dist);
                            unitHuman.doRunThrough(r);
                        }
                    } else {
                        break;
                    }
                }
                if (unitHuman.isDoContinue()) {
                    System.out.println("** " + unitHuman + " Финишировал");
                } else {
                    System.out.println("## " + unitHuman + " сошел с дистацниции");
                }
            } else if (Cats.class.equals((teamUnit.getClass()))) {
                Cats unitCat = ((Cats) teamUnit);
                for (Object dist : obstacleCourse) {
                    if (unitCat.isDoContinue()) {
                        if (Walls.class.equals(dist.getClass())) {
                            Walls w = ((Walls) dist);
                            unitCat.doJumpOver(w);
                        } else if (Treadmill.class.equals(dist.getClass())) {
                            Treadmill r = ((Treadmill) dist);
                            unitCat.doRunThrough(r);
                        }
                    } else {
                        break;
                    }
                }
                if (unitCat.isDoContinue()) {
                    System.out.println("** " + unitCat + " Финишировал");
                } else {
                    System.out.println("## " + unitCat + " сошел с дистацниции");
                }
            } else if (Robots.class.equals(teamUnit.getClass())) {
                Robots unitRobot = ((Robots) teamUnit);
                for (Object dist : obstacleCourse) {
                    if (unitRobot.isDoContinue()) {
                        if (Walls.class.equals(dist.getClass())) {
                            Walls w = ((Walls) dist);
                            unitRobot.doJumpOver(w);
                        } else if (Treadmill.class.equals(dist.getClass())) {
                            Treadmill r = ((Treadmill) dist);
                            unitRobot.doRunThrough(r);
                        }
                    } else {
                        break;
                    }
                }
                if (unitRobot.isDoContinue()) {
                    System.out.println("** " + unitRobot + " Финишировал");
                } else {
                    System.out.println("## " + unitRobot + " сошел с дистацниции");
                }
            }
        }

        System.out.println("--------------------------------------");
    }
}
