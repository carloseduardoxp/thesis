@Configuration
@ComponentScan({"com.example.package1", "com.example.package2"})
public class AppConfig {
    // ...
}

@Configuration
@ComponentScan("com.example.package1")
class Package1Config {
    // ...
}

@Configuration
@ComponentScan("com.example.package2")
class Package2Config {
    // ...
}

@Configuration
@Import({Package1Config.class, Package2Config.class})
class AppConfig {
    // ...
}
