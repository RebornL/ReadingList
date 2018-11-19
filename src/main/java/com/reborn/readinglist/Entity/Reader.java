package com.reborn.readinglist.Entity;

//
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;

@Entity
//public class Reader implements UserDetails {
public class Reader implements Serializable {

//    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "用户名不能为空")
    @Column(name = "username", unique = true,nullable = false)
    private String username;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "password", nullable = false)
    @NotNull(message = "密码不能为空")
    @Size(min = 6 , max = 18, message = "密码应设为6至18位")
    private String password;

    public Reader() {}

    public Reader(String username) {
        this.username = username;
    }

//    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

//    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "username='" + username + '\'' +
                ", fullname='" + fullname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {//授予READER权限
//        return Arrays.asList(new SimpleGrantedAuthority("READER"));
//    }


  /*  @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }*/

}
