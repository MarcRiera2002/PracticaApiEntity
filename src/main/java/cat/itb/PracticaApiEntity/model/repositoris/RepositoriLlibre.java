package cat.itb.PracticaApiEntity.model.repositoris;

import cat.itb.PracticaApiEntity.model.entitats.Llibre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoriLlibre extends JpaRepository<Llibre,String> {
    List<Llibre> findByGenere(String r); //l'atribut rol ha d'existir a la classe Usuari
    long countByGenere(String r);
    List<Llibre> findByCostLessThan(double cost);
}
