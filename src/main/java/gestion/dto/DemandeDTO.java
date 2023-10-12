package gestion.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import base.JsonDateDeserializer;
import base.JsonDateSerializer;

import base.annotations.View;
import gestion.model.Demande;

public class DemandeDTO extends Demande {
	
	private Long villeDepId;
	private String villeDepLibelle;
	
	private Long villeDestId;
	private String villeDestLibelle;
	
	private Long utilisateurId;
	private String utilisateurLibelle;
	
	private Long moyenneTransId;
	private String moyenneTransLibelle;
	
	private Long projetId;
	private String projetLibelle;
	
	
	@Override
	@View(attribut = "id")
	public Long getId() {
		return super.getId();
	}

	@Override
	@View(attribut = "dateDemande")
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public Date getDateDemande() {
		return super.getDateDemande();
	}

	@Override
	@View(attribut = "dateDebut")
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public Date getDateDebut() {
		return super.getDateDebut();
	}

	@Override
	@View(attribut = "dateFin")
	@JsonSerialize(using=JsonDateSerializer.class)
	@JsonDeserialize(using=JsonDateDeserializer.class)
	public Date getDateFin() {
		return super.getDateFin();
	}

	@Override
	@View(attribut = "nombreNuits")
	public Long getNombreNuits() {
		return super.getNombreNuits();
	}

	@Override
	@View(attribut = "avance")
	public BigDecimal getAvance() {
		return super.getAvance();
	}
	
	@Override
	@View(attribut = "statut")
	public String getStatut() {
		return super.getStatut();
	}

	@View(entity = "villeDep", attribut = "id")
	public Long getVilleDepId() {
		return villeDepId;
	}
	public void setVilleDepId(Long villeDepId) {
		this.villeDepId = villeDepId;
	}

	@View(entity = "villeDep", attribut = "libelle")
	public String getVilleDepLibelle() {
		return villeDepLibelle;
	}
	public void setVilleDepLibelle(String villeDepLibelle) {
		this.villeDepLibelle = villeDepLibelle;
	}

	@View(entity = "villeDest", attribut = "id")
	public Long getVilleDestId() {
		return villeDestId;
	}
	public void setVilleDestId(Long villeDestId) {
		this.villeDestId = villeDestId;
	}

	@View(entity = "villeDest", attribut = "libelle")
	public String getVilleDestLibelle() {
		return villeDestLibelle;
	}
	public void setVilleDestLibelle(String villeDestLibelle) {
		this.villeDestLibelle = villeDestLibelle;
	}

	@View(entity = "utilisateur", attribut = "id")
	public Long getUtilisateurId() {
		return utilisateurId;
	}
	public void setUtilisateurId(Long utilisateurId) {
		this.utilisateurId = utilisateurId;
	}

	@View(entity = "utilisateur", attribut = "nom")
	public String getUtilisateurLibelle() {
		return utilisateurLibelle;
	}
	public void setUtilisateurLibelle(String utilisateurLibelle) {
		this.utilisateurLibelle = utilisateurLibelle;
	}

	@View(entity = "moyenneTrans", attribut = "id")
	public Long getMoyenneTransId() {
		return moyenneTransId;
	}
	public void setMoyenneTransId(Long moyenneTransId) {
		this.moyenneTransId = moyenneTransId;
	}

	@View(entity = "moyenneTrans", attribut = "libelle")
	public String getMoyenneTransLibelle() {
		return moyenneTransLibelle;
	}
	public void setMoyenneTransLibelle(String moyenneTransLibelle) {
		this.moyenneTransLibelle = moyenneTransLibelle;
	}

	@View(entity = "projet", attribut = "id")
	public Long getProjetId() {
		return projetId;
	}
	public void setProjetId(Long projetId) {
		this.projetId = projetId;
	}

	@View(entity = "projet", attribut = "libelle")
	public String getProjetLibelle() {
		return projetLibelle;
	}
	public void setProjetLibelle(String projetLibelle) {
		this.projetLibelle = projetLibelle;
	}

}
