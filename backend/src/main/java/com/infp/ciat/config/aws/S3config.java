package com.infp.ciat.config.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3config {
    private String access_key;
    private String secret_key;
    private String region;

    @Autowired
    public S3config(
            @Value("${cloud.aws.credentials.accessKey}") String access_key,
            @Value("${cloud.aws.credentials.secretKey}") String secret_key,
            @Value("${cloud.aws.region.static}") String region
    ) {
        this.access_key = access_key;
        this.secret_key = secret_key;
        this.region = region;
    }

    @Bean
    public AmazonS3Client amazonS3Client() {
        BasicAWSCredentials basicAWSCredentials = new BasicAWSCredentials(access_key, secret_key);
        return (AmazonS3Client) AmazonS3ClientBuilder.standard()
                .withRegion(region)
                .withCredentials(new AWSStaticCredentialsProvider(basicAWSCredentials))
                .build();
    }
}
