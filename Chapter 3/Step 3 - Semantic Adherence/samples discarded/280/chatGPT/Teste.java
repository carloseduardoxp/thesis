public class Person {
  private Long id;
  private String name;
  private int age;

  // Constructors, getters, and setters omitted for brevity
}

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private List<Person> people = new ArrayList<>();

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Optional<Person> person = people.stream().filter(p -> p.getId().equals(id)).findFirst();
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        // Generate a new ID for the person
        Long id = Long.valueOf(people.size() + 1);
        person.setId(id);

        // Add the person to the list
        people.add(person);

        // Return a response with the location of the newly created resource
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                                                   .buildAndExpand(person.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
