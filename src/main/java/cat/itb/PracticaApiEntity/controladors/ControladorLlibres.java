package cat.itb.PracticaApiEntity.controladors;

import cat.itb.PracticaApiEntity.model.serveis.ServeiLlibres;
import cat.itb.PracticaApiEntity.model.entitats.Llibre;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControladorLlibres {
    private final ServeiLlibres serveiLlibres;

    //TODO
    //Amb l'exemple de l'altre controlador cal canviar el retorn d'aquests endpoints
    //pel seu corresponent retornant un ResponseEntity


    /*  exemple de control cors a nivell de mètode  */
    @CrossOrigin(origins="http://localhost:9001")
    @GetMapping("/llibres")
    public List<Llibre> llistarLlibres(@RequestParam (value= "cost", required=false) String cost){
        if(cost ==null){
            return serveiLlibres.llistarLlibres();
        }
        else return serveiLlibres.llistatPerCostMenorA(Double.parseDouble(cost));
    }


    //requestparam are required by default
    //l'endpoint és únic, crea ambigüitat
//    @GetMapping("/usuaris")
//    public List<Usuari> llistarMenorsAUnSou(@RequestParam (value="sou") double sou){
//        return serveiUsuaris.llistatPerSouMenorA(sou);
//    }



    @GetMapping("/llibres/{id}")
    public Llibre consultarUsuari(@PathVariable String id)
    {
        return serveiLlibres.consultarLlibre(id);
    }

    @GetMapping("/llibres/genere/{cost}")
    public List<Llibre> llistarUsuarisPerRol(@PathVariable String genere){
        return serveiLlibres.llistarLlibresPerCost(genere);
    }

    @GetMapping("/llibres/comptar/{genere}")
    public long comptarPerGenere(@PathVariable String genere){
        return serveiLlibres.comptarPerGenere(genere);
    }



    @PostMapping("/llibres")
    public Llibre crearLlibre(@RequestBody Llibre nou){
        return serveiLlibres.afegirLlibre(nou);
    }

    @DeleteMapping("/llibres/{id}")
    public Llibre eliminarLlibre(@PathVariable String id){
        return serveiLlibres.eliminarLlibre(id);
    }

    //per modificar un usuari existent
    @PutMapping("/llibres")
    public Llibre modificarLlibre(@RequestBody Llibre mod){
       return serveiLlibres.modificarLlibre(mod);
    }

}
