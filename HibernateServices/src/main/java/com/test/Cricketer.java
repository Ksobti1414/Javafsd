package com.test;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.Table;
@Entity
@Table(name="cricketers")
@NamedQueries({
	@NamedQuery(name="customquery",query="from Cricketer o where o.c_name=:name"),
	@NamedQuery(name="teamquery",query="from Cricketer o where o.c_team=:team")
})
public class Cricketer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String c_name;
private String c_team;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getC_name() {
	return c_name;
}
public void setC_name(String c_name) {
	this.c_name = c_name;
}
public String getC_team() {
	return c_team;
}
public void setC_team(String c_team) {
	this.c_team = c_team;
}
@Override
public String toString() {
	return "Cricketer [getId()=" + getId() + ", getC_name()=" + getC_name() + ", getC_team()=" + getC_team() + "]";
}
}
