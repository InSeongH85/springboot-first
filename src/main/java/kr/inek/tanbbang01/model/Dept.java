package kr.inek.tanbbang01.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "DEPT")
@SequenceGenerator(name = "SEQ_DEPT", sequenceName = "SEQ_DEPT", initialValue = 1, allocationSize = 1)
public class Dept {
	@Id
	@GeneratedValue
	@Column(name = "id", updatable = false, insertable = false)
	Long id;
	
	@NotNull
	@Column(name = "code", nullable = false, unique = true)
  String code;
	
	@NotNull
	@Column(name = "name", nullable = false, unique = false)
  String name;
	
	@Column(name = "my_parent_id", nullable = true, unique = false)
  Long myParentId;
  
  @NotNull
  @Column(name = "is_active", nullable = false)
  Boolean isActive;
  
  @NotNull
  @Column(name = "last_updaator_id", nullable = false)
  Long lastUpdatorId;
  
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_created", nullable = false)
  Date dateCreated;
  
  @NotNull
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "last_updated", nullable = false)
  Date lastUpdated;

  
	public Dept() {
		super();
	}

	public Dept(Long id, @NotNull String code, @NotNull String name, Long myParentId, @NotNull Boolean isActive,
			@NotNull Long lastUpdatorId, @NotNull @Past Date dateCreated, @NotNull @Past Date lastUpdated) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.myParentId = myParentId;
		this.isActive = isActive;
		this.lastUpdatorId = lastUpdatorId;
		this.dateCreated = dateCreated;
		this.lastUpdated = lastUpdated;
	}

	@Id
	@GeneratedValue(generator = "SEQ_DEPT", strategy = GenerationType.SEQUENCE)
	@Column(name="id", updatable = false, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getMyParentId() {
		return myParentId;
	}

	public void setMyParentId(Long myParentId) {
		this.myParentId = myParentId;
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
