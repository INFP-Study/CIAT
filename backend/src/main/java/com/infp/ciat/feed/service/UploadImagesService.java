package com.infp.ciat.feed.service;

import com.amazonaws.SdkClientException;
import com.infp.ciat.feed.controller.dto.CreateFeedRequestForm;
import com.infp.ciat.common.aws.S3Helper;
import com.infp.ciat.common.exceptions.FailCreateFeed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UploadImagesService {
    private String bucket_name;

    @Autowired
    private S3Helper s3Helper;

    @Autowired
    public UploadImagesService(@Value("${cloud.aws.s3.bucket}") String bucket_name) {
        this.bucket_name = bucket_name;
    }

    /***
     * 이미지 업로드
     */
    public List<String> upload(CreateFeedRequestForm requestForm) throws FailCreateFeed {
        List<String> results = new ArrayList<>();

        log.info("--- file upload start ---");
        List<MultipartFile> files = requestForm.getMultipartHttpServletRequest().getFiles("file");
        if(!files.isEmpty()){
            for(MultipartFile file : files){
                log.info(String.format("to upload file: %s", file.getOriginalFilename()));
                try{
                    String uploaded_s3url = s3Helper.uploadFile(bucket_name, file);
                    log.debug(String.format("%s file upload is success. url is: %s", bucket_name, uploaded_s3url));

                    results.add(uploaded_s3url);
                }catch(SdkClientException | IOException e){
                    log.error(String.format("File Upload failed and exception: %s", e.toString()));
                    throw new FailCreateFeed("이미지 업로드 실패");
                }
            }
        }
        log.info("--- file upload done ---");
        return results;
    }

    /***
     * 이미지 삭제
     */
    public void Delete() {

    }


    public void getById() {

    }
}
