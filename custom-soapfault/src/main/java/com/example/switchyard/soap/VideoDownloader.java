package com.example.switchyard.soap;

import com.example.switchyard.soap.model.DownloadDetails;
import com.example.switchyard.soap.model.DownloaderException;
import com.example.switchyard.soap.model.VideoDetails;

public interface VideoDownloader {
	DownloadDetails download(VideoDetails details) throws DownloaderException;

	DownloadDetails listDownloadDetails(VideoDetails details) throws DownloaderException;
}
