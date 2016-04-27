package com.ga.domain.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ga.common.ClientErrorCodes;
import com.ga.common.JsonUtil;
import com.ga.common.LoggerUtility;
import com.ga.common.ServerCodes;
import com.ga.exception.NewGAException;
import com.ga.repository.ICommentsService;

/**
 * The Class CommentsController.
 *
 * @author Nilay
 */
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(FileUploadController.class);

    /** The comments service. */
    @Autowired
    ICommentsService commentsService;

    /**
     * Upload file.
     *
     * @param files the files
     * @return the string
     */
    @RequestMapping(value = "/uploadfile", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String uploadFile(@RequestParam("file") MultipartFile[] files) {
        LOGGER.info(String.format("Upload file called"+files.length));
        List<String> listOfImagePath = new ArrayList<String>();

        try {
            if (files.length <= 0) {
                throw new NewGAException(ClientErrorCodes.GA_MANDATORY_PARAMETER_NOT_FOUND);
            }
            for (MultipartFile multipartFile : files) {
                String filePath = commentsService.uploadFile(multipartFile);
                if (filePath.isEmpty()) {
                    throw new NewGAException(ClientErrorCodes.GA_FILE_UPLOAD_FAILED);
                }
                listOfImagePath.add("/myImages/" + filePath);
                LOGGER.info("Filepath :" + filePath);
            }
            return JsonUtil.getJson(ClientErrorCodes.FILE_UPLOAD_TRANSCATON_SUCCSS, listOfImagePath);
        } catch (NewGAException e) {
            if (e.getCode() == ClientErrorCodes.GA_FILE_UPLOAD_FAILED.getErrorCode()) {
                return JsonUtil.getJson(ClientErrorCodes.GA_FILE_UPLOAD_FAILED, e.getDescription());

            } else if (e.getCode() == ClientErrorCodes.GA_MANDATORY_PARAMETER_NOT_FOUND.getErrorCode()) {
                return JsonUtil.getJson(ClientErrorCodes.GA_MANDATORY_PARAMETER_NOT_FOUND, e.getDescription());

            } else {
                LoggerUtility.error(ServerCodes.GA_INTERNAL, "Error in file upload", e);
                return JsonUtil.getJson(e.getCode(), "Internal error!");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
