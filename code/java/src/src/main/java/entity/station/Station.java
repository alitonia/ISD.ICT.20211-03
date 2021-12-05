package entity.station;

import entity.bike.Bike;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String stationId;
    private String name;
    private String address;
    private float area;
    private int maxCapacity;
    private int capacity;
    private List<Bike> bikeList;

    public Station(String stationId, String name, String address, float area, int maxCapacity) {
        this.stationId = stationId;
        this.name = name;
        this.address = address;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.capacity = 0;
        this.bikeList = new ArrayList<Bike>();

    }

    public Station(String stationId, String name, String address, float area, int maxCapacity, int capacity, List<Bike> bikeList) {
        this.stationId = stationId;
        this.name = name;
        this.address = address;
        this.area = area;
        this.maxCapacity = maxCapacity;
        this.capacity = capacity;
        this.bikeList = bikeList;
    }

    public String getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public float getArea() {
        return area;
    }


    public List<Bike> getBikeList() {
        return bikeList;
    }

    public void setBikeList(List<Bike> bikeList) {
        this.bikeList = bikeList;
    }

    public Station getStation() {
        return this;
    }

    public void addBike(Bike addBike) throws Exception {
        // check if station has no empty docking points left
        if (!checkAvailability()) {
            // throws exception
            throw new Exception("Station is full. Cannot add bike");
        }

        bikeList.add(addBike);
        capacity++;
    }

    public void removeBike(String bikeCode) throws Exception {
        if (bikeCode == null || bikeCode.isEmpty()) {
            throw new Exception("Station cannot find appropriate to remove");
        }
        if (bikeList.size() <= 0)
            throw new Exception("Station has no bikes to remove");
        // throws exception if cannot remove bike
        for (int i = 0; i < bikeList.size(); i++)
            if (bikeList.get(i).getBikeCode().equals(bikeCode)) {
                bikeList.remove(i);
                capacity--;
                return;
            }
        throw new Exception("Bike not found in station");
    }

    public boolean checkAvailability() {
        return capacity < maxCapacity;
    }

    @Override
    public String toString() {
        return "Station: " + name + ", No of Empty Docks:" + (maxCapacity - capacity) + ", No of Bikes: " + capacity + "\n";
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCapacity() {
        return capacity;
    }
}