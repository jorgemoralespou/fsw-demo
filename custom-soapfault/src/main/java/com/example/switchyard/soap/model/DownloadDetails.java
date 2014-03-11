package com.example.switchyard.soap.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>Java class for downloadDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="downloadDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="downloadPath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numOfFiles" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "downloadDetails", propOrder = {
    "downloadPath",
    "numOfFiles"
})
public class DownloadDetails {
	private String downloadPath;
	private int numOfFiles;
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public int getNumOfFiles() {
		return numOfFiles;
	}
	public void setNumOfFiles(int numOfFiles) {
		this.numOfFiles = numOfFiles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((downloadPath == null) ? 0 : downloadPath.hashCode());
		result = prime * result + numOfFiles;
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
		DownloadDetails other = (DownloadDetails) obj;
		if (downloadPath == null) {
			if (other.downloadPath != null)
				return false;
		} else if (!downloadPath.equals(other.downloadPath))
			return false;
		if (numOfFiles != other.numOfFiles)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DownloadDetails [downloadPath=" + downloadPath
				+ ", numOfFiles=" + numOfFiles + "]";
	}
	
}
