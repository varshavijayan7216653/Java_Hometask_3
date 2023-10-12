import java.util.Arrays;

abstract class Engine {
    String eng_typ;

    Engine(String eng_typ) {
        this.eng_typ = eng_typ;
    }
}

class CombustionEngine extends Engine {
    String gas_typ;

    CombustionEngine(String gas_typ) {
        super("Combustion Engine");
        this.gas_typ = gas_typ;
    }

    public String toString() {
        return "Engine Type: " + eng_typ + ", Gas Type: " + gas_typ;
    }
}

class ElectricEngine extends Engine {
    String battery_typ;

    ElectricEngine(String battery_typ) {
        super("Electric Engine");
        this.battery_typ = battery_typ;
    }

    public String toString() {
        return "Engine Type: " + eng_typ + ", Battery Type: " + battery_typ;
    }
}

class HybridEngine extends Engine {
    String gas_typ;
    String battery_typ;

    HybridEngine(String gas_typ, String battery_typ) {
        super("Hybrid Engine");
        this.gas_typ = gas_typ;
        this.battery_typ = battery_typ;
    }

    public String toString() {
        return "Engine Type: " + eng_typ + ", Gas Type: " + gas_typ + ", Battery Type: " + battery_typ;
    }
}

class Manufacture {
    String makers;
    String model;
    String color;

    Manufacture(String makers, String model,String color) {
        this.makers = makers;
        this.model = model;
        this.color=color;
    }

    public String getmakers() {
        return makers;
    }

    public void setmakers(String makers) {
        this.makers = makers;
    }

    public String getmodel() {
        return model;
    }

    public void setmodel(String model) {
        this.model = model;
    }
    public String getcolor() {
        return color;
    }

    public void setcolor(String color) {
        this.color = color;
    }
}

abstract class Vehicle {
    Manufacture makers;
    Manufacture model;
    Manufacture color;
    Engine engine;

    Vehicle(Manufacture makers,Manufacture model,Manufacture color,Engine engine) {
        this.makers = makers;
        this.model = model;
        this.color = color;
        this.engine = engine;
    }

    abstract void ShowCharacteristics();
}

class ICEV extends Vehicle {
    ICEV(Manufacture makers,Manufacture model,Manufacture color,Engine engine) {
        super(makers,model,color,engine);
    }

    void ShowCharacteristics() {
        System.out.println("Car Makers: " + makers.getmakers() + ", Model: " + model.getmodel()+", Color: " + color.getcolor());
        System.out.println(engine);
    }
}

class BEV extends Vehicle {
    BEV(Manufacture makers,Manufacture model,Manufacture color,Engine engine) {
        super(makers,model,color,engine);
    }

    void ShowCharacteristics() {
        System.out.println("Car Makers: " + makers.getmakers() + ", Model: " + model.getmodel()+", Color: " + color.getcolor());
        System.out.println(engine);
    }
}

class HybridV extends Vehicle {
    HybridV(Manufacture makers,Manufacture model,Manufacture color,Engine engine) {
        super(makers,model,color,engine);
    }

    void ShowCharacteristics() {
        System.out.println("Car Makers: " + makers.getmakers() + ", Model: " + model.getmodel()+", Color: " + color.getcolor());
        System.out.println(engine);
    }
}

public class Main {
    public static void main(String[] args) {
        Manufacture m1 = new Manufacture("Honda", "Civic","Black");
        Manufacture m2 = new Manufacture("Tata", "Nexon","Red");
        Manufacture m3 = new Manufacture("Honda", "Thar","Blue");
        Manufacture m4 = new Manufacture("Toyota", "Innova","White");
        Manufacture m5 = new Manufacture("Mercedes", "Benz","Black");

        Engine engine1 = new CombustionEngine("Diesel Engine");
        Engine engine2 = new ElectricEngine("Electric Motor");
        Engine engine3 = new HybridEngine("Gas Engine", "Electric Motor");

        Vehicle[] vehicles = new Vehicle[5];
        vehicles[0] = new ICEV(m1,m1,m1, engine1);
        vehicles[1] = new BEV(m2,m2,m2, engine2);
        vehicles[2] = new HybridV(m3,m3,m3, engine3);
        vehicles[3] = new HybridV(m4,m4,m4, engine2);
        vehicles[4] = new ICEV(m5,m5,m5, engine3);

        for (Vehicle vehicle : vehicles) {
            vehicle.ShowCharacteristics();
            System.out.println();
        }
    }
}
