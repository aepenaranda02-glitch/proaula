package com.almora.almora.Services;

import com.almora.almora.Model.Donante;
import java.util.List;
import java.util.Optional;

public interface DonanteService {

    Donante saveDonante(Donante donante);

    List<Donante> getAllDonantes();

    Optional<Donante> getDonanteById(String id); // Cambié Integer → String

    Donante updateDonante(String id, Donante updated);

    void deleteDonante(String id); // Cambié Integer → String
}
