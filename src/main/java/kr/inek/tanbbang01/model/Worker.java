package kr.inek.tanbbang01.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@SequenceGenerator(name = "SEQ_WORKER", sequenceName = "SEQ_WORKER", initialValue = 1, allocationSize = 1)
@Entity
public class Worker {
	@Id
	@GeneratedValue(generator = "SEQ_WORKER", strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, insertable = false)
	Long id;
	
	@NotNull (message = "password IS NOT NULL")
	@Column(name = "login_id", length = 20, nullable = false, unique = true)
  String loginId;
  
	@NotNull
  String password;
  
	@NotNull
	@Column(name = "name", length = 500, nullable = false)
  String name;
  
	@Column(name = "mobile_phone_no", length = 500)
  String mobilePhoneNo;
	
	@Column(name = "email", length = 500)
  String email;
  
	@NotNull
	@Column(name = "is_superadmin", nullable = false)
  Boolean isSuperadmin;
  
	@NotNull
	@Column(name = "is_accessible_to_patron", nullable = false)
  Boolean isAccessibleToPatron;
  
	@NotNull
	@Future
	@Column(name = "expiry_date", nullable = false)
  Date expiryDate;
  
	@NotNull
	@Column(name = "is_active", nullable = false)
  Boolean isActive;
  
	@NotNull
	@Column(name = "last_updator_id", nullable = false)
	Long lastUpdatorId;
  
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date_created", nullable = false)
  Date dateCreated;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "last_updated", nullable = false)
  Date lastUpdated;
	
	public Worker() {
		super();
	}

	public Worker(Long id, @NotNull String loginId, @NotNull String password, @NotNull String name, String mobilePhoneNo,
			String email, @NotNull Boolean isSuperadmin, @NotNull Boolean isAccessibleToPatron,
			@NotNull @Past Date expiryDate, @NotNull Boolean isActive, @NotNull Long lastUpdatorId,
			@NotNull @Past Date dateCreated, @NotNull @Past Date lastUpdated) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.password = password;
		this.name = name;
		this.mobilePhoneNo = mobilePhoneNo;
		this.email = email;
		this.isSuperadmin = isSuperadmin;
		this.isAccessibleToPatron = isAccessibleToPatron;
		this.expiryDate = expiryDate;
		this.isActive = isActive;
		this.lastUpdatorId = lastUpdatorId;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobilePhoneNo() {
		return mobilePhoneNo;
	}

	public void setMobilePhoneNo(String mobilePhoneNo) {
		this.mobilePhoneNo = mobilePhoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getIsSuperadmin() {
		return isSuperadmin;
	}

	public void setIsSuperadmin(Boolean isSuperadmin) {
		this.isSuperadmin = isSuperadmin;
	}

	public Boolean getIsAccessibleToPatron() {
		return isAccessibleToPatron;
	}

	public void setIsAccessibleToPatron(Boolean isAccessibleToPatron) {
		this.isAccessibleToPatron = isAccessibleToPatron;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public Long getLastUpdatorId() {
		return lastUpdatorId;
	}

	public void setLastUpdatorId(Long lastUpdatorId) {
		this.lastUpdatorId = lastUpdatorId;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

}
