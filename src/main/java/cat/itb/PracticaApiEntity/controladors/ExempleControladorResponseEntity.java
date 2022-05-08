package cat.itb.PracticaApiEntity.controladors;

import cat.itb.PracticaApiEntity.model.serveis.ServeiLlibres;
import cat.itb.PracticaApiEntity.model.entitats.Llibre;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ExempleControladorResponseEntity {

private final ServeiLlibres serveiLlibres;

    //proves amb un altre endpoint per consultar usuari
    //si l'id d'usuari no existeix es retorna 404 Not Found

    @GetMapping("/llibre/{id}")
    public ResponseEntity<?> consultarLlibre(@PathVariable String id) {
        Llibre res = serveiLlibres.consultarLlibre(id);
        if (res == null) return ResponseEntity.notFound().build();
        else return ResponseEntity.ok(res);
    }

    //si es pot crear es retorna CREATED
    @PostMapping("/llibre")
    public ResponseEntity<?> crearLlibre(@RequestBody Llibre nou){
        Llibre res= serveiLlibres.afegirLlibre(nou);
        return new ResponseEntity<Llibre>(res, HttpStatus.CREATED);
    }



}
