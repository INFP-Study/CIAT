package com.infp.ciat.common.forest.controller;

import com.infp.ciat.common.forest.dto.ForestRequestDto;
import com.infp.ciat.common.forest.model.ForestDetailIntro;
import com.infp.ciat.common.forest.model.ForestListSearch;
import com.infp.ciat.common.forest.service.ForestApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ForestApiController {

    private final ForestApiService forestApiService;

    @PostMapping("/plntIlstrSearch")
    public List<ForestListSearch.Item> lstrSearch(@RequestBody ForestRequestDto dto) {
        return forestApiService.forestSearchList(dto);
    }

    @GetMapping("/plntIlstrInfo")
    public ForestDetailIntro detailIntro(String q1) {
        return forestApiService.forestDetailIntro(q1);
    }

}
