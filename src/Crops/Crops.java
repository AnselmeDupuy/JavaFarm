package Crops;

public abstract class Crops {
    private String name;
    private int price;
    private int stage;
    private int age;
    private int quantity;

    public Crops(String name, int price) {
        this.name = name;
        this.price = price;
        this.stage = stage;
        this.age = age;
        this.quantity = quantity;
    }

    public void grow() {

        if(stage == 0) {
            stage = 1;
            System.out.println("The crop " + this.name + " is growing (stage 1)");
        } else if(stage == 1) {
            stage = 2;
            System.out.println("The crop " + this.name + " is growing (stage 2)");
        } else if(stage == 2) {
            stage = 3;
            System.out.println("The crop " + this.name + " is growing (stage 3)");
        }  else if(stage == 3) {
            System.out.println("The crop is fully grown");
            stage = 4;
        }
    }

    public void harvest() {
        if(stage == 4) {
            System.out.println("The crop is harvested");
            stage = 0;
        }
    }

    public void death(int age) {
        if(age > 10) {
            System.out.println("The crop is dead");
            this.stage = 4;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void addToQuantity(int quantity) {
        this.quantity += quantity;
    }
}
