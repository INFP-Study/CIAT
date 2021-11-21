package com.infp.ciat.board.service;

import com.infp.ciat.board.dto.CreateBoardRequestForm;
import com.infp.ciat.common.aws.S3Helper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
     * 파일 업로드
     */
    public void Upload(CreateBoardRequestForm requestForm){
        log.info("--- file upload start ---");
        List<MultipartFile> files = requestForm.getMultipartHttpServletRequest().getFiles("file");
        if(!files.isEmpty()){
            for(MultipartFile file : files){
                log.info(String.format("to upload file: %s", file.getOriginalFilename()));
                s3Helper.uploadFile(bucket_name, file);
            }
        }
        log.info("--- file upload done ---");
    }
}
