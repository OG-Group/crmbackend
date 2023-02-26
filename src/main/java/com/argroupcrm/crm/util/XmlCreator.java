package com.argroupcrm.crm.util;

import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;

@Data
@Component
@RequiredArgsConstructor
public class XmlCreator {
    private final XmlCian xmlCian;

    public void CianRentBuildingXML(BuildingCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        xmlCian.CianRentBuildingXML(entity, countAvailablePremium);
    }

    public void CianSaleBuildingXML(BuildingCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        xmlCian.CianSaleBuildingXML(entity, countAvailablePremium);
    }

}