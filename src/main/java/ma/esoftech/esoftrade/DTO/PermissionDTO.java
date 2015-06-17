package ma.esoftech.esoftrade.DTO;

import ma.esoftech.esoftrade.model.Permission.Module;

public class PermissionDTO {
private long id;
private String label;
private String description;
private Module module;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Module getModule() {
	return module;
}
public void setModule(Module module) {
	this.module = module;
}
 
}
