package Implementation_Design_Patterns;

public class Decorator {
    public static void main(String args[]) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}


abstract class Beverage{
    String description;

    Beverage(){
        this.description = "Beverage";
    }

    Beverage(String desc){
        this.description = desc;
    }

    String getDescription(){
        return description;
    }

    abstract double cost();
};

class HouseBlend extends Beverage{
    HouseBlend(){
        super("HouseBlend");
    }
    public double cost(){
        return 0.8;
    }
};

class DarkRoast extends Beverage{
    DarkRoast(){
        super("DarkRoast");
    }
    public double cost(){
        return 1.0;
    }
};

class Espresso extends Beverage{
    Espresso(){
        super("Espresso");
    }
    public double cost(){
        return 3.0;
    }
};

class Decaf extends Beverage{
    Decaf(){
        super("Decaf");
    }
    public double cost(){
        return 2.0;
    }
};

abstract class CondimentDecorator extends Beverage {
    Beverage bev;
    abstract String getDescription();
};

class Milk extends CondimentDecorator{
    Beverage bev;

    double cost(){
        return bev.cost() + 0.5;
    }

    String getDescription(){
        return bev.description + ",Milk";
    }
};

class Mocha extends CondimentDecorator{
    Beverage bev;

    Mocha(Beverage bev){
        this.bev = bev;
    }
    double cost(){
        return bev.cost() + 0.6;
    }

    String getDescription(){
        return bev.getDescription() + ",Mocha";
    }
};

class Soy extends CondimentDecorator{
    Beverage bev;

    Soy(Beverage bev){
        this.bev = bev;
    }

    double cost(){
        return bev.cost() + 3.0;
    }

    String getDescription(){
        return bev.getDescription() + ",Soy";
    }
};

class Whip extends CondimentDecorator{
    Beverage bev;

    Whip(Beverage bev){
        this.bev = bev;
    }
    double cost(){
        return bev.cost() + 1.0;
    }

    String getDescription(){
        return bev.getDescription() + ",Whip";
    }
};

