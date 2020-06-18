import java.util.Objects;

public class user {
    private String user_id;
    private String username;
    private String password;
    private String color;

    public user(String user_id, String username, String password, String color){
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.color = color;
    }
    public user(String username, String password, String color) {
        this.user_id = randomString();
        this.username = username;
        this.password = password;
        this.color = color;
    }


    public static String randomString()
    {

        // chose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(15);

        for (int i = 0; i < 15; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        user user = (user) o;
        return user_id.equals(user.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user_id);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
