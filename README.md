
# 🌱반려식물 관리 및 커뮤니티 씨앗(CIAT)🌱

![undraw_Gardening_eaf3](https://user-images.githubusercontent.com/64685759/141408953-b226d445-3ac1-4e25-a6e7-0ed7502b41dc.png)

## CIAT 프로젝트
### 주요 기능
|홈|식물관리|
|---|---|
|img|img|

|로그인|게시판|
|---|---|
|img|img|

### 게스트 로그인🔑
```
id : 
pw :
```


## 프로젝트 폴더 구조

### frontend💻
```
├─config
│ └─webpack.config.js
├─public
│ ├─index.html (기본 HTML)
│ └─favicon.ico (파비콘)
├─src
│ ├─assets (이미지, 폰트 등)
│ ├─components (컴포넌트 like view)
│ ├─constants (상수, 라우트 경로)
│ ├─hooks (커스텀 훅)
│ ├─styles (글로벌 스타일)
│ ├─lib (리액트 라우터, styled-components)
│ ├─pages (페이지)
│ ├─saga (saga 함수)
│ ├─store (redux 모듈)
│ ├─styles (글로벌 스타일)
│ ├─utils (공통 유틸 함수)
│ │ └─api (api axios 요청)
│ └─index.js
├─.babelrc
├─.eslintrc.json
├─.prettierrc
├─.jsconfig.json
├─package.json
└─yarn.lock
```

### backend👨‍💻
```
├─build (프로젝트 빌드 결과)
├─src (소스코드)
│   ├─main
│   │   ├─java
│   │   │   └─com
│   │   │       └─infp
│   │   │           └─ciat
│   │   │               ├─board (게시판 패키지)
│   │   │               ├─common (공통 패키지)
│   │   │               ├─config (설정 패키지)
│   │   │               ├─plant (식물 패키지)
│   │   │               └─user (사용자 패키지)
│   │   └─resources
│   │       └─application.yml (스프링 프로파일)
│   └─test (테스트 소스코드)
├─gradlew (gradlew 실행파일)
├─gradlew.bat (gradlew 실행파일)
├─settings.gradle (gradlew 설정파일)
└─build.gradle (gradlew 설정파일)
```

### Database ERD
```
...
```

## 실행 방법

### 클라이언트 실행
```js
cd frontend
yarn install
yarn start

```
### 서버 실행
```
...
```

## 프로젝트 산출물

#### [📙 WiKi](https://github.com/INFP-Study/CIAT/wiki)
#### [🎯 Project Kanban Board](https://github.com/INFP-Study/CIAT/projects/1)
#### [🎨 Figma](https://www.figma.com/file/4C7izPnx0Y5NtrANroPvTX/ciat?node-id=0%3A1)

## 프로젝트 기여자
|Design🎨|Frontend💻|Backend👨‍💻|DevOps🚊|
|:---|:---|:---|:---|
|[김은혜](https://github.com/eunnhye)|[윤태희](https://github.com/thyoondev)|[구희승](https://github.com/nrudev)|[최성욱](https://github.com/choisungwook)|
| |[이승희](https://github.com/lseunghee)|[최지현](https://github.com/chlwlgus4)|[정세영](https://github.com/claeo001)|
| | |[허영운](https://github.com/yeongunheo)||
| | |[임혜정](https://github.com/HyeJeongIm)||



## 사용 기술
|Design🎨|Frontend💻|Backend👨‍💻|DevOps🚊|
|:---|:---|:---|:---|
|![Figma](https://img.shields.io/badge/Figma-F24E1E?style=for-the-badge&logo=Figma&logoColor=white)|![Javascript](https://img.shields.io/badge/Javascript-ffb13b?style=for-the-badge&logo=javascript&logoColor=white)|![Java](https://img.shields.io/badge/Java-007396?style=for-the-badge&logo=Java&logoColor=white)|![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)|
|![Adobe Photoshop](https://img.shields.io/badge/AdobePhotoshop-31A8FF?style=for-the-badge&logo=AdobePhotoshop&logoColor=white)|![React](https://img.shields.io/badge/react-%2320232a.svg?style=for-the-badge&logo=react&logoColor=%2361DAFB)|![SpringBoot](https://img.shields.io/badge/SpringBoot-6DB33F?style=for-the-badge&logo=Spring&logoColor=white)|![Kubernetes](https://img.shields.io/badge/Kubernetes-326CE5.svg?style=for-the-badge&logo=Kubernetes&logoColor=white)|
| |![Webpack](https://img.shields.io/badge/webpack-%238DD6F9.svg?style=for-the-badge&logo=webpack&logoColor=black)|![MariaDB](https://img.shields.io/badge/MariaDB-003545.svg?style=for-the-badge&logo=MariaDB&logoColor=white)|![Docker](https://img.shields.io/badge/Docker-2496ED.svg?style=for-the-badge&logo=Docker&logoColor=white)|
| |![Babel](https://img.shields.io/badge/Babel-F9DC3E.svg?style=for-the-badge&logo=Babel&logoColor=black)| |![Jenkins](https://img.shields.io/badge/Jenkins-D24939.svg?style=for-the-badge&logo=Jenkins&logoColor=white)|
| |![Ant Design](https://img.shields.io/badge/AntDesign-0170FE?style=for-the-badge&logo=AntDesign&logoColor=white)| | |
| |![Styled Components](https://img.shields.io/badge/styled--components-DB7093?style=for-the-badge&logo=styled-components&logoColor=white)| | |


## LICENSE

[MIT License]() Created by INFP-Study ©2021
![License](https://img.shields.io/github/license/INFP-Study/CIAT)
