package gestion.dto;

import base.annotations.View;
import gestion.model.Ville;

public class VilleDTO extends Ville {
	
	@Override
	@View(attribut = "id")
	public Long getId() {
		return super.getId();
	}

	@Override
	@View(attribut = "libelle")
	public String getLibelle() {
		return super.getLibelle();
	}

}
