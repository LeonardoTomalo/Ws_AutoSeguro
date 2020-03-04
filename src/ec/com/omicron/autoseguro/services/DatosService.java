package ec.com.omicron.autoseguro.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.com.omicron.autoseguro.models.Datos;
import ec.com.omicron.autoseguro.repositories.DatosRepository;

@Service
@RestController
@RequestMapping("/datosDispositivo")
public class DatosService {

	@Autowired private DatosRepository repository;

	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(@RequestBody Datos c) {
		try {
			repository.save(c);
		} catch (Exception e) {
			e.printStackTrace();
			return "Post Error..!!";
		}
		return "Post Sucessful..!!";
	}
	
	@PostMapping("/saveOrUpdate/gato")
	public String saveOrUpdate(String c) {
		try {
			String[] array = c.substring(c.indexOf(""), c.lastIndexOf("")).split("&");
			for (String string : array) {
				System.out.println("***********dato: " + string);
			}
			double lat = Double.parseDouble(array[0]);
			double lon = Double.parseDouble(array[1]);
			Boolean p1 = (Integer.parseInt(array[2]) == 1);
			Boolean p2 = (Integer.parseInt(array[3]) == 1);
			Boolean p3 = (Integer.parseInt(array[4]) == 1);
			Boolean p4 = (Integer.parseInt(array[5]) == 1);
			Boolean p5 = (Integer.parseInt(array[6]) == 1);		
			repository.save(new Datos(null, lat, lon, p1, p2, p3, p4, p5));
		} catch (Exception e) {
			e.printStackTrace();
			return "Post Error..!!";			
		}				
		return "Post Sucessful..!!";
	}
		
	@DeleteMapping("/deletePhysical/{c}")
	public void deletePhysical(@PathVariable String c) {	
		repository.deleteById(c);
	}
	
	@GetMapping("/getAll")
	public List<Datos> getAll() {
		return (List<Datos>) repository.findAll();
	}	
	
	@GetMapping("/saveOrUpdate/gato")
	public String getPostGato(String c) {
		try {
			String[] array = c.substring(c.indexOf(""), c.lastIndexOf("")).split("&");
			for (String string : array) {
				System.out.println("***********dato: " + string);
			}
			double lat = Double.parseDouble(array[0]);
			double lon = Double.parseDouble(array[1]);
			Boolean p1 = (Integer.parseInt(array[2]) == 1);
			Boolean p2 = (Integer.parseInt(array[3]) == 1);
			Boolean p3 = (Integer.parseInt(array[4]) == 1);
			Boolean p4 = (Integer.parseInt(array[5]) == 1);
			Boolean p5 = (Integer.parseInt(array[6]) == 1);

			repository.save(new Datos(null, lat, lon, p1, p2, p3, p4, p5));
			
		} catch (Exception e) {
			e.printStackTrace();
			return "Get Error..!!";				
		}
		return "Get Sucessful..!!";	
	}
	
}
