package cat.itb.PracticaApiEntity.model.serveis;

import cat.itb.PracticaApiEntity.model.repositoris.RepositoriLlibre;
import cat.itb.PracticaApiEntity.model.entitats.Llibre;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ServeiLlibres {
    private final RepositoriLlibre repoLlibres;

    //llistar tots els ítems
    public List<Llibre> llistarLlibres(){

        return repoLlibres.findAll();
    }


    public List<Llibre> llistarLlibresPerCost(String genere){
        return repoLlibres.findByGenere(genere);
    }

    public long comptarPerGenere(String genere){
        return repoLlibres.countByGenere(genere);
    }

    public List<Llibre> llistatPerCostMenorA(double cost){
        return repoLlibres.findByCostLessThan(cost);
    }

    //consultar ítem per id
    public Llibre consultarLlibre(String id){
        return repoLlibres.findById(id).orElse(null);
    }

    //afegir ítem
    public Llibre afegirLlibre(Llibre it){
       return repoLlibres.save(it);
    }

    //modificar sencer, si existeix el canvia, sino retorna null
    public Llibre modificarLlibre(Llibre llibre){
        Llibre aux=null;
        if(repoLlibres.existsById(llibre.getIdLlibre())) aux= repoLlibres.save(llibre);
        return aux;
    }

    //eliminar ítem per id
    //si no existeix id retorna null
    public Llibre eliminarLlibre(String id){
        Llibre res= repoLlibres.findById(id).orElse(null);
        if(res!=null) repoLlibres.deleteById(id);
        return res;
    }

}
