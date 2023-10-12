package gestion.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import gestion.dto.DdDTO;


public interface DdService {
	
	public List<DdDTO> getList();
	
	public DdDTO load(Long id);
	
	public DdDTO save(DdDTO dto);
	
	public void delete(Long id);
	
	void cancel(Long id);

}
