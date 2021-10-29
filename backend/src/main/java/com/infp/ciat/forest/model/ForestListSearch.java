package com.infp.ciat.forest.model;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class ForestListSearch {
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

        private String cprtCtnt;        // 저작권
        private String detailYn;        // 상세정보유무
        private String familyKorNm;     // 과국명
        private String familyNm;        // 과명
        private String genusKorNm;      // 속국명
        private String genusNm;         // 속명
        private String imgUrl;          // 이미지 url
        private String frstRgstnDtm;    // 속국명
        private String notRcmmGnrlNm;   // 비추쳔명
        private String plantGnrlNm;     // 국명
        private String plantPilbkNo;       // 도감번호
        private String plantSpecsScnm;  // 정명학명

    }
}
