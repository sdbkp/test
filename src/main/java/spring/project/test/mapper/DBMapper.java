package spring.project.test.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DBMapper {
	
	public int dbTest();
//	public List<HashMap<String, Object>> getAds();
	
}
