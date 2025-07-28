import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyDao {
    private JdbcTemplate jdbcTemplate;

    public MyDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertPerson(String name, Integer age, String email) {
        String sql = "INSERT INTO persons (name, age, email) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, age, email); // email can be null here
    }

    public List<String> findNamesByAge(Integer age) {
        String sql = "SELECT name FROM persons WHERE age = ?";
        // If you want to find people with a null age, you can pass null
        return jdbcTemplate.queryForList(sql, String.class, age); 
    }

    public List<String> findNamesByEmail(String email) {
        String sql = "SELECT name FROM persons WHERE email IS NULL OR email = ?";
        // When checking for NULL in SQL, you typically use "IS NULL" or "IS NOT NULL".
        // If you pass null to a "=" operator, it usually won't work as expected.
        // A common pattern for optional parameters is:
        // "WHERE (:param IS NULL OR column = :param)"
        // For JdbcTemplate with positional parameters, you might need to adjust your SQL or use NamedParameterJdbcTemplate.
        // With positional parameters, if `email` is null, you'd typically make the query aware:
        // "SELECT name FROM persons WHERE email IS ?" - this might work with some drivers but "IS NULL" is standard
        return jdbcTemplate.queryForList(sql, String.class, email);
    }
}
