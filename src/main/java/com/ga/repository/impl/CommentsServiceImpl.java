package com.ga.repository.impl;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.ga.common.ClientErrorCodes;
import com.ga.exception.NewGAException;
import com.ga.repository.ICommentsService;

/**
 * The Class CommentsServiceImpl.
 *
 * @author Nilay
 */
@Service
@Transactional
@PropertySource("classpath:dev.properties")
public class CommentsServiceImpl implements ICommentsService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentsServiceImpl.class);

  
    
    final Properties props = new Properties();
    InputStream input = null;

    String filename = "dev.properties";
    
    @Override
    public String uploadFile(MultipartFile multipartFile) throws NewGAException, IOException {
        LOGGER.info("Upload file called!!");
        String fileName = checkIsFile(multipartFile);
        if (fileName.isEmpty()) {
            LOGGER.info("File is empty!!");
            throw new NewGAException(ClientErrorCodes.GA_FILE_UPLOAD_FAILED);
        }
        LOGGER.info(String.format("Upload file complete!! File path : %s", fileName));
        return fileName;
    }

    private String checkIsFile(MultipartFile file) throws IOException, NewGAException {
        LOGGER.info("Checkfile is called!!");
        if (!file.isEmpty()) {
            byte[] bytes = file.getBytes();
            String filename = file.getOriginalFilename();
            Long f = new Date().getTime();

            LOGGER.info("filename :" + filename);
            String[] sli = filename.split("\\.");
            /* print substrings */
            LOGGER.info("extension :" + sli[sli.length - 1]);
            File newFile = new File("C:/Program Files (x86)/Tomcat 7.0/webapps/myImages/" +f + "." + sli[sli.length - 1]);
                LOGGER.info("newFile :" + newFile);
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(newFile));
                //LOGGER.info("newFile :" + newFile);

                bufferedOutputStream.write(bytes);
                bufferedOutputStream.close();
                LOGGER.info("return file :" + newFile.getName());
           
            return newFile.getName();

        } else {
            LOGGER.info("checkIsFile return false:");
            throw new NewGAException(ClientErrorCodes.GA_DATA_NOT_FOUND);
        }
    }
}