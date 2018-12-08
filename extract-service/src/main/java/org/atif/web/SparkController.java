package org.atif.web;

import java.util.ArrayList;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.atif.bo.Spark;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "http://localhost:4200")
@RefreshScope
@RestController
@Service
public class SparkController {
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/cols")
	public String[] cols() {
		return Spark.spark(null);
	}
	
	@GetMapping("/rows")
	public List<String> rows() {
		
		return Spark.sparkr(null);
	}
}
