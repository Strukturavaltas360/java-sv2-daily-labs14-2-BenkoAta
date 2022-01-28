package city;

public class Office extends Building {
    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, Address address, String company, int numberOfTablesPerLevel) {
        super(area, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        checkNumberOfTablesPerLevel();
    }

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        checkNumberOfTablesPerLevel();
    }

    private void checkNumberOfTablesPerLevel() {
        double squareMetersPerTable = (double) getArea() / numberOfTablesPerLevel;
        if (squareMetersPerTable < 2.0) {
            throw new IllegalArgumentException("Area per table is less than 2 square meters!");
        }
        if (squareMetersPerTable > 5.0) {
            throw new IllegalArgumentException("Area per table is more than 5 square meters!");
        }
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return numberOfTablesPerLevel * (getLevels() - 1);
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
