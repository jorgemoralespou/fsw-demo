package com.example.switchyard.bindy;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "\\|")
public class Student {

	@DataField(pos = 1, defaultValue="xxx", required=false)
	private String Id;

	@DataField(pos = 2, defaultValue="xxx", required=false)
	private String name;

	@DataField(pos = 3, defaultValue="xxx", required=false)
	private String semester;

	@DataField(pos = 4, defaultValue="0", required=false)
	private int javaMarks;

	@DataField(pos = 5, defaultValue="0", required=false)
	private int cMarks;

	@DataField(pos = 6, defaultValue="0", required=false)
	private int dbmsMarks;

	@DataField(pos = 7, defaultValue="0", required=false)
	private int mathematicsMarks;
	
	@DataField(pos = 8, defaultValue="0", required=false)
	private int dataStructureMarks;

	public int getDataStructureMarks() {
		return dataStructureMarks;
	}

	public void setDataStructureMarks(int dataStructureMarks) {
		this.dataStructureMarks = dataStructureMarks;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public long getJavaMarks() {
		return javaMarks;
	}

	public void setJavaMarks(int javaMarks) {
		this.javaMarks = javaMarks;
	}

	public int getcMarks() {
		return cMarks;
	}

	public void setcMarks(int cMarks) {
		this.cMarks = cMarks;
	}

	public int getDbmsMarks() {
		return dbmsMarks;
	}

	public void setDbmsMarks(int dbmsMarks) {
		this.dbmsMarks = dbmsMarks;
	}

	public int getMathematicsMarks() {
		return mathematicsMarks;
	}

	public void setMathematicsMarks(int mathematicsMarks) {
		this.mathematicsMarks = mathematicsMarks;
	}

	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", semester="+ semester + "]";
	}
	
	 
}
