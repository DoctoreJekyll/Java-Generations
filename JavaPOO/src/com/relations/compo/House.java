package com.relations.compo;

import java.util.ArrayList;
import java.util.List;

public class House {

    private List<Room> rooms;

    public House() {
        this.rooms = new ArrayList<Room>();
        rooms.add(new Room("Livin room"));
        rooms.add(new Room("Bedroom"));
        rooms.add(new Room("Kitchen"));
    }

    public List<Room> getRooms() {
        return rooms;
    }
}
