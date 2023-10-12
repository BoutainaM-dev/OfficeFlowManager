
package gestion.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import base.JsonDateDeserializer;
import base.JsonDateSerializer;
import base.annotations.View;
import gestion.model.DD;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class DdDTO extends DD {

    @Override
    @View(attribut = "id")
    public Long getId() {
        return super.getId();
    }

    @Override
    @View(attribut = "dateHeureDemande")
    @JsonSerialize(using = JsonDateSerializer.class)
    @JsonDeserialize(using = JsonDateDeserializer.class)
    public Date getDateHeureDemande() {
        // Return the current date and time of execution
        return new Date();}

    @Override
    @View(attribut = "motif")
    public String getMotif() {
        return super.getMotif();
    }

    @Override
    @View(attribut = "projet")
    public String getProjet() {
        return super.getProjet();
    }
        
    @Override
    @View(attribut = "dateDepart")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDateDepart() {
        return super.getDateDepart();
    }
    
    @Override
    @View(attribut = "dateRetour")
    @JsonDeserialize(using = JsonDateDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public Date getDateRetour() {
        return super.getDateRetour();
    }


    @Override
    @View(attribut = "destination")
    public String getDestination() {
        return super.getDestination();
    }

    @Override
    @View(attribut = "moyenTransport")
    public String getMoyenTransport() {
        return super.getMoyenTransport();
    }

    @Override
    @View(attribut = "hebergement")
    public String getHebergement() {
        return super.getHebergement();
    }

    @Override
    @View(attribut = "activites")
    public String getActivites() {
        return super.getActivites();
    }

    @Override
    @View(attribut = "demandeDavance")
    public double getAvance() {
        return super.getAvance();
    }

	
}
