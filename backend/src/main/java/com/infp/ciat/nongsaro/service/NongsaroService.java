package com.infp.ciat.nongsaro.service;

import com.infp.ciat.common.util.CiatStringUtils;
import com.infp.ciat.nongsaro.dto.NongsaroDetailDto;
import com.infp.ciat.nongsaro.dto.NongsaroListDto;
import com.infp.ciat.nongsaro.dto.NongsaroListDto.Item;
import com.infp.ciat.nongsaro.dto.NongsaroSearchDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NongsaroService {

    @Value("${nongsaro.key}")
    private String apiKey;

    @Value("${nongsaro.url}")
    private String nongsaroUrl;

    private static final Map<String, String> waterCode = new HashMap<String, String>() {{
        put("053001", "25");
        put("053002", "50");
        put("053003", "75");
        put("053004", "100");
    }};


    public List<Item> gardenList(NongsaroSearchDto dto) {
        List<Item> list = null;
        try {
            String url = nongsaroUrl
                    + "gardenList?apiKey=" + apiKey
                    + "&sType=" + URLEncoder.encode(dto.getSType(), "UTF-8")
                    + "&sText=" + URLEncoder.encode(dto.getSText(), "UTF-8")
                    + "&wordType=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getWordType()), "UTF-8")
                    + "&word=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getWord()), "UTF-8")
                    + "&lightChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getLightChkVal()), "UTF-8")
                    + "&grwhstleChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getGrwhstleChkVal()), "UTF-8")
                    + "&lefcolrChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getLefcolrChkVal()), "UTF-8")
                    + "&lefmrkChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getLefmrkChkVal()), "UTF-8")
                    + "&flclrChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getFlclrChkVal()), "UTF-8")
                    + "&fmldecolrChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getFmldecolrChkVal()), "UTF-8")
                    + "&ignSeasonChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getIgnSeasonChkVal()), "UTF-8")
                    + "&winterLwetChkVal=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getWinterLwetChkVal()), "UTF-8")
                    + "&priceType=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getPriceType()), "UTF-8")
                    + "&priceTypeSel=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getPriceTypeSel()), "UTF-8")
                    + "&waterCycleSel=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getWaterCycleSel()), "UTF-8")
                    + "&pageNo=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getPageNo()), "UTF-8")
                    + "&numOfRows=" + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getNumOfRows()), "UTF-8");

            String html = getHtml(url);
            JAXBContext jaxbContext = JAXBContext.newInstance(NongsaroListDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            NongsaroListDto nongsaro = (NongsaroListDto) unmarshaller.unmarshal(new StringReader(html));
            list = nongsaro.getBody().getItems();
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        return list;
    }

    public String getHtml(String url) throws IOException {
        URL targetUrl = new URL(url);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream()))) {

            StringBuffer html = new StringBuffer();
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                html.append(tmp);
            }
            return html.toString();
        }
    }

    public NongsaroDetailDto gardenDtl(String cntntsNo) {
        NongsaroDetailDto nongsaro = null;
        String url = nongsaroUrl
                + "gardenDtl?apiKey=" + apiKey
                + "&cntntsNo=" + cntntsNo;

        try {
            String html = getHtml(url);

            JAXBContext jaxbContext = JAXBContext.newInstance(NongsaroDetailDto.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            nongsaro = (NongsaroDetailDto) unmarshaller.unmarshal(new StringReader(html));

        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        if(nongsaro != null) {
            NongsaroDetailDto.Item item = nongsaro.getBody().getItem();
            String waterCode = this.getWaterCode(item);
            nongsaro.getBody().getItem().setWaterRequirement(waterCode);
        }


        return nongsaro;
    }

    public String getWaterCode(NongsaroDetailDto.Item item) {
        LocalDate currentDate = LocalDate.now();
        String month = String.valueOf(currentDate.getMonth().getValue());

        String[] winter = {"12", "1", "2"};
        String[] spring = {"3", "4", "5"};
        String[] summer = {"6", "7", "8"};

        String code;
        if(Arrays.asList(winter).contains(month)) {
            code = item.getWatercycleWinterCode();
        } else if(Arrays.asList(spring).contains(month)) {
            code = item.getWatercycleSprngCode();
        } else if (Arrays.asList(summer).contains(month)) {
            code = item.getWatercycleSummerCode();
        } else {
            code = item.getWatercycleAutumnCode();
        }

        return waterCode.get(code);
    }
}
