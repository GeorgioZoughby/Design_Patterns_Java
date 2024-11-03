package Implementation_Design_Patterns;

public class Bridge {
    public static void main(String[] args){
        DrawingAPI test1 = new DrawingAPI1();
        DrawingAPI test2 = new DrawingAPI2();
        CircleShape c1 = new CircleShape(test1,2, 2, 2);
        CircleShape c2 = new CircleShape(test2, 3 , 3, 3);
        c1.draw();
        c1.resizeByPercentage(10);
        c2.draw();
        c2.resizeByPercentage(20);


    }
}

interface Shape{
    void resizeByPercentage(double pct);
    void draw();
};

class CircleShape implements Shape{
    private DrawingAPI api;
    private double x, y, radius;
    CircleShape(DrawingAPI api, double x, double y, double radius){
        this.api = api;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    public void draw(){
        api.drawCircle(x,y, radius);
    }
    public void resizeByPercentage(double pct){
        radius *= pct;
    }

};

interface DrawingAPI{
    void drawCircle(double x, double y, double radius);
};

class DrawingAPI1 implements  DrawingAPI{

    public void drawCircle(double x, double y, double radius){
        System.out.println("Drawing from API1");
    }

};

class DrawingAPI2 implements  DrawingAPI{

    public void drawCircle(double x, double y, double radius){
        System.out.println("Drawing from API2");
    }

};



