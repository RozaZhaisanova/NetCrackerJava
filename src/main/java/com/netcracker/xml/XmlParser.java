package com.netcracker.xml;

import com.netcracker.repository.Repository;

import javax.xml.bind.*;
import java.io.File;

/**
 * Класс для созранения и восстановления контрактов в xml
 */
public class XmlParser {

    private static final String FILE_PATH = "repository.xml";

    private final JAXBContext context;

    public XmlParser() throws JAXBException {
        this.context = JAXBContext.newInstance(Repository.class);
    }


    /**
     * @param rep - Репозиторий для сохранения
     */
    public void save(Repository rep) {
        try {
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(rep, new File(FILE_PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Загруженный репозиторий
     */
    public Repository restore() {
        Repository repository = null;
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            repository = (Repository) unmarshaller.unmarshal(new File(FILE_PATH));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return repository;
    }
}