package gestion.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Table(name="UTILISATEUR")
public class Utilisateur implements Serializable, UserDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="NOM")
	private String nom;
	
	@Column(name="PRENOM")
	private String prenom;

	@Column(name="EMAIL")
	private String email;
	
	@Column(name="LOGIN")
	private String login;

	@Column(name="PASSWORD")
	private String password;
	
	@Column(name = "ACTIF")
	private Boolean actif;
	
	@Column(name = "TOKEN")
	private String token;
	
	@Column(name = "ROLE")
	private String role;
	
	@Column(name = "PROFILE_CODE")
	private String profileCode;
	
	@Column(name = "PROFILE_IMAGE")
	private String profileImage;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "LAST_CONNECTION")
	private Date lastConnection;
	
	@Column(name = "SUPERIOR_ID")
	private String superior;
	
	@Column(name = "SUPERIOR_EMAIL")
	private String superior_email;
	
	@Transient
	private Set<GrantedAuthority> authorities;


	public Utilisateur() {
		super();
	}
	
	public Utilisateur(Long id) {
		super();
		this.id = id;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Boolean getActif() {
		return actif;
	}
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getProfileCode() {
		return profileCode;
	}
	public void setProfileCode(String profileCode) {
		this.profileCode = profileCode;
	}
	
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public Date getLastConnection() {
		return lastConnection;
	}
	public void setLastConnection(Date lastConnection) {
		this.lastConnection = lastConnection;
	}

	@Override
	public Set<GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}