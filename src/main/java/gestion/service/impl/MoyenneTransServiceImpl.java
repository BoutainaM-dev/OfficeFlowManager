package gestion.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.dao.MoyenneTransDao;
import gestion.dto.MoyenneTransDTO;
import gestion.dto.converter.MoyenneTransDTOConverter;
import gestion.model.MoyenneTrans;
import gestion.service.MoyenneTransService;


@Service
@Transactional
public class MoyenneTransServiceImpl implements MoyenneTransService {

	@Autowired
	private MoyenneTransDao moyenneTransDao;
	
	@Autowired
	private MoyenneTransDTOConverter moyenneTransDTOConverter;

	@Override
	@Transactional
	public List<MoyenneTransDTO> getList() {
		List<MoyenneTrans> list = moyenneTransDao.findAll();
		List<MoyenneTransDTO> dtos = moyenneTransDTOConverter.convertFromDataBeanList(list);
		return dtos;
	}
	
	@Override
	public MoyenneTransDTO load(Long id) {
		Optional<MoyenneTrans> entity = moyenneTransDao.findById(id);
		MoyenneTransDTO dto = moyenneTransDTOConverter.convertFromDataBean(entity.get());
		return dto;
	}
	
	@Override
	public MoyenneTransDTO save(MoyenneTransDTO dto) {
		MoyenneTrans entity = moyenneTransDTOConverter.convertFromDTO(dto);
		entity = moyenneTransDao.save(entity);
		return moyenneTransDTOConverter.convertFromDataBean(entity);
	}
	
	@Override
	public void delete(Long id) {
		moyenneTransDao.deleteById(id);
	}
	
}