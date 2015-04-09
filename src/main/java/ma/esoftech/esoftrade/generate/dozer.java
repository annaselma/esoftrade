package ma.esoftech.esoftrade.generate;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

public class dozer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub$
		DozerBeanMapper mapper=new DozerBeanMapper();
		List myMappingFiles = new ArrayList();
		myMappingFiles.add("dozerMapping.xml");
		mapper.setMappingFiles(myMappingFiles);
		mapper.getCustomConvertersWithId();
		List<Child> childs=new ArrayList<Child>();
		childs.add(new Child());
		childs.add(new Child());
		childs.add(new Child());
		Entity ent=new Entity();
		ent.setEnt("ent");
		ent.setChilds(childs);
		EntityDTO dto=(EntityDTO)mapper.map(ent,EntityDTO.class);
		System.out.println(dto.getEnt());
		System.out.println(dto.getChilds().iterator().next().toString());
		

	}

}
