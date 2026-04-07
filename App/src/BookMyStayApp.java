import java.util.*;

// ---------------- ROOM ----------------
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

// ---------------- INVENTORY ----------------
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

// ---------------- RESERVATION (UC5) ----------------
class Reservation {
    String guestName;
    String roomType;

    Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    void display() {
        System.out.println("Guest: " + guestName + " | Requested Room: " + roomType);
    }
}

// ---------------- MAIN CLASS ----------------
public class BookMyStayApp {

    // ---------------- UC4 ----------------
    public static void searchRooms(Inventory inventory, Map<String, Room> roomMap) {

        System.out.println("\n=== Available Rooms (UC4) ===");

        for (String type : inventory.getRoomTypes()) {
            int count = inventory.getAvailability(type);

            if (count > 0) {
                Room room = roomMap.get(type);

                if (room != null) {
                    room.display();
                    System.out.println("Available Count: " + count);
                    System.out.println("----------------------");
                }
            }
        }
    }

    // ---------------- UC5: BOOKING REQUEST QUEUE ----------------
    public static void handleBookingRequests() {

        System.out.println("\n=== Booking Requests Queue (UC5) ===");

        // Queue for FIFO
        Queue<Reservation> bookingQueue = new LinkedList<>();

        // Adding booking requests (arrival order)
        bookingQueue.add(new Reservation("Alice", "Single"));
        bookingQueue.add(new Reservation("Bob", "Suite"));
        bookingQueue.add(new Reservation("Charlie", "Single"));

        // Display queue (NO processing yet)
        for (Reservation r : bookingQueue) {
            r.display();
        }

        System.out.println("All requests stored in FIFO order. No booking done yet.");
    }

    // ---------------- MAIN ----------------
    public static void main(String[] args) {

        // UC3: Inventory
        Inventory inventory = new Inventory();
        inventory.addRoom("Single", 2);
        inventory.addRoom("Double", 0);
        inventory.addRoom("Suite", 3);

        // UC4: Room details
        Map<String, Room> roomMap = new HashMap<>();
        roomMap.put("Single", new Room("Single", 1000));
        roomMap.put("Double", new Room("Double", 2000));
        roomMap.put("Suite", new Room("Suite", 5000));

        // UC4: Search
        searchRooms(inventory, roomMap);

        // UC5: Booking Request Queue
        handleBookingRequests();
    }
}