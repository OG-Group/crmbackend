package com.argroupcrm.crm.util;

import com.argroupcrm.crm.model.cian.BuildingCianEntity;
import com.argroupcrm.crm.model.cian.OfficeCianEntity;
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
    private final XmlCianCommercial xmlCianCommercial;

    public void CianRentBuildingXML(BuildingCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, TransformerException, IOException, SAXException {
        xmlCianCommercial.CianRentBuildingXML(entity, countAvailablePremium);
    }

    public void CianSaleBuildingXML(BuildingCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        xmlCianCommercial.CianSaleBuildingXML(entity, countAvailablePremium);
    }

    public void CianRentOfficeXML(OfficeCianEntity entity, Integer countAvailablePremium) throws ParserConfigurationException, IOException, TransformerException, SAXException, NoSuchFieldException {
        xmlCianCommercial.CianRentOfficeXML(entity,countAvailablePremium);
    }

    public void CianSaleOfficeXML(OfficeCianEntity entity, Integer countAvailablePremium) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        xmlCianCommercial.CianSaleOfficeXml(entity,countAvailablePremium);
    }
}