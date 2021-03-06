import java.util.ArrayList;
import java.util.Objects;

public abstract class Shapes implements Comparable<Shapes>, Cloneable, IDataBase {
    protected static ArrayList<Object> stack = new ArrayList<>();
    protected static int numberOfShapes;
    protected java.util.Date dateCreated;
    protected boolean isFilled;
    protected double area;
    protected double perimeter;
    protected String color;

    protected Shapes() {
        this("transparent", false);
    }

    protected Shapes(String color, Boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
        dateCreated = new java.util.Date();
        numberOfShapes++;
    }

    // accessors
    public static int getNumberOfShapes() {
        return numberOfShapes;
    }

    public static ArrayList<Object> getArrayList() {
        return stack;
    }

    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColor() {
        return color;
    }

    // mutators
    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setIsFilled(boolean status) {
        isFilled = status;
    }

    @Override
    public String toString() {
        return "Shapes{" +
                "dateCreated=" + getDateCreated() +
                ", isFilled=" + isFilled +
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                ", color='" + getColor() + '\'' +
                '}';
    }

    @Override
    public abstract boolean equals(Object o);

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Triangle extends Shapes {
    private final double side1;
    private final double side2;
    private final double side3;

    Triangle() {
        this(1, 1, 1);
    }

    public Triangle(double s1, double s2, double s3) {
        side1 = s1;
        side2 = s2;
        side3 = s3;
        stack.add(this);
    }

    public Triangle(double s1, double s2, double s3, String color, Boolean isFilled) {
        super(color, isFilled);
        side1 = s1;
        side2 = s2;
        side3 = s3;
        stack.add(this);
    }

    @Override
    public double getArea() {
        double s = (side1 + side2 + side3) / 2;
        this.area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = side1 + side2 + side3;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "side1=" + side1 +
                ", side2=" + side2 +
                ", side3=" + side3 +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side1, side1) == 0 && Double.compare(triangle.side2, side2) == 0 && Double.compare(triangle.side3, side3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side1, side2, side3);
    }

    @Override
    public int compareTo(Shapes o) {
        if (this.getArea() > o.getArea()) return 1;
        else if (this.getArea() > o.getArea()) return -1;
        else return 0;
    }

    @Override
    public void nothing() {

    }
}

class Square extends Shapes {
    private final double sides;

    Square() {
        this(1);
    }

    Square(double sides) {
        this.sides = sides;
        stack.add(this);
    }

    Square(double sides, String color, Boolean isFilled) {
        super(color, isFilled);
        this.sides = sides;
        stack.add(this);
    }

    @Override
    public double getArea() {
        this.area = sides * sides;
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 4 * sides;
        return perimeter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Square)) return false;
        Square square = (Square) o;
        return Double.compare(square.sides, sides) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sides);
    }

    @Override
    public String toString() {
        return "Square{" +
                "sides=" + sides +
                "} " + super.toString();
    }

    @Override
    public int compareTo(Shapes o) {
        if (this.getArea() > o.getArea()) return 1;
        else if (this.getArea() > o.getArea()) return -1;
        else return 0;
    }

    @Override
    public void nothing() {

    }
}


class Circle extends Shapes {
    private final double radius;

    Circle() {
        this(1);
    }

    Circle(double radius) {
        this.radius = radius;
        stack.add(this);
    }

    Circle(double radius, String color, Boolean isFilled) {
        super(color, isFilled);
        this.radius = radius;
        stack.add(this);
    }

    @Override
    public double getArea() {
        this.area = Math.PI * Math.pow(radius, 2);
        return area;
    }

    @Override
    public double getPerimeter() {
        perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Double.compare(circle.radius, radius) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    @Override
    public int compareTo(Shapes o) {
        if (this.getArea() > o.getArea()) return 1;
        else if (this.getArea() > o.getArea()) return -1;
        else return 0;
    }

    @Override
    public void nothing() {

    }
}