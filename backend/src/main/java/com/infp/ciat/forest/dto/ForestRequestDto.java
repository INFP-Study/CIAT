package com.infp.ciat.forest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ForestRequestDto {
    private String st;          //  검색어구분           필   1-국명/2-학명/3-국명일치/4-학명일치
    private String sw;          //  검색어              필   검색대상어
    private String dateGbn;     //  날짜검색구분          옵   빈칸-전체/1-등록일/2-수정일
    private String dateForm;    //  검색시작일	           옵   검색시작일(dateGbn 선택시 필수, YYYYMMDD)
    private String dateTo;      //  검색종료일	           옵   검색종료일(dateGbn 선택시 필수, YYYYMMDD)
    private String numOfRows = "10"; //  한 페이지 결과 수      필
    private String pageNo = "1";     //  페이지 번호           필
}
