package bg.softuni.exam.service.impl;


import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class ShopUser extends User {


    public ShopUser(String username, String password,
                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public ShopUser(String username, String password, boolean enabled, boolean accountNonExpired,
                    boolean credentialsNonExpired, boolean accountNonLocked,
                    Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                authorities);
    }

    // some own methods below.

    public String getUserIdentifier() {
        return getUsername();
    }
}