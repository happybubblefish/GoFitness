package com.lin.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "userCredentials")
public class UserCredentials {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String username;
    
    @NotEmpty
    private String password;

    @Transient
    private String passwordConfirm;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)  
    @JoinTable(name = "user_authority", joinColumns = {@JoinColumn(name = "user_id")}, 
    inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<Authority> authorities;
    
    @OneToOne(mappedBy="userCredentials", cascade = CascadeType.PERSIST) 
 	private Member member;
    
    public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	private Boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
