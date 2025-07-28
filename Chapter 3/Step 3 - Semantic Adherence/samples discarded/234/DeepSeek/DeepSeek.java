@Service
public class YourService {
    
    @Autowired
    private YourRepository repository;
    
    public void clearColumnValue(Long id) {
        YourEntity entity = repository.findById(id).orElseThrow(
            () -> new EntityNotFoundException("Entity not found with id: " + id)
        );
        
        entity.setColumnName(null); // Set the specific column to null
        repository.save(entity);
    }
}
