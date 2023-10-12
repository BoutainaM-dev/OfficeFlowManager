package gestion.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.BaseConverter;
import gestion.dto.VilleDTO;
import gestion.model.Ville;

@Service("VilleDTOConverter")
public class VilleDTOConverter extends BaseConverter<Ville, VilleDTO>{
	
	@Override
	@Transactional
	public List<VilleDTO> convertFromDataBeanList(List<Ville> list){
		List<VilleDTO> dtoList = new ArrayList<VilleDTO>();
		for(Ville e:list){
			VilleDTO dto = this.convertFromDataBean(e);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public Ville convertFromDTO(VilleDTO dto) {
		Ville entity = new Ville();
		entity = super.convertDTOToEntity(dto, entity);
		return entity;
	}

	public Ville convertFromDTO(Ville entity,VilleDTO dto) {
		return super.convertDTOToEntity(dto, entity);
	}

	@Override
	public VilleDTO convertFromDataBean(Ville entity) {
		VilleDTO dto =  super.convertEntityToDTO(entity);
		return dto;
	}

}
