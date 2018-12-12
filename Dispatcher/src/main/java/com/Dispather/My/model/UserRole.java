package com.Dispather.My.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="USERROLE")
public class UserRole
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "URO_ID")
	private long userId;
	
	@ManyToOne
	@JoinColumn(name="USER_ID")
	private DispatcherUser user;
	
	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private Role role;

	@JoinColumn(name="URO_STATUS")
	private Status status;
	
	@Column(name="URO_CREATE_DATE")
	private LocalDateTime createDate;
	
	@Column(name="URO_CHANGE_STATUS_DATE")
	private LocalDateTime changeStatusDate;
}
