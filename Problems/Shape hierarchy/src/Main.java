abstract class Shape {

    abstract double getPerimeter();

    abstract double getArea();
}

class Triangle extends Shape {

    protected double a;
    protected double b;
    protected double c;

    Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    double getPerimeter() {
        return a + b + c;
    }

    @Override
    double getArea() {

        double s = (a + b + c) / 2;

        return Math.sqrt((s * (s - a) * (s - b) * (s - c)));
    }
}

class Rectangle extends Shape {

    protected double a;
    protected double b;

    Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    double getPerimeter() {
        return (a + b) * 2;
    }

    @Override
    double getArea() {
        return a * b;
    }
}

class Circle extends Shape {

    protected double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double getPerimeter() {
        return radius * 2 * Math.PI;
    }

    @Override
    double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}