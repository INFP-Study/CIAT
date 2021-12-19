package com.infp.ciat.nongsaro.dto;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class NongsaroListDto {
    private Header header;
    private Body body;

    @Data
    @XmlRootElement(name = "header")
    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    @XmlRootElement(name = "body")
    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Body {

        @XmlElementWrapper(name = "items")
        @XmlElement(name = "item")
        private List<Item> items;
        private String numOfRows;
        private String pageNo;
        private String totalCount;

    }

    @Data
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "item")
    static public class Item {

        private String cntntsNo;            // 컨텐츠 번호
        private String cntntsSj;            // 식물명
        private String rtnFileSeCode;       // 파일구분코드
        private String rtnFileSn;           // 파일순번
        private String rtnOrginlFileNm;     // 원본 파일명
        private String rtnStreFileNm;       // 저장 파일명
        private String rtnFileCours;        // 파일경로
        private String rtnImageDc;          // 이미지설명
        private String rtnThumbFileNm;      // 섬네일파일명
        private String rtnImgSeCode;        // 이미지구분코드

    }
}
