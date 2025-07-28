
import java.util.List;


public class DeepSeek {

    public static void main(String[] args) {

        List<User> users = jdbcTemplate.query(
                "SELECT id, name, age, email FROM users",
                (rs, rowNum) -> {
                    User user = new User();
                    user.setId(rs.getLong("id"));
                    user.setName(rs.getString("name"));

                    // Handling NULL for primitive types
                    int age = rs.getInt("age");
                    if (rs.wasNull()) {
                        // Handle NULL case (note: primitive int can't be null)
                        user.setAge(0); // or some default value
                    } else {
                        user.setAge(age);
                    }

                    // For objects, you can just use getObject()
                    user.setEmail(rs.getString("email")); // will be null if DB value is NULL

                    return user;
                }
        );

    }

}
