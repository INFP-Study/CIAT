package com.infp.ciat.common.forest.service;

import com.infp.ciat.common.forest.dto.ForestRequestDto;
import com.infp.ciat.common.forest.model.ForestDetailIntro;
import com.infp.ciat.common.forest.model.ForestListSearch;
import com.infp.ciat.common.properties.ForestProperties;
import com.infp.ciat.common.util.CiatStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
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
import java.util.List;

@Slf4j
@Service
public class ForestApiService {

    private final ForestProperties forestProperties;

    public ForestApiService(ForestProperties forestProperties) {
        this.forestProperties = forestProperties;
    }

    public List<ForestListSearch.Item> forestSearchList(ForestRequestDto dto) {
        List<ForestListSearch.Item> list = null;
        String forestUrl = forestProperties.getUrl();
        String forestKey = forestProperties.getKey();
        
        try {

            String url = forestUrl
                    + "plntIlstrSearch?serviceKey=" + forestKey
                    + "&st="        + URLEncoder.encode(dto.getSt(), "UTF-8")
                    + "&sw="        + URLEncoder.encode(dto.getSw(), "UTF-8")
                    + "&dateGbn="   + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getDateGbn()), "UTF-8")
                    + "&dateForm="  + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getDateForm()), "UTF-8")
                    + "&dateTo="    + URLEncoder.encode(CiatStringUtils.StringNullToEmpty(dto.getDateTo()), "UTF-8")
                    + "&numOfRows=" + URLEncoder.encode(dto.getNumOfRows(), "UTF-8")
                    + "&pageNo="    + URLEncoder.encode(dto.getPageNo(), "UTF-8");

            String html = getHtml(url);
            JAXBContext jaxbContext = JAXBContext.newInstance(ForestListSearch.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            ForestListSearch forest = (ForestListSearch) unmarshaller.unmarshal(new StringReader(html));
            list = forest.getBody().getItems();
        } catch ( JAXBException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("list = " + list);
        return list;
    }

    public String getHtml(String url) throws IOException {
        URL targetUrl = new URL(url);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(targetUrl.openStream()))){

            StringBuffer html = new StringBuffer();
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                html.append(tmp);
            }
            return html.toString();
        }
    }

    public ForestDetailIntro forestDetailIntro(String q1) {
        String forestUrl = forestProperties.getUrl();
        String forestKey = forestProperties.getKey();

        ForestDetailIntro forest = null;
        String url = forestUrl
                + "plntIlstrInfo?serviceKey=" + forestKey
                + "&q1=" + q1;

        try {
            String html = getHtml(url);

            JAXBContext jaxbContext = JAXBContext.newInstance(ForestDetailIntro.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            forest = (ForestDetailIntro) unmarshaller.unmarshal(new StringReader(html));
            System.out.println("forest = " + forest);
        } catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

        return forest;
    }
}
