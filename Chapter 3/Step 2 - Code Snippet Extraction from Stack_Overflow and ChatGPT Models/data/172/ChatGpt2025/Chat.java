
import java.util.List;


public class Chat {

    public static void main(String[] args) {

        List<User> users = jdbcTemplate.query(
                "SELECT * FROM users WHERE age > ?",
                new Object[]{25},
                new BeanPropertyRowMapper<>(User.class)
        );

    }

}
