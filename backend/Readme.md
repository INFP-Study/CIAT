# 실행 준비
* 이 프로젝트에서 연동된 데이터베이스정보 등 등록이 필요합니다.
* CIAT repo에 등록된 멤버는 git submodule에 접근정보를 얻을 수 있습니다.
```sh
git submodule update --init --recursive
```
<!-- ```sh
git submodule update --recursive --remote --merge --force
``` -->
## 스프링부트 프로파일 템플릿
* 이 템플릿은 외부사용자를 위한 설명입니다.
```yaml
server:
  port: 9400
  servlet:
    session:
      cookie:
        http-only: false
        secure: false
jwt:
  secret: <jwt 시크릿키>

logging:
  level:
    com:
      infp:
        ciat: debug
      amazonaws:
        util:
          EC2MetadataUtils: error

spring:
  servlet:
    multipart:
      max-file-size: 2MB
      max-request-size: 2MB
  security:
    oauth2:
      client:
        registration:
          google:
            client-id: <google ouath2 client-id>
            client-secret: <google oauth2 secret>
            scope:
              - profile
              - email
  datasource:
    url: <DB 접속주소>
    driver-class-name: org.mariadb.jdbc.Driver
    username: <계정>
    password: <비밀번호>
  jpa:
    open-in-view: false
    generate-ddl: true
    show-sql: true
    hibernate:
      ddl-auto: update
      database-platform: org.hibernate.dialect.MariaDB103Dialect

#공공포탈 api service key, public url
nongsaro:
  url: <공공포탈>
  key: <공공포털 access key>

cloud:
  aws:
    credentials:
      accessKey: <aws iam user accesskey>
      secretKey: <aws iam user secretkey>
    s3:
      bucket: <aws s3 bucket 이름>
    region:
      static: <aws region>
    stack:
      auto: false
```

# 실행
* JVM 실행인자 설정
```sh
# aaws sdk 설정: ec2메타데이터 비활성화
-Dcom.amazonaws.sdk.disableEc2Metadata=true 
```
