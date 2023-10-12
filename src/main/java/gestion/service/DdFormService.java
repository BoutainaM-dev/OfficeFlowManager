package gestion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gestion.dao.DdDao;
import gestion.dto.DdDTO;
import gestion.model.DD; // Make sure to import the DD entity class here

@Service
public class DdFormService {

    private final DdDao ddDao; // Correct the variable name here

    @Autowired
    public DdFormService(DdDao ddDao) {
        this.ddDao = ddDao;
    }

    public void saveFormData(DdDTO formData) {
        // Perform any business logic if needed
        // You can also do validation or additional data processing here

        // Create an instance of the DD entity and map the relevant fields from the DTO
        DD dd = new DD();
        dd.setMotif(formData.getMotif());
        dd.setProjet(formData.getProjet());
        dd.setDateDepart(formData.getDateDepart());
        dd.setDateRetour(formData.getDateRetour());
        dd.setDestination(formData.getDestination());
        dd.setMoyenTransport(formData.getMoyenTransport());
        dd.setHebergement(formData.getHebergement());
        dd.setActivites(formData.getActivites());
        dd.setAvance(formData.getAvance());

        // Save the form data to the database through the DAO
        ddDao.save(dd);
    }
}
