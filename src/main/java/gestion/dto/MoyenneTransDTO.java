package gestion.dto;

import base.annotations.View;
import gestion.model.MoyenneTrans;

public class MoyenneTransDTO extends MoyenneTrans {
	
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
