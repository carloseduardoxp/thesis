import java.util.List;

public class Teste {
  public static void main(String[] args) {
    List<MyObject> result = jdbcTemplate.query("SELECT * FROM my_table WHERE id = ?", new Object[]{id},
        (rs, rowNum) -> myObject);

    if(result.isEmpty()) {
      // handle case where no records were found
    } else {
      // process the results
    }

  }
}
