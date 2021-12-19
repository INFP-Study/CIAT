package com.infp.ciat.nongsaro.controller;

import com.infp.ciat.nongsaro.dto.NongsaroDetailDto;
import com.infp.ciat.nongsaro.dto.NongsaroListDto.*;
import com.infp.ciat.nongsaro.dto.NongsaroSearchDto;
import com.infp.ciat.nongsaro.service.NongsaroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class NongsaroController {

    private final NongsaroService nongsaroService;

    @PostMapping("/gardenList")
    public List<Item> gardenList(@RequestBody NongsaroSearchDto dto) {
        return nongsaroService.gardenList(dto);
    }

    @GetMapping("/gardenDtl/{cntntsNo}")
    public NongsaroDetailDto gardenDtl(@PathVariable String cntntsNo) {
        return nongsaroService.gardenDtl(cntntsNo);
    }
}
