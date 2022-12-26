package com.inventory.management.model;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


import java.util.Set;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class AppUser {

    @Id
    private String userName;
    private String userFirstName;
    private String userLastName;
    private String userPassword;
    
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLE",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID")
            }
    )
    private Set<Role> role;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Set<Role> getRole() {
        return role;
    }

    public void setRole(Set<Role> role) {
        this.role = role;
    }
}



//@Entity
//@Table(name = "appuser")
//public class AppUser {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO )
//	private int userId;
//	@Column( nullable = false, unique = true, length = 10)
//	private String userName;
//	private String userPassword;
//	@Column( nullable = false, unique = true, length = 30)
//	private String email;
////	@Column
////	private Role role;
//	
//	@Column
//	private Role role;
//	
//
//	public AppUser() {
//		super();
//	}
//	
//	
//
//	public AppUser(int userId, String userPassword, String email) {
//		super();
//		this.userId = userId;
//		this.userPassword = userPassword;
//		this.email = email;
//	}
//
//
//	
//	public AppUser(int userId, String userName, String userPassword, String email, Role role) {
//		super();
//		this.userId = userId;
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.email = email;
//		this.role = role;
//	}
//
//
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getuserPassword() {
//		return userPassword;
//	}
//
//	public void setuserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	
//	
//	public Role getRole() {
//		return role;
//	}
//
//
//
//	public void setRole(Role role) {
//		this.role = role;
//	}
//
//
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(email, userPassword, role, userId, userName);
//	}
//
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		AppUser other = (AppUser) obj;
//		return Objects.equals(email, other.email) && Objects.equals(userPassword, other.userPassword) && role == other.role
//				&& userId == other.userId && Objects.equals(userName, other.userName);
//	}

//}
	
