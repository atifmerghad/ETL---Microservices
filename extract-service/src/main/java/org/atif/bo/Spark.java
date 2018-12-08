package org.atif.bo;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Spark {

	public static String[] spark(File file) {
		SparkSession spark = SparkSession.builder().master("local[8]").appName("Atif App").getOrCreate();
		String filePath = "/Users/atif/Desktop/Brexia/file.csv";
		Dataset<Row>  df = spark.read().format("com.databricks.spark.csv").option("delimiter", ";").option("header", "true").option("inferSchema", true).load(filePath);
	 
		return df.columns();
	}
	
	public static List<String> sparkr(File file) {
		SparkSession spark = SparkSession.builder().master("local[8]").appName("Atif App").getOrCreate();
		String filePath = "/Users/atif/Desktop//file1.csv";
		Dataset<Row>  df = spark.read().format("com.databricks.spark.csv").option("delimiter", ";").option("header", "true").option("inferSchema", true).load(filePath);	
	
		return df.toJSON().collectAsList();
	};
}
