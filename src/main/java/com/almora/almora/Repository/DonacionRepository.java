package com.almora.almora.Repository;

import com.almora.almora.Model.Donacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DonacionRepository extends MongoRepository<Donacion, String> {
}