package city;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class City {
    private String name;
    private long fullArea;
    private List<Building> buildings = new ArrayList<>();

    public City(String name, long fullArea) {
        this.name = name;
        this.fullArea = fullArea;
    }

    public Building findHighestBuilding() {
        return buildings.stream()
                .max(Comparator.comparingInt(Building::getLevels))
                .orElse(null);
    }
//
//    public Building findHighestBuilding() {
//        Building highest = null;
//        for (Building building: buildings) {
//            if (highest == null || building.getLevels() > highest.getLevels()) {
//                highest = building;
//            }
//        }
//        return highest;
//    }

    List<Building> findBuildingsByStreet(String street) {
        return buildings.stream()
                .filter(building -> building.getAddress().getStreet().equals(street))
                .toList();
    }

//    List<Building> findBuildingsByStreet(String street) {
//        List<Building> result = new ArrayList<>();
//        for (Building building: buildings) {
//            if (building.getAddress().getStreet().equals(street)) {
//                result.add(building);
//            }
//        }
//        return result;
//    }

    boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
        return buildings.stream()
                .anyMatch(building -> building.calculateNumberOfPeopleCanFit() > numberOfPeople);
    }

//    boolean isThereBuildingWithMorePeopleThan(int numberOfPeople) {
//        for (Building building: buildings) {
//            if (building.calculateNumberOfPeopleCanFit() > numberOfPeople) {
//                return true;
//            }
//        }
//        return false;
//    }

    public void addBuilding(Building building) {
        if (getBuildingsTotalArea() + building.getArea() <= fullArea) {
            buildings.add(building);
        } else {
            throw new IllegalArgumentException(String.format("City can't be larger than %d", fullArea));
        }
    }

    private long getBuildingsTotalArea() {
        long result = 0;
        for (Building building: buildings) {
            result += building.getArea();
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public long getFullArea() {
        return fullArea;
    }

    public List<Building> getBuildings() {
        return buildings;
    }
}
