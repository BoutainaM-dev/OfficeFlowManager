package gestion.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.BaseConverter;
import gestion.dto.DemandeDTO;
import gestion.model.Demande;

@Service("DemandeDTOConverter")
public class DemandeDTOConverter extends BaseConverter<Demande, DemandeDTO>{
	
	@Override
	@Transactional
	public List<DemandeDTO> convertFromDataBeanList(List<Demande> list){
		List<DemandeDTO> dtoList = new ArrayList<DemandeDTO>();
		for(Demande e:list){
			DemandeDTO dto = this.convertFromDataBean(e);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public Demande convertFromDTO(DemandeDTO dto) {
		Demande entity = new Demande();
		entity = super.convertDTOToEntity(dto, entity);
		return entity;
	}

	public Demande convertFromDTO(Demande entity,DemandeDTO dto) {
		return super.convertDTOToEntity(dto, entity);
	}

	@Override
	public DemandeDTO convertFromDataBean(Demande entity) {
		DemandeDTO dto =  super.convertEntityToDTO(entity);
		return dto;
	}

}
