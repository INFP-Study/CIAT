package com.infp.ciat.common.aws;

import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Component
@Slf4j
public class S3Helper {
    @Autowired
    private AmazonS3Client amazonS3Client;

    /***
     * 파일 업로드
     * 예외처리는 호출한곳에서 처리
     * @param bucket_name
     * @param file
     */
    public String uploadFile(String bucket_name, MultipartFile file) throws SdkClientException, IOException{
        // todo bucket이 존재하지 않으면 오류처리
//        if (!amazonS3.doesBucketExistV2(bucket_name)) {
//            throw new IllegalAccessException(String.format(("%s bucket is not exist")));
//        }
        String fileName = UUID.randomUUID() + file.getOriginalFilename();
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(file.getSize());

        // 파일 업로드
        PutObjectResult putObjectResult = amazonS3Client.putObject(bucket_name, fileName, file.getInputStream(), metadata);
        URL uploaded_s3url = amazonS3Client.getUrl(bucket_name, fileName);
        return uploaded_s3url.toString();
    }
}
