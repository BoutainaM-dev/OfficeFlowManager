package gestion.model;

import java.io.Serializable;
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
@Table(name = "demande_deplacement")
public class DD implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "demandeur_id")
    private Long demandeur;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_heure_demande")
    private Date dateHeureDemande;

    @Column(name = "motif")
    private String motif;

    @Column(name = "projet")
    private String projet;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_depart")
    private Date dateDepart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_retour")
    private Date dateRetour;

    @Column(name = "destination")
    private String destination;

    @Column(name = "moyen_transport")
    private String moyenTransport;

    @Column(name = "hebergement")
    private String hebergement;

    @Column(name = "activites")
    private String activites;

    @Column(name = "avance")
    private double avance;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(Long demandeur) {
        this.demandeur = demandeur;
    }

    public Date getDateHeureDemande() {
        return dateHeureDemande;
    }

    public void setDateHeureDemande(Date dateHeureDemande) {
        this.dateHeureDemande = dateHeureDemande;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public String getProjet() {
        return projet;
    }

    public void setProjet(String projet) {
        this.projet = projet;
    }

    public Date getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Date dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getMoyenTransport() {
        return moyenTransport;
    }


	public void setMoyenTransport(String moyenTransport) {
		this.moyenTransport = moyenTransport;
	}

	public String getHebergement() {
		return hebergement;
	}

	public void setHebergement(String hebergement) {
		this.hebergement = hebergement;
	}

	public String getActivites() {
		return activites;
	}

	public void setActivites(String activites) {
		this.activites = activites;
	}

	public double getAvance() {
		return avance;
	}

	public void setAvance(double avance) {
		this.avance = avance;
	}

	public float getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(float kilometrage) {
		this.kilometrage = kilometrage;
	}

	public double getMontantEstime() {
		return montantEstime;
	}

	public void setMontantEstime(double montantEstime) {
		this.montantEstime = montantEstime;
	}

	public double getMontantRembourse() {
		return montantRembourse;
	}

	public void setMontantRembourse(double montantRembourse) {
		this.montantRembourse = montantRembourse;
	}

	@Column(name = "KILOMETRAGE")
    private float kilometrage;

    @Column(name = "MONTANT_ESTIME")
    private double montantEstime;

    @Column(name = "MONTANT_REMBOURSE")
    private double montantRembourse;

    public DD() {
		// TODO Auto-generated constructor stub
	}
    
}

