import java.util.Collections;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        // implicit casting
        Shapes myTriangle = new Triangle(2, 3, 4, "yellow", true);
        Shapes mySquare = new Square(4, "black", false);
        Shapes myCircle = new Circle(2);

        // method from IDataBase
        myTriangle.welcome();

        // works on Cloneable Interface
        Object clone = myCircle.clone();

        displayObject(myTriangle);
        displayObject(mySquare);
        displayObject(clone);

        // works on Comparable<> Interface
        Collections.shuffle(Shapes.getArrayList());
    }

    // polymorphism
    public static void displayObject(Object object) {
        if (object instanceof Shapes) {
            System.out.println((object.toString()));
        }
    }
}
