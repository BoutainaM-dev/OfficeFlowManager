package gestion.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.dao.VilleDao;
import gestion.dto.VilleDTO;
import gestion.dto.converter.VilleDTOConverter;
import gestion.model.Ville;
import gestion.service.VilleService;


@Service
@Transactional
public class VilleServiceImpl implements VilleService {

	@Autowired
	private VilleDao villeDao;
	
	@Autowired
	private VilleDTOConverter villeDTOConverter;

	@Override
	@Transactional
	public List<VilleDTO> getList() {
		List<Ville> list = villeDao.findAll();
		List<VilleDTO> dtos = villeDTOConverter.convertFromDataBeanList(list);
		return dtos;
	}
	
	@Override
	public VilleDTO load(Long id) {
		Optional<Ville> entity = villeDao.findById(id);
		VilleDTO dto = villeDTOConverter.convertFromDataBean(entity.get());
		return dto;
	}
	
	@Override
	public VilleDTO save(VilleDTO dto) {
		Ville entity = villeDTOConverter.convertFromDTO(dto);
		entity = villeDao.save(entity);
		return villeDTOConverter.convertFromDataBean(entity);
	}
	
	@Override
	public void delete(Long id) {
		villeDao.deleteById(id);
	}
	
}