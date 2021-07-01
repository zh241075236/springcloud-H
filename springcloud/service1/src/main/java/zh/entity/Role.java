//package zh.entity;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.Collection;
//
//@Data
//@NoArgsConstructor
//@Entity
//@Table(name = "role")
//public class Role implements Authentication {
//    @Id
//    private String id;
//    private String roleName;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public Object getCredentials() {
//        return null;
//    }
//
//    @Override
//    public Object getDetails() {
//        return null;
//    }
//
//    @Override
//    public Object getPrincipal() {
//        return null;
//    }
//
//    @Override
//    public boolean isAuthenticated() {
//        return false;
//    }
//
//    @Override
//    public void setAuthenticated(boolean b) throws IllegalArgumentException {
//
//    }
//
//    @Override
//    public String getName() {
//        return null;
//    }
//}
