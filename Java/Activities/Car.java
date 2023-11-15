package Activities;

public class Car{

   int  tyres, doors;
   int make;
    String color,transmission;
    Car()
    {
        tyres=4;
        doors=4;
    }
    public void displayCharacteristics()
    {
        System.out.println("Car made in " +make);
        System.out.println("Car color is " +color);
        System.out.println("Car transmission " +transmission);
        System.out.println("Car has " +tyres);
        System.out.println("Car has " +doors);
    }
    public void accelarate()
    {
        System.out.println("Car is moving forward.");
    }
    public void brake()
    {
        System.out.println("Car has stopped.");
    }
}
