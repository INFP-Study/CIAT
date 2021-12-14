package com.infp.ciat.nongsaro.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "response")
public class NongsaroDetailDto {

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

        private String cntntsNo;                       // 컨텐츠 번호
        private String plntbneNm;                      // 식물학 명
        private String plntzrNm;                       // 식물영 명
        private String distbNm;                        // 유통 명
        private String fmlNm;                          // 과 명
        private String fmlCodeNm;                      // 과 코드명
        private String orgplceInfo;                    // 원산지 정보
        private String adviseInfo;                     // 조언 정보
        private String imageEvlLinkCours;              // 이미지 평가 링크 경로
        private String growthHgInfo;                   // 성장 높이 정보
        private String growthAraInfo;                  // 성장 넓이 정보
        private String lefStleInfo;                    // 잎 형태 정보
        private String smellCode;                      // 냄새 코드
        private String smellCodeNm;                    // 냄새 코드 명
        private String toxctyInfo;                     // 독성 정보
        private String prpgtEraInfo;                   // 번식 시기 정보
        private String etcEraInfo;                     // 기타 시기 정보
        private String managelevelCode;                // 관리수준 코드
        private String managelevelCodeNm;              // 관리수준 코드명
        private String grwtveCode;                     // 생장속도 코드
        private String grwtveCodeNm;                   // 생장속도 코드명
        private String grwhTpCode;                     // 생육 온도 코드
        private String grwhTpCodeNm;                   // 생육 온도 코드명
        private String winterLwetTpCode;               // 겨울 최저 온도 코드
        private String winterLwetTpCodeNm;             // 겨울 최저 온도 코드명
        private String hdCode;                         // 습도 코드
        private String hdCodeNm;                       // 습도 코드명
        private String frtlzrInfo;                     // 비료 정보
        private String soilInfo;                       // 토양 정보
        private String watercycleSprngCode;            // 물주기 봄 코드
        private String watercycleSprngCodeNm;          // 물주기 봄 코드명
        private String watercycleSummerCode;           // 물주기 여름 코드
        private String watercycleSummerCodeNm;         // 물주기 여름 코드명
        private String watercycleAutumnCode;           // 물주기 가을 코드
        private String watercycleAutumnCodeNm;         // 물주기 가을 코드명
        private String watercycleWinterCode;           // 물주기 겨울 코드
        private String watercycleWinterCodeNm;         // 물주기 겨울 코드명
        private String dlthtsManageInfo;               // 병충해 관리 정보
        private String speclmanageInfo;                // 특별관리 정보
        private String fncltyInfo;                     // 기능성 정보기능성
        private String flpodmtBigInfo;                 // 화분직경 대 정보
        private String flpodmtMddlInfo;                // 화분직경 중 정보
        private String flpodmtSmallInfo;               // 화분직경 소 정보
        private String WIDTH_BIG_INFO;                 // 가로 대 정보
        private String widthMddlInfo;                  // 가로 중 정보
        private String widthSmallInfo;                 // 가로 소 정보
        private String vrticlBigInfo;                  // 세로 대 정보
        private String vrticlMddlInfo;                 // 세로 중 정보
        private String vrticlSmallInfo;                // 세로 소 정보
        private String hgBigInfo;                      // 높이 대 정보
        private String hgMddlInfo;                     // 높이 중 정보
        private String hgSmallInfo;                    // 높이 소 정보
        private String volmeBigInfo;                   // 볼륨 대 정보
        private String volmeMddlInfo;                  // 볼륨 중 정보
        private String volmeSmallInfo;                 // 볼륨 소 정보
        private String pcBigInfo;                      // 가격 대 정보
        private String pcMddlInfo;                     // 가격 중 정보
        private String pcSmallInfo;                    // 가격 소 정보
        private String managedemanddoCode;             // 관리요구도 코드
        private String managedemanddoCodeNm;           // 관리요구도 코드명
        private String clCode;                         // 분류 코드(콤마(,)로 구분)
        private String clCodeNm;                       // 분류 코드명(콤마(,)로 구분)
        private String grwhstleCode;                   // 생육형태 코드(콤마(,)로 구분)
        private String grwhstleCodeNm;                 // 생육형태 코드명(콤마(,)로 구분)
        private String indoorpsncpacompositionCode;    // 실내정원구성 코드(콤마(,)로 구분)
        private String indoorpsncpacompositionCodeNm;  // 실내정원구성 코드명(콤마(,)로 구분)
        private String eclgyCode;                      // 생태 코드(콤마(,)로 구분)
        private String eclgyCodeNm;                    // 생태 코드명(콤마(,)로 구분)
        private String lefmrkCode;                     // 잎무늬 코드(콤마(,)로 구분)
        private String lefmrkCodeNm;                   // 잎무늬 코드명(콤마(,)로 구분)
        private String lefcolrCode;                    // 잎색 코드(콤마(,)로 구분)
        private String lefcolrCodeNm;                  // 잎색 코드명(콤마(,)로 구분)
        private String ignSeasonCode;                  // 발화 계절 코드(콤마(,)로 구분)
        private String ignSeasonCodeNm;                // 발화 계절 코드명(콤마(,)로 구분)
        private String flclrCode;                      // 꽃색 코드(콤마(,)로 구분)
        private String flclrCodeNm;                    // 꽃색 코드명(콤마(,)로 구분)
        private String fmldeSeasonCode;                // 과일 계절(콤마(,)로 구분)
        private String fmldeSeasonCodeNm;              // 과일 계절(콤마(,)로 구분)
        private String fmldecolrCode;                  // 과일색 코드(콤마(,)로 구분)
        private String fmldecolrCodeNm;                // 과일색 코드명(콤마(,)로 구분)
        private String prpgtmthCode;                   // 번식방법 코드(콤마(,)로 구분)
        private String prpgtmthCodeNm;                 // 번식방법 코드명(콤마(,)로 구분)
        private String lighttdemanddoCode;             // 광요구도 코드(콤마(,)로 구분)
        private String lighttdemanddoCodeNm;           // 광요구도 코드명(콤마(,)로 구분)
        private String postngplaceCode;                // 배치장소 코드(콤마(,)로 구분)
        private String postngplaceCodeNm;              // 배치장소 코드명(콤마(,)로 구분)
        private String dlthtsCode;                     // 병충해 코드(콤마(,)로 구분)
        private String dlthtsCodeNm;                   // 병충해 코드(콤마(,)로 구분)

    }
}
