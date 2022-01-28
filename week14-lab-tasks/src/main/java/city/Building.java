package city;

public abstract class Building {
    private int area;
    private int levels = 1;
    private Address address;

    public Building(int area, Address address) {
        this.area = area;
        this.address = address;
    }

    public Building(int area, int levels, Address address) {
        this(area, address);
        this.levels = levels;
    }

    public abstract int calculateNumberOfPeopleCanFit();

    public int getFullArea() {
        return levels * area;
    }

    public int getArea() {
        return area;
    }

    public int getLevels() {
        return levels;
    }

    public Address getAddress() {
        return address;
    }
}
