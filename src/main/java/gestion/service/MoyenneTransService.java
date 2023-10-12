package gestion.service;

import java.util.List;

import gestion.dto.MoyenneTransDTO;

public interface MoyenneTransService {

	public List<MoyenneTransDTO> getList();
	
	public MoyenneTransDTO load(Long id);
	
	public MoyenneTransDTO save(MoyenneTransDTO dto);
	
	public void delete(Long id);
	
}
