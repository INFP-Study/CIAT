package com.infp.ciat.common.forest.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class ForestDetailIntro {

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

        private Item item;
    }

    @Data
    @XmlRootElement(name = "item")
    @XmlAccessorType(XmlAccessType.FIELD)
    static public class Item {

        private String brdMthdDesc;     // 번식방법
        private String bugInfo;         // 병충해정보
        private String cprtCtnt;        // 저작권
        private String dstrb;           // 분포정보
        private String engNm;           // 영문명
        private String familyKorNm;     // 과국명
        private String familyNm;        // 과명
        private String farmSpftDesc;    // 재배특성
        private String flwrDesc;        // 꽃설명
        private String flwrInfo01;      // 꽃_화서
        private String flwrInfo02;      // 꽃_화수
        private String flwrInfo03;      // 꽃_소수(특징)
        private String flwrInfo04;      // 꽃_소수_포영
        private String flwrInfo05;      // 꽃_소수_소화_(특징)
        private String flwrInfo06;      // 꽃_소수_소화_호영
        private String flwrInfo07;      // 꽃_소수_소화_내용
        private String flwrInfo08;      // 꽃_주두
        private String flwrInfo09;      // 꽃_화피편
        private String fritDesc;        // 열매설명
        private String fritInfo01;      // 열매_과포
        private String gemmaDesc;       // 무성아
        private String genusKorNm;      // 속국명
        private String genusNm;         // 속명
        private String grwEvrntDesc;    // 생육환경설명
        private String imgUrl;          // 이미지 url
    }
}
