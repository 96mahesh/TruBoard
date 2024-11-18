package com.truboardpartners.classes;

import org.openqa.selenium.By;

public class SmokeCancelNOC {
	
	public By search_proj = By.xpath("//input[@class='form-control app-textbox']");
	public By View_Req = By.xpath("//button[@title='View Request']");
	public By Cancel_noc = By.xpath("(//table[@class='table table-hover']//tr//td//button[contains(@iconclass,'fa fa-file-pdf-o')])[1]");
	
	public String searchproj = "Select Project Name";
	public String projectname = "Enter Project Name";
	public String search = "click search";
	public String viewrequest = "NA";
	public String cancelnoc = "Click cancel NOC";

}
 