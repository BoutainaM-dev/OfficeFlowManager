package gestion.dto.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import gestion.dto.DdDTO;
import gestion.model.DD;

@Component
public class DdDTOConverter {

    public DdDTO convertToDTO(DD dd) {
        DdDTO dto = new DdDTO();
        // Set the properties of the DdDTO based on the Dd entity
        dto.setId(dd.getId());
        //dto.setName(dd.getName());
        // Set other properties as needed
        return dto;
    }

    public DD convertToEntity(DdDTO dto) {
        DD dd = new DD();
        // Set the properties of the Dd entity based on the DdDTO
        dd.setId(dto.getId());
        //dd.setName(dto.getName());
        // Set other properties as needed
        return dd;
    }

	public List<DdDTO> convertToDTOList(List<DD> ddList) {
		// TODO Auto-generated method stub
		return null;
	}
}
