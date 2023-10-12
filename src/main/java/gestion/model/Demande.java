package gestion.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="DEMANDE")
public class Demande implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Temporal(TemporalType.TIME)
	@Column(name="DATE_DEMANDE")
	private Date dateDemande;	
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_DEBUT")
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATE_FIN")
	private Date dateFin;
	
	@Column(name="NBR_NUIT")
	private Long nombreNuits;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="MOYENNE_TRANS_ID")
	private MoyenneTrans moyenneTrans;	
	
	@Column(name="AVANCE")
	private BigDecimal avance;	
	
	@Column(name="STATUT")
	private String statut;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLE_DEP_ID")
	private Ville villeDep;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "VILLE_DEST_ID")
	private Ville villeDest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UTILISATEUR_ID")
	private Utilisateur utilisateur;

	
	public Demande() {
		super();
	}
	
	public Demande(Long id) {
		super();
		this.id = id;
	}
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDemande() {
		return dateDemande;
	}

	public void setDateDemande(Date dateDemande) {
		this.dateDemande = dateDemande;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Long getNombreNuits() {
		return nombreNuits;
	}

	public void setNombreNuits(Long nombreNuits) {
		this.nombreNuits = nombreNuits;
	}

	public MoyenneTrans getMoyenneTrans() {
		return moyenneTrans;
	}

	public void setMoyenneTrans(MoyenneTrans moyenneTrans) {
		this.moyenneTrans = moyenneTrans;
	}

	public BigDecimal getAvance() {
		return avance;
	}

	public void setAvance(BigDecimal avance) {
		this.avance = avance;
	}
	
	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Ville getVilleDep() {
		return villeDep;
	}

	public void setVilleDep(Ville villeDep) {
		this.villeDep = villeDep;
	}

	public Ville getVilleDest() {
		return villeDest;
	}

	public void setVilleDest(Ville villeDest) {
		this.villeDest = villeDest;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	
}