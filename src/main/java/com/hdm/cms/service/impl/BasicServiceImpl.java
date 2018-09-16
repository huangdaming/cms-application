package com.hdm.cms.service.impl;

import com.hdm.cms.mapper.SuperMapper;
import com.hdm.cms.service.IBasicService;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class BasicServiceImpl<T,ID extends Serializable> implements IBasicService<T, ID> {

	public abstract SuperMapper<T,ID> getSuperMapper();

	public int insert(T t) {
		return getSuperMapper().insert(t);
	}

	public int update(T t) {
		return getSuperMapper().update(t);
	}

	public int delete(ID id) {
		return getSuperMapper().delete(id);
	}

	public T get(ID id) {
		return (T) getSuperMapper().get(id);
	}

	public List<T> select(Map params) {
		return getSuperMapper().query(params);
	}
}