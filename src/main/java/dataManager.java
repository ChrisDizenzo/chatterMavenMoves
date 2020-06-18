import java.util.HashMap;

public class dataManager {

    private HashMap<String, user> users;
    private HashMap<String, room> rooms;

    public dataManager() {
        this.users = new HashMap<>();
        this.rooms = new HashMap<>();
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        System.out.println("Making first class user: ");
        user puppy = new user("creebin","","Blue");
        System.out.println("Made user: ");
        System.out.println(puppy);

        System.out.println("Making class room: ");
        room puppy2 = new room("A"," ","Blue","Today!");
        System.out.println("Made room: ");
        System.out.println(puppy2);

        System.out.println("Adding new chat to room: ");
        chat puppy3 = new chat(0,"I like my brothers!","creebin","Today!");
        System.out.println("Made room: ");
        System.out.println(puppy3);
        System.out.println("room was changed to: ");
        System.out.println(puppy2);

        System.out.println("Adding new message to chat: ");
        message puppy4 = new message(0,"","Blue","Today!");
        System.out.println("Made room: ");
        System.out.println(puppy4);
        System.out.println("chat was changed to: ");
        System.out.println(puppy3);

    }

}
