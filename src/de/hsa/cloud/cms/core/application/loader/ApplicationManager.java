package de.hsa.cloud.cms.core.application.loader;

import java.io.File;
import java.util.HashMap;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import de.hsa.cloud.cms.core.module.loader.ModuleConfig;

public class ApplicationManager {
	public static void main(String[] args){
		ModuleConfig mc = new ModuleConfig();
		mc.setName("test");
		mc.setGroup("test");
		mc.setDiscription("Ich bin ein test");
		mc.setPath("test");
		mc.setAvailable(true);
		
		try{
			//File file = new File("/home/liebsoer/tmp/modules.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(ModuleConfig.class);
			Marshaller jaxbMarschaller = jaxbContext.createMarshaller();
			jaxbMarschaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			//jaxbMarschaller.marshal(mc, file);
			jaxbMarschaller.marshal(mc, System.out);
		}catch(JAXBException e){
			e.printStackTrace();
		}
	}
}
