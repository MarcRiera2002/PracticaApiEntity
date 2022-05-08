package cat.itb.PracticaApiEntity.model.entitats;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Llibre {
    @Id
    private String idLlibre;
    private String nomLlibre;
    private String genere;
    private double cost;
    private double puntuacio;
    private double pagines;
}




