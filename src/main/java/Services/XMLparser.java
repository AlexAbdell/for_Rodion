package Services;

import CollectionObjects.LabWork;
import CollectionObjects.LabWorkRepository;
import CollectionObjects.LabWorks;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;
import java.nio.file.Path;
import java.util.TreeSet;


public class XMLparser {
    public static String convertToXML(LabWorkRepository repository) throws Exception{
        System.out.println(repository);
        JAXBContext context = JAXBContext.newInstance(LabWorkRepository.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
        StringWriter sw = new StringWriter();
        marshaller.marshal(repository, sw);
        return sw.toString();
    }

    public static LabWorks convertFromXML(String string) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(LabWorks.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return (LabWorks) unmarshaller.unmarshal(new StringReader(string));
    }
}
