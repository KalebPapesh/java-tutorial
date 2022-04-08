class Dog {

    protected String name;
    protected int age;

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void speak() {
        System.out.println("hello I am a dog named " + this.name + " and I am " + this.age + " years old");
    }

    public String toString() {
        return "Dog(" + this.name + ")";
    }

    public String getName() {
        return this.name;
    }

    public int setAge(int age) {
        this.age = age;
        return this.age;
    }

    public int getAge() {
        return this.age;
    }
}

class Cat extends Dog {

    private int food;

    public Cat(String name, int age, int food) {
        super(name, age);
        this.food = food;
    }

    public void speak() {
        System.out.println("meow my name is " + this.name + " and I'm " + this.age + "and I eat " + this.food);
    }

    public String toString() {
        return "Cat("+ this.name +")";
    }
}

class OuterClass {
    private class InnerClass {
        public void display() {
            System.out.println("This is an inner class");
        }
    }

    public class AnotherInnerClass {
        public void display() {
            System.out.println("this is another inner class");
        }
    }

    public void inner() {
        InnerClass in = new InnerClass();
        in.display();
    }

    public void methodWithClass() {
        class InnerClassAgain {
            public void displayInside() {
                System.out.println("this is a class inside a method");
            }
        }

        // must create an instance of an object and call the method within that instance inside the method
        InnerClassAgain in = new InnerClassAgain();
        in.displayInside();
    }
}

interface Vehicle {

    // these variables inside interfaces MUST be declared as final
    // these variables are also known as "attributes" (this goes for all classes/interfaces)
    final int gears = 5;

    void speedUp(int a);
    void slowDown(int a);
    void changeGear(int a);

    // this allows you to use this method for all classes that inherit this interface
    default void out() {
        System.out.println("Default method");
    }

    default void anotherOut() {
        System.out.println("another default method");
    }

    static int math(int b) {
        return b + 9;
    }
}

class Car implements Vehicle {
    private int gear = 1;
    private int speed = 0;

    public void speedUp(int change) {
        this.speed += change;
    }

    public void slowDown(int change) {
        this.speed -= change;
    }

    public void changeGear(int gears) {
        this.gear = gear;
    }

    public void display() {
        System.out.println("I am a car, going " + this.speed);
        System.out.println("I am in gear: " + this.gear);

        // you can call default methods inside the classes that inherit them
        anotherOut();
    }
}

// just like classes, if you were to create a separate file, you need to declare this as public
enum Level {
    HIGH(3),
    MEDIUM(2),
    LOW(1);

    private int lvlNum;

    // this is a private constructor to the enums
    private Level(int num) {
        this.lvlNum = num;
    }

    public int getLvl() {
        return this.lvlNum;
    }

    public void setLvl(int lvl) {
        this.lvlNum = lvl;
    }
}

public class JavaTutorial {

    public static void main(String []args) {
        Dog test = new Dog("test", 39);
        test.speak();
        Dog flynn = new Dog("flynn", 3);
        flynn.speak();

        String dogName = flynn.getName();
        int dogAge = flynn.setAge(4);
        flynn.speak();

        System.out.println(dogName);
        System.out.println(dogAge);

        System.out.println(test);

        Cat monty = new Cat("monty", 7, 100);
        monty.speak();
        System.out.println(monty);

        OuterClass out = new OuterClass();
        out.inner();
        OuterClass.AnotherInnerClass another = out.new AnotherInnerClass();
        another.display();

        out.methodWithClass();

        Car car = new Car();
        car.speedUp(8);
        car.display();
        car.out();

        int x = Vehicle.math(5);
        System.out.println(x);

        // enums are persistent constants
        Level lvl = Level.LOW;
        String en = lvl.toString();

        Level[] arr = Level.values();

        for (Level e : arr) {
            System.out.println(e);
        }

        System.out.println(Level.values());

        if (lvl == Level.LOW) {
            System.out.println(lvl);
        } else if (lvl == Level.MEDIUM) {
            System.out.println(lvl);
        } else {
            System.out.println(lvl);
        }

        int y = lvl.getLvl();
        System.out.println(y);

        lvl.setLvl(4);
        int z = lvl.getLvl();
        System.out.println(z);

        System.out.println(Level.valueOf("LOW"));
    }
}
