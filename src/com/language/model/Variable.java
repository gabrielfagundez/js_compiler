package com.language.model;

import java.util.HashMap;
import java.util.Map;

public class Variable {
	private String name = null;
	private Map<Integer, Integer> scope_type_relation = new HashMap<Integer, Integer>();
	private Map<Integer, Object> scope_value_relation = new HashMap<Integer, Object>();

	public Variable() {}

	public Variable(String name, Integer type, Object value, Integer scope) {
		this.name 	= name;
		this.scope_type_relation.put(scope, type);
		this.scope_value_relation.put(scope, value);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType(Integer scope) {
		Integer type = null;
		Integer scope_aux = scope;
		
//		do {
//			type = this.scope_type_relation.get(scope_aux);
//			scope_aux--;
//		} while (type == null && scope_aux >= 0);
		
//		if (type == null) {
			Object[] scope_list = this.scope_type_relation.keySet().toArray();
			int scope_index = this.scope_type_relation.keySet().toArray().length - 1;
			
			do {
				type = this.scope_type_relation.get(scope_list[scope_index]);
				scope_index--;
			} while (type == null && scope_index >= 0);
//		}
		
		return type;
	}

	public void setType(Integer scope, Integer type) {
		this.scope_type_relation.put(scope, type);
	}

	public Object getValue(Integer scope) {
		Object value = null;
		Integer scope_aux = scope;
		
//		do {
//			value = this.scope_value_relation.get(scope_aux);
//			scope_aux--;
//		} while (value == null && scope_aux >= 0);

//		if (value == null) {
			Object[] scope_list = this.scope_value_relation.keySet().toArray();
			int scope_index = this.scope_value_relation.keySet().toArray().length - 1;

			do {
				value = this.scope_value_relation.get(scope_list[scope_index]);
				scope_index--;
				
			} while (value == null && scope_index >= 0);
//		}
		
		return value;
	}

	public void setValue(Integer scope, Object value) {
		this.scope_value_relation.put(scope, value);
	}
	
	public Map getScopeValueRelation() {
		return this.scope_value_relation;
	}
	
	public Map getScopeTypeRelation() {
		return this.scope_type_relation;
	}
}
