package com.example.service;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.entity.User;

public class LoginUser implements UserDetails{

	private final User user;
	
	public LoginUser(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public String getPassword() {
		return this.user.getPassword();
	}
	
	public 	String getUsername() {
		return this.user.getEmail();
	}
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
        return AuthorityUtils.NO_AUTHORITIES;
    }

    // アカウントの有効期限の状態を判定する
    public boolean isAccountNonExpired() {
        return true;
    }

    // アカウントのロック状態を判定する
    public boolean isAccountNonLocked() {
        return true;
    }

    // 資格情報の有効期限の状態を判定する
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 有効なユーザかを判定する
    public boolean isEnabled() {
        return true;
    }
}

