public class Teste {
  @Modifying
  @Query("UPDATE my_table SET my_column = NULL WHERE id = :id")
  void deleteSingleColumn(@Param("id") Long id);
  
}
