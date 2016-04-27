package com.ga.repository;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.ga.exception.NewGAException;

/**
 * The Interface ICommentsService.
 *
 * @author Smit
 */
public interface ICommentsService {

	/**
	 * Upload file.
	 *
	 * @param filePath
	 *            the file path
	 * @param comments
	 *            the comments
	 * @param userID
	 *            the user id
	 * @return true, if successful
	 * @throws GAException
	 *             the GA exception
	 */
	String uploadFile(MultipartFile f) throws NewGAException, IOException;
}
