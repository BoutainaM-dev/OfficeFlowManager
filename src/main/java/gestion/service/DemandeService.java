package gestion.service;

import java.util.List;

import gestion.dto.DemandeDTO;

public interface DemandeService {

	public List<DemandeDTO> getList();
	
	public DemandeDTO load(Long id);
	
	public DemandeDTO save(DemandeDTO dto);
	
	public void delete(Long id);
	
	void cancel(Long id);
	
}
