@OneToMany(fetch = FetchType.LAZY)
private List<Book> books = new ArrayList<>();

@OneToMany(fetch = FetchType.LAZY)
private List<Award> awards = new ArrayList<>();
