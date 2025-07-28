public class UserService implements UserDetailsService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        // load user
        User user = userDao.getUser(username);

        if (user != null) {

            // convert roles
            List<GrantedAuthority> roles = new ArrayList<>(); // diamond operator used here
            for (Privilege p : user.getPrivileges()) {
                roles.add(new GrantedAuthorityImpl(p.getName()));
            }

            // initialize user
            SecurityUser securityUser = new SecurityUser(
                user.getUsername(),
                user.getLdapAuth() ? getLdapPassword(user.getUsername()) : user.getPassword(),
                user.getStatus() != User.Status.NOT_COMMITED, user.getStatus() != User.Status.BLOCKED, true, true,
                roles.toArray(new GrantedAuthority[0])
            );

            securityUser.setUser(user);

            return securityUser;
        } else {
            throw new UsernameNotFoundException("No user with username '" + username + "' found!");
        }
    }
}

class SecurityUser extends org.springframework.security.core.userdetails.User {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public SecurityUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, GrantedAuthority[] authorities) throws IllegalArgumentException {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }
}

class UserDao extends HibernateDaoSupport {

    public User getUser(String username) {
        List users = getHibernateTemplate().find("from User where username = ?", username);
        return users == null || users.size() <= 0 ? null : (User) users.get(0);
    }
}
