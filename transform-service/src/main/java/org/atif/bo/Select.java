package org.atif.bo;

import java.io.File;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Select {

	private File file;
	
	public Dataset<Row> spark(File file) {
		SparkSession spark = SparkSession.builder().master("local[8]").appName("Atif App").getOrCreate();
		String filePath = "/Users/atif/Projects/StsPorjects/spark-test/src/main/java/file.csv";
		Dataset<Row>  df = spark.read().format("com.databricks.spark.csv").option("delimiter", ";").option("header", "true").option("inferSchema", true).load(filePath);
		return df;
	
	}
	
	public String[] getColumns(Dataset<Row> df){
		return df.columns();
	}
	
}
