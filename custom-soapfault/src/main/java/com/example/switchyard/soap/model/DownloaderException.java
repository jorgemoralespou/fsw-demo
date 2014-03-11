package com.example.switchyard.soap.model;

import javax.xml.ws.WebFault;

@WebFault(name = "DownloaderException", targetNamespace = "urn:com.example.switchyard:soap:1.0")
public class DownloaderException extends Exception {
    
    private com.example.switchyard.soap.model.DownloaderExceptionDetails details;

    public DownloaderException() {
        super();
    }
    
    public DownloaderException(String message) {
        super(message);
    }
    
    public DownloaderException(String message, Throwable cause) {
        super(message, cause);
    }

    public DownloaderException(String message, com.example.switchyard.soap.model.DownloaderExceptionDetails downloaderException) {
        super(message);
        this.details = downloaderException;
    }

    public DownloaderException(String message, com.example.switchyard.soap.model.DownloaderExceptionDetails downloaderException, Throwable cause) {
        super(message, cause);
        this.details = downloaderException;
    }

    public void setFaultInfo(DownloaderExceptionDetails details) {
        this.details = details;
    }

    public com.example.switchyard.soap.model.DownloaderExceptionDetails getFaultInfo() {
        return this.details;
    }
}
