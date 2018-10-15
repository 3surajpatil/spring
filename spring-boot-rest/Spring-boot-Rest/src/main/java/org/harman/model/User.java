package org.harman.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity(name="users")
public class User {

@Id	
@GeneratedValue(strategy=GenerationType.AUTO )
@Column(name="userid")
int userid;	

@Column(name="username")
String username;

@Column(name="password")
String password;

@Transient
String newPassword;




public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
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
		
}
