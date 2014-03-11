package com.example.switchyard.soap;

import org.switchyard.component.bean.Service;

import com.example.switchyard.soap.model.DownloadDetails;
import com.example.switchyard.soap.model.DownloaderException;
import com.example.switchyard.soap.model.DownloaderExceptionDetails;
import com.example.switchyard.soap.model.VideoDetails;

@Service(VideoDownloader.class)
public class VideoDownloaderBean implements VideoDownloader {

	@Override
	public DownloadDetails download(VideoDetails details)
			throws DownloaderException {
		System.out.println("================= IN download: " + details);
		
		if (details.getTimeout()<0){
			DownloaderException e =  new DownloaderException("Timeout can not be less than 0");
			e.setFaultInfo(new DownloaderExceptionDetails(details.getVideoUrl()));
			throw e;
		}

		
		DownloadDetails download = new DownloadDetails();
		return download;
	}

	@Override
	public DownloadDetails listDownloadDetails(VideoDetails details)
			throws DownloaderException {
		System.out.println("================= IN listDownloadDetails");
		
		DownloadDetails download = new DownloadDetails();
		return download;
	}

}
