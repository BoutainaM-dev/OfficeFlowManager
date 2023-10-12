package gestion.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gestion.dao.DdDao;
import gestion.dto.DdDTO;
import gestion.dto.converter.DdDTOConverter;
import gestion.model.DD;
import gestion.service.DdService;

@Service
@Transactional
public class DdServiceImpl implements DdService {

	@Autowired
	private DdDao ddDao;

	@Autowired
	private DdDTOConverter ddDTOConverter;

	@Override
	public List<DdDTO> getList() {
		List<DD> ddList = ddDao.findAll();
		return ddDTOConverter.convertToDTOList(ddList);
	}

	@Override
	public DdDTO load(Long id) {
		Optional<DD> ddOptional = ddDao.findById(id);
		return ddOptional.map(ddDTOConverter::convertToDTO).orElse(null);
	}

	@Override
	public DdDTO save(DdDTO dto) {
		DD dd = ddDTOConverter.convertToEntity(dto);
		DD savedDd = ddDao.save(dd);
		return ddDTOConverter.convertToDTO(savedDd);
	}

	@Override
	public void delete(Long id) {
		ddDao.deleteById(id);
	}

	@Override
	public void cancel(Long id) {
		Optional<DD> ddOptional = ddDao.findById(id);
		ddOptional.ifPresent(dd -> {
			//dd.setCancelled(true);
			ddDao.save(dd);
		});
	}
}
