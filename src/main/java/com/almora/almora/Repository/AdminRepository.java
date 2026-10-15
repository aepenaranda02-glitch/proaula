package com.almora.almora.Repository;

import com.almora.almora.Model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {

}
