package com.infp.ciat.nongsaro.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class NongsaroSearchDto {

    private String sType;               // 검색구분
    private String sText;               // 검색어
    private String wordType;            // 자음구분
    private String word;                // 자음        예) ㄱ & ㄴ & A & B 등 선택
    private String lightChkVal;         // 광도요구     예) 055001,055002 와 같이 콤마(,)로 구분
    private String grwhstleChkVal;      // 생육형태     예) 054001,054002 와 같이 콤마(,)로 구분
    private String lefcolrChkVal;       // 잎색        예) 069001,069002 와 같이 콤마(,)로 구분
    private String lefmrkChkVal;        // 잎무늬       예) 070001,070002 와 같이 콤마(,)로 구분
    private String flclrChkVal;         // 꽃색        예) 071001,071002 와 같이 콤마(,)로 구분
    private String fmldecolrChkVal;     // 열매색       예) 081001,081002 와 같이 콤마(,)로 구분
    private String ignSeasonChkVal;     // 꽃피는 계절   예) 073001,073002 와 같이 콤마(,)로 구분
    private String winterLwetChkVal;    // 겨울 최저온도  예) 057001,057002 와 같이 콤마(,)로 구분
    private String priceType;           // 가격대 구분
    private String priceTypeSel;        // 가격대
    private String waterCycleSel;       // 물주기
    private String pageNo = "1";        // 조회할 페이지 번호
    private String numOfRows = "10";    // 한 페이지에 제공할 건수

}
