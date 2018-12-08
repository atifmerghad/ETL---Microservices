package org.atif.web;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.atif.bo.Dataset;
import org.atif.dao.DatasetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@CrossOrigin(origins = "http://localhost:4200")
@RefreshScope
@RestController
@Service
public class FileController {

	@Autowired
	private DatasetRepository datasetRepository;
	
	public DatasetRepository getDatasetRepository() {
		return datasetRepository;
	}
	
	private static String UPLOADED_FOLDER  = "/Users/atif/";
	
	

	
	@PostMapping(value="/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) 
    public String singleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
	byte[] bytes = file.getBytes();
    Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
    Files.write(path, bytes);
    String name = file.getOriginalFilename();
    int dot = name.lastIndexOf('.');
    String base = (dot == -1) ? name : name.substring(0, dot);
    String extension = (dot == -1) ? "" : name.substring(dot+1);
    Dataset d = new Dataset(null,base, extension);
    datasetRepository.save(d);
    return "ok";
	}
	
	
	
}
