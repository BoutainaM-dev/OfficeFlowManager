package gestion.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.BaseConverter;
import gestion.dto.UtilisateurDTO;
import gestion.model.Utilisateur;

@Service("UtilisateurDTOConverter")
public class UtilisateurDTOConverter extends BaseConverter<Utilisateur, UtilisateurDTO>{
	
	@Override
	@Transactional
	public List<UtilisateurDTO> convertFromDataBeanList(List<Utilisateur> list){
		List<UtilisateurDTO> dtoList = new ArrayList<UtilisateurDTO>();
		for(Utilisateur e:list){
			UtilisateurDTO dto = this.convertFromDataBean(e);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public Utilisateur convertFromDTO(UtilisateurDTO dto) {
		Utilisateur entity = new Utilisateur();
		entity = super.convertDTOToEntity(dto, entity);
		return entity;
	}

	public Utilisateur convertFromDTO(Utilisateur entity,UtilisateurDTO dto) {
		return super.convertDTOToEntity(dto, entity);
	}

	@Override
	public UtilisateurDTO convertFromDataBean(Utilisateur entity) {
		UtilisateurDTO dto =  super.convertEntityToDTO(entity);
//		dto.setPassword("password");
		return dto;
	}

}
