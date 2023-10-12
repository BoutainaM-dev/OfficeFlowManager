package gestion.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DEMANDE_CONGE")
public class DemandeConge implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DATE_DEMANDE")
    private Date dateDemande;

    @Column(name = "DATE_DEBUT")
    private Date dateDebut;

    @Column(name = "DATE_FIN")
    private Date dateFin;

    @Column(name = "MOTIF")
    private String motif;

    @Column(name = "DUREE")
    private int duree;

    @Column(name = "TYPE")
    private String type;

    // Constructors, getters, and setters
    // ...
}

