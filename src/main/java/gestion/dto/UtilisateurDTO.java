package gestion.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import base.JsonDateDeserializer;
import base.JsonDateTimeSerializer;
import base.annotations.View;
import gestion.model.Utilisateur;

public class UtilisateurDTO extends Utilisateur {

	private MultipartFile document;
	
	private String newPassword;
	private String confirmNewPassword;
	
	@Override
	@View(attribut = "id")
	public Long getId() {
		return super.getId();
	}

	@Override
	@View(attribut = "nom")
	public String getNom() {
		return super.getNom();
	}

	@Override
	@View(attribut = "prenom")
	public String getPrenom() {
		return super.getPrenom();
	}

	@Override
	@View(attribut = "email")
	public String getEmail() {
		return super.getEmail();
	}
	
	@Override
	@View(attribut = "login")
	public String getLogin() {
		return super.getLogin();
	}
	
	@Override
	@View(attribut = "password")
	public String getPassword() {
		return super.getPassword();
	}
	
	@Override
	@View(attribut = "actif")
	public Boolean getActif() {
		return super.getActif();
	}
	
	@Override
	@View(attribut = "token")
	public String getToken() {
		return super.getToken();
	}
	
	@Override
	@View(attribut = "role")
	public String getRole() {
		return super.getRole();
	}
	
	@Override
	@View(attribut = "profileCode")
	public String getProfileCode() {
		return super.getProfileCode();
	}
	
	@Override
	@View(attribut = "profileImage")
	public String getProfileImage() {
		return super.getProfileImage();
	}
	
	@Override
	@JsonSerialize(using=JsonDateTimeSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	@View(attribut = "lastConnection")
	public Date getLastConnection() {
		return super.getLastConnection();
	}

	public MultipartFile getDocument() {
		return document;
	}
	public void setDocument(MultipartFile document) {
		this.document = document;
	}

	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}
	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	
}
