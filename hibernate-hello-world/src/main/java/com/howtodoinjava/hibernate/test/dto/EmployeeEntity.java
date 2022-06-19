package com.howtodoinjava.hibernate.test.dto;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString


@Entity
@Table(name = "Employee", uniqueConstraints = {
    @UniqueConstraint(columnNames = "ID"),
    @UniqueConstraint(columnNames = "EMAIL") })
public class EmployeeEntity implements Serializable {

	@Serial
	private static final long serialVersionUID = -1798070786993154676L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true, nullable = false)
	private Integer employeeId;

	@Column(name = "EMAIL", unique = true, nullable = false, length = 100)
	private String email;

	@Column(name = "FIRST_NAME", nullable = false, length = 100)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = false, length = 100)
	private String lastName;


	}

