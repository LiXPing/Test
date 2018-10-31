package cn.tedu.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.tedu.store.entity.Address;
import cn.tedu.store.entity.Area;
import cn.tedu.store.mapper.AreaMapper;
import cn.tedu.store.service.ex.InsertDataException;
@Service("areaService")
public class AreaServiceImpl implements IAreaService{

	@Autowired
	private AreaMapper areaMapper;
	
	public List<Area> getAreaListByCityCode(String cityCode) {
	
		return areaMapper.getAreaListByCityCode(cityCode);
	}

	public Area getAreaByCode(String areaCode) {
		
		return areaMapper.getAreaByCode(areaCode);
	}

	

}
