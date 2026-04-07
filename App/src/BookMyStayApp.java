import java.util.*;

// ---------------- ROOM (Domain Model) ----------------
class Room {
    String type;
    double price;

    Room(String type, double price) {
        this.type = type;
        this.price = price;
    }

    void display() {
        System.out.println("Room Type: " + type + ", Price: ₹" + price);
    }
}

// ---------------- INVENTORY (UC3) ----------------
class Inventory {
    private Map<String, Integer> availability = new HashMap<>();

    void addRoom(String type, int count) {
        availability.put(type, count);
    }

    int getAvailability(String type) {
        return availability.getOrDefault(type, 0);
    }

    Set<String> getRoomTypes() {
        return availability.keySet();
    }
}

// ---------------- MAIN CLASS ----------------
public class BookMyStayApp {

    // ---------------- UC4: SEARCH (READ ONLY) ----------------
    public static void searchRooms(Inventory inventory, Map<String, Room> roomMap) {

        System.out.println("\n=== Available Rooms (UC4) ===");

        for (String type : inventory.getRoomTypes()) {

            int count = inventory.getAvailability(type);

            // Show only available rooms
            if (count > 0) {

                Room room = roomMap.get(type);

                // Defensive check
                if (room != null) {
                    room.display();
                    System.out.println("Available Count: " + count);
                    System.out.println("----------------------");
                }
            }
        }
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        // UC3: Inventory setup
        Inventory inventory = new Inventory();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 0); // should NOT appear
        inventory.addRoom("Suite", 3);

        // UC4: Room details
        Map<String, Room> roomMap = new HashMap<>();
        roomMap.put("Single", new Room("Single", 1000));
        roomMap.put("Double", new Room("Double", 2000));
        roomMap.put("Suite", new Room("Suite", 5000));

        // UC4: Search call
        searchRooms(inventory, roomMap);
    }
}