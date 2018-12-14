package sample;

public class CDataClass{
    private int id;
    private String name;
    private double price;
    private double capacity;

    public CDataClass(int id, String name, double price, double capacity) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    /*private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty price;
    private SimpleStringProperty capacity;

    public CDataClass(String a,String b,String c,String d){
        this.id = new SimpleStringProperty(a);
        this.name = new SimpleStringProperty(b);
        this.price = new SimpleStringProperty(c);
        this.capacity = new SimpleStringProperty(d);
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPrice() {
        return price.get();
    }

    public SimpleStringProperty priceProperty() {
        return price;
    }

    public void setPrice(String price) {
        this.price.set(price);
    }

    public String getCapacity() {
        return capacity.get();
    }

    public SimpleStringProperty capacityProperty() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity.set(capacity);
    }*/
}
