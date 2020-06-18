public class message {
    private final int id;
    private final String message;
    private final String user_id;
    private final String time;

    public message(int id, String message, String user_id, String time) {
        this.id = id;
        this.message = message;
        this.user_id = user_id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "chat: {" +
                "message='" + message + '\'' +
                ", user_id='" + user_id + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
