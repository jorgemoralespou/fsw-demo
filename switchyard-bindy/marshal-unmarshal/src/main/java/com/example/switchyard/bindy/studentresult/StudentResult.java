package com.example.switchyard.bindy.studentresult;

import java.io.Serializable;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = "\\|")
public class StudentResult implements Serializable{

	private static final long serialVersionUID = 1L;

	@DataField(pos = 1, required = true)
	private String id;
	
	@DataField(pos = 2, required = true)
	private String name;
	
	@DataField(pos = 3, required = true)
	private String semester;
	
	@DataField(pos = 4, required = true)
	private String grade;
	
	@DataField(pos = 5, required = true)
	private long totalScore ;
	
	@DataField(pos = 6, required = true)
	private String result ;
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	public String getGrade() {
		return grade;
	}
	
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	public long getTotalScore() {
		return totalScore;
	}
	
	public void setTotalScore(long totalScore) {
		this.totalScore = totalScore;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	@Override
	public String toString() {
		return "StudentResult [id=" + id + ", name=" + name + ", semester="
				+ semester + ", grade=" + grade + ", totalScore=" + totalScore
				+ ", result=" + result + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentResult other = (StudentResult) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
