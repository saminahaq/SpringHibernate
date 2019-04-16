package com.Samina.hibernateExample;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;
//import org.hibernate.mapping.Set;
 
@Entity
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate
@Table(name = "Employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "EMAIL") })

public class EmployeeEntity implements Serializable {
 
    private static final long serialVersionUID = -1798070786993154676L;
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer employeeId;
    
    //Use the natural id annotation here
    @NaturalId (mutable = false)
    @Column(name = "EMAIL", unique = true, nullable = false, length = 100)
    private String email;
 
    @Column(name = "FIRST_NAME", unique = false, nullable = false, length = 100)
    private String firstName;
 
    @Column(name = "LAST_NAME", unique = false, nullable = false, length = 100)
    private String lastName;
    
    @OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="EMPLOYEE_ID")
    private Set<AccountEntity> accounts;
 
    public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}

	// Accessors and mutators for all four fields
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
