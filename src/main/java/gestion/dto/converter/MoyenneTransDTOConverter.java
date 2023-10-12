package gestion.dto.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import base.BaseConverter;
import gestion.dto.MoyenneTransDTO;
import gestion.model.MoyenneTrans;

@Service("MoyenneTransDTOConverter")
public class MoyenneTransDTOConverter extends BaseConverter<MoyenneTrans, MoyenneTransDTO>{
	
	@Override
	@Transactional
	public List<MoyenneTransDTO> convertFromDataBeanList(List<MoyenneTrans> list){
		List<MoyenneTransDTO> dtoList = new ArrayList<MoyenneTransDTO>();
		for(MoyenneTrans e:list){
			MoyenneTransDTO dto = this.convertFromDataBean(e);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public MoyenneTrans convertFromDTO(MoyenneTransDTO dto) {
		MoyenneTrans entity = new MoyenneTrans();
		entity = super.convertDTOToEntity(dto, entity);
		return entity;
	}

	public MoyenneTrans convertFromDTO(MoyenneTrans entity,MoyenneTransDTO dto) {
		return super.convertDTOToEntity(dto, entity);
	}

	@Override
	public MoyenneTransDTO convertFromDataBean(MoyenneTrans entity) {
		MoyenneTransDTO dto =  super.convertEntityToDTO(entity);
		return dto;
	}

}
