package com.training.FundTransfer.entities;

import javax.persistence.*;
import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;

import com.sun.istack.NotNull;
@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column
    @NotNull
    private String userName;

    @Column
    @NotNull
    private String password;

    @Column
    @Email(message = "Email Should be in a Email format")
    @NotNull
    private String email;

    @Column
    private String country;

    @JsonIgnore
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "user")
    Account account;

  

	@JsonIgnore
    @Enumerated(EnumType.STRING)
    private LoginStatus loginStatus;

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", password="
                + password + ", email=" + email + ", country="
                + country + "]";
    }

    public User(Long userId, Long accountId, String userName, String password,
                @Email(message = "Length should not exceed more than 30") String email,
                 String country, LoginStatus loginStatus) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.country = country;
        this.loginStatus = loginStatus;
    }

    public User() {
    }
    
    public User(String userName, String password) {
  		super();
  		this.userName = userName;
  		this.password = password;
  	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LoginStatus getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(LoginStatus loginStatus) {
		this.loginStatus = loginStatus;
	}
    
}
