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
@Table(name = "DISPATCHER_USER")
public class DispatcherUser
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "USER_STATUS")
	private Status status;
	
	@OneToMany
	@JoinColumn(name="URO_ID")
	private List<UserRole> userRoles;
	
	@Column(name = "USER_CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name = "USER_ACCES_DATE")
	private LocalDateTime lastAccesDate;
	
	
}
