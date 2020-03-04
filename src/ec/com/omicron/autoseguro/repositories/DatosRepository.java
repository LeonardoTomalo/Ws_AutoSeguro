package ec.com.omicron.autoseguro.repositories;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbaseRepository;

import ec.com.omicron.autoseguro.models.Datos;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "datos", viewName = "all")
public interface DatosRepository extends CouchbaseRepository<Datos, String>{

}
