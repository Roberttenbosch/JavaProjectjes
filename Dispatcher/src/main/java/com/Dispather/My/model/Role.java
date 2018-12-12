package com.Dispather.My.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="ROLE")
public class Role
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ROLE_ID")
	private long roleId;

	@Column(name = "ROLE_STATUS")
	private Status status;
	
	@OneToMany
	@JoinColumn(name="URO_ID")
	private List<UserRole> userRoles;
	
	@Column(name = "ROLE_CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name = "ROLE_ACCES_DATE")
	private LocalDateTime lastAccesDate;
}
