package gestion.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.dao.DemandeDao;
import gestion.dto.DemandeDTO;
import gestion.dto.UtilisateurDTO;
import gestion.dto.converter.DemandeDTOConverter;
import gestion.model.Demande;
import gestion.model.Utilisateur;
import gestion.service.DemandeService;
import gestion.service.UtilisateurService;


@Service
@Transactional
public class DemandeServiceImpl implements DemandeService {

	@Autowired
	private DemandeDao demandeDao;
	
	@Autowired
	private DemandeDTOConverter demandeDTOConverter;
	
	@Autowired
	private UtilisateurService utilisateurService;

	@Override
	@Transactional
	public List<DemandeDTO> getList() {
		UtilisateurDTO current = utilisateurService.getCurrentUser();
		
		List<Demande> list = demandeDao.findAll();
		if(!StringUtils.equals(current.getRole(), "ROLE_ADMIN") ) {
			list = demandeDao.findByUser(current.getId());
		}
		List<DemandeDTO> dtos = demandeDTOConverter.convertFromDataBeanList(list);
		return dtos;
	}
	
	@Override
	public DemandeDTO load(Long id) {
		Optional<Demande> entity = demandeDao.findById(id);
		DemandeDTO dto = demandeDTOConverter.convertFromDataBean(entity.get());
		return dto;
	}
	
	@Override
	public DemandeDTO save(DemandeDTO dto) {
		Demande entity = demandeDTOConverter.convertFromDTO(dto);
		if(dto.getId() == null) {
			UtilisateurDTO current = utilisateurService.getCurrentUser();
			entity.setStatut("Nouvelle");
			entity.setDateDemande(new Date());
			entity.setUtilisateur(new Utilisateur(current.getId()));
		}
		entity = demandeDao.save(entity);
		return demandeDTOConverter.convertFromDataBean(entity);
	}
	
	@Override
	public void delete(Long id) {
		demandeDao.deleteById(id);
	}
	
	@Override
	public void cancel(Long id) {
		Optional<Demande> entity = demandeDao.findById(id);
		entity.get().setStatut("Annulée");
		demandeDao.save(entity.get());
	}
	
}