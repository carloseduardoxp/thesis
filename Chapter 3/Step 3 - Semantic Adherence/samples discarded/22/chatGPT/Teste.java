public class QuitProgramExample {

    @OneToMany(mappedBy = "parent")
    @LazyCollection(LazyCollectionOption.EXTRA)
    private List<Child> children;

    @OneToMany(mappedBy = "parent")
    @Fetch(FetchMode.SUBSELECT)
    private List<Child> children;


}
