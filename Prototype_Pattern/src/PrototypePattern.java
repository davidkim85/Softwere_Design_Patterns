/*The prototype pattern is a creational design pattern in software development.
It is used when the type of objects to create is determined by a prototypical
instance, which is cloned to produce new objects.*/
import java.util.Random;
abstract class BasicCar implements Cloneable
{
    public String modelName;
    public int basePrice,onRoadPrice;
    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelname) {
        this.modelName = modelname;
    }
    public static int setAdditionalPrice()
    {
        int price = 0;
        Random r = new Random();
//We will get an integer value in the range 0 to 100000
        int p = r.nextInt(100000);
        price = p;
        return price;
    }
    public BasicCar clone() throws CloneNotSupportedException
    {
        return (BasicCar)super.clone();
    }
}

class Nano extends BasicCar
{
    //A base price for Nano
    public int basePrice=100000;
    public Nano(String m)
    {
        modelName = m;
    }
    @Override
    public BasicCar clone() throws CloneNotSupportedException
    {
        return (Nano)super.clone();
    }
}

class Ford extends BasicCar
{
    //A base price for Ford
    public int basePrice=100000;
    public Ford(String m)
    {
        modelName = m;
    }
    @Override
    public BasicCar clone() throws CloneNotSupportedException
    {
        return (Ford)super.clone();
    }
}
public class PrototypePattern {
    public static void main(String[] args) throws
            CloneNotSupportedException
    {
        System.out.println("***Prototype Pattern Demo***\n");
        BasicCar nano = new Nano("Green Nano") ;
        nano.basePrice=100000;
        BasicCar ford = new Ford("Ford Yellow");
        ford.basePrice=500000;
        BasicCar bc1;
//Nano
        bc1 =nano.clone();
//Price will be more than 100000 for sure
        bc1.onRoadPrice = nano.basePrice+BasicCar.setAdditionalPrice();
        System.out.println("Car is: "+ bc1.modelName+" and it's price is Rs."+bc1.onRoadPrice);
//Ford
                bc1 =ford.clone();
//Price will be more than 500000 for sure
        bc1.onRoadPrice = ford.basePrice+BasicCar.setAdditionalPrice();
        System.out.println("Car is: "+ bc1.modelName+" and it's price is Rs."+bc1.onRoadPrice);
    }
}
//Client
// PrototypePatternExample.java