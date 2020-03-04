package ec.com.omicron.autoseguro.models;

import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import com.couchbase.client.java.repository.annotation.Field;
import com.couchbase.client.java.repository.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Leonardo Tomalo.
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Datos {
	@Id @GeneratedValue(strategy = GenerationStrategy.UNIQUE) private String id;
	@Field private Double latitud;
	@Field private Double longitud;
	@Field private Boolean puerta1;
	@Field private Boolean puerta2;
	@Field private Boolean puerta3;
	@Field private Boolean puerta4;
	@Field private Boolean puerta5;
	
}
