@Configuration
@EnableOAuth2Client
public class AppConfig {
 
    @Value("${google.client.clientId}")
    private String googleClientId;
 
    @Value("${google.client.clientSecret}")
    private String googleClientSecret;
 
    @Value("${google.client.accessTokenUri}")
    private String googleAccessTokenUri;
 
    @Value("${google.client.userAuthorizationUri}")
    private String googleUserAuthorizationUri;
 
    @Value("${google.client.scope}")
    private String googleScope;
 
    @Bean
    public OAuth2RestTemplate googleOAuth2RestTemplate(OAuth2ClientContext oauth2ClientContext) {
        OAuth2ProtectedResourceDetails resourceDetails = new GoogleOAuth2ClientDetails(googleClientId, googleClientSecret, googleAccessTokenUri, googleUserAuthorizationUri, googleScope);
        return new OAuth2RestTemplate(resourceDetails, oauth2ClientContext);
    }
 
    private static class GoogleOAuth2ClientDetails extends AuthorizationCodeResourceDetails {
 
        public GoogleOAuth2ClientDetails(String clientId, String clientSecret, String accessTokenUri, String userAuthorizationUri, String scope) {
            setClientId(clientId);
            setClientSecret(clientSecret);
            setAccessTokenUri(accessTokenUri);
            setUserAuthorizationUri(userAuthorizationUri);
            setScope(Arrays.asList(scope));
        }
 
    }
}

@Controller
class UserController {
 
    @Autowired
    private OAuth2RestTemplate googleOAuth2RestTemplate;
 
    @RequestMapping("/user")
    public String getUser(Model model) {
        // Retrieve the user's profile information using the Google OAuth2 client
        User user = googleOAuth2RestTemplate.getForObject("https://www.googleapis.com/oauth2/v3/userinfo", User.class);
 
        // Add the user's information to the model for display
        model.addAttribute("user", user);
 
        return "user";
    }
}
