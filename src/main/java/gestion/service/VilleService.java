package gestion.service;

import java.util.List;

import gestion.dto.VilleDTO;

public interface VilleService {

	public List<VilleDTO> getList();
	
	public VilleDTO load(Long id);
	
	public VilleDTO save(VilleDTO dto);
	
	public void delete(Long id);
	
}
