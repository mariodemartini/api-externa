package br.com.gd.apiexterna.repositories;

import br.com.gd.apiexterna.entities.AlunoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface AlunoRepository extends MongoRepository<AlunoEntity, String> {
}
