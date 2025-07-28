@Module
public class TestModule{
    @Provides
    Bar provideBar(){
        return new Bar();
    }
    @Provides
    Foo provideFoo(Bar bar){
        return new Foo(bar);
    }

    @Provides
    Foo.Factory provideFooFactory(final Provider<Foo> fooProvider){
        return  new Foo.Factory(){
                    @Override
                    public Foo createNew() {
                        return fooProvider.get();
                    }
        };
    }
}