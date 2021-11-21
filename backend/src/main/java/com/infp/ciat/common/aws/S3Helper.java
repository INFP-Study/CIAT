package com.infp.ciat.common.aws;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@Slf4j
public class S3Helper {
    @Autowired
    private AmazonS3Client amazonS3Client;

    /***
     * 파일 업로드
     * @param bucket_name
     * @param file
     */
    public void uploadFile(String bucket_name, MultipartFile file) {
        // todo
//        if (!amazonS3.doesBucketExistV2(bucket_name)) {
//            throw new IllegalAccessException(String.format(("%s bucket is not exist")));
//        }
        try {
            String fileName = UUID.randomUUID() + file.getOriginalFilename();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            amazonS3Client.putObject(bucket_name, fileName, file.getInputStream(), metadata);
            log.debug(String.format("%s file upload is success", bucket_name));
        }catch (SdkClientException | IOException e) {
            // todo throw Exception
            log.info("File Uploading exception");
            log.info(e.toString());
        }
    }
}
