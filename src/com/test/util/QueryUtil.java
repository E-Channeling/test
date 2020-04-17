package com.test.util;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class QueryUtil extends CommonUtil{
	
	public static String queryByID(String id) throws SAXException, IOException, ParserConfigurationException {

		NodeList nodeList;
		Element element = null;
		/*
		 * Read the EmployeeQuery.xml file and read each query node into node
		 * list. It refers tag name query
		 */
		nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(System.getProperty("catalina.base") + "\\wtpwebapps\\test\\WEB-INF\\PatientQuery.xml"))
				.getElementsByTagName(CommonConstants.TAG_NAME);

		/*
		 * Extract the node from node list using query id query id is taken from
		 * query node attribute
		 */
		for (int value = 0; value < nodeList.getLength(); value++) {
			element = (Element) nodeList.item(value);
			if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
				break;
		}
		return element.getTextContent().trim();
	}
	
	
	/*
	 * query for patient
	 */
	
	public static String insertPatient(){
		
		String query = "          	insert into patient (fName, lName, DOB, gender, phoneNo, address, email, password) \n" + 
				"          	values (?, ?, ?, ?, ?, ?, ?, ?)";
		return query;
	}
	
	
	public static String createPatientTable(){
	
	String query = "       CREATE TABLE patient(\n" + 
			"            	id bigint not null AUTO_INCREMENT,\n" + 
			"				fName varchar(70) not null,\n" + 
			"				lName varchar(70) not null,\n" + 
			"				DOB date not null,\n" + 
			"				gender varchar(10) DEFAULT 'Male',\n" + 
			"				phoneNo char(10),\n" + 
			"				address varchar(255),\n" + 
			"				email varchar(30) not null,\n" + 
			"				password varchar(12) not null,\n" + 
			"				primary key (id)\n" + 
			"			)        ";
	return query;
	}
	
	public static String dropPatientTable(){
		
	String query = "DROP TABLE IF EXISTS patient ";
	return query;
	}
	
	public static String selectpatient() {
		String query = "select * from patient where email = ? and password = ? ";
		return query;
	}
	public static String selectallPatient() {
		String query = "select * from patient";
		return query;
	}
	public static String getPatientById() {
		String qurey ="select * from patient where patient.email = ?"; 
		return qurey;
	}
	
	
	/*
	 * query for Doctor
	 */
	
	public static String createDoctorTable() {
		String query = "	            CREATE TABLE doctor(\n" + 
				"            	reg_id varchar(10) not null unique,\n" + 
				"				Name varchar(70) not null,\n" + 
				"				specialized varchar(50) not null,\n" + 
				"				gender varchar(10) DEFAULT 'Male',\n" + 
				"				contactNo char(10),\n" + 
				"				hospital varchar(255),\n" + 
				"				email varchar(30) not null,\n" + 
				"				password varchar(12) not null,\n" + 
				"				primary key (reg_id)\n" + 
				"			)";
		return query;
	}
	
	public static String dropDoctorTable() {
		String query = "DROP TABLE IF EXISTS doctor";
		return query;
	}
	
	public static String insertDoctor(){
		
		String query = "          	insert into doctor (reg_id, Name, specialized, gender, contactNo, hospital, email, password) \n" + 
				"          	values (?, ?, ?, ?, ?, ?, ?, ?)";
		return query;
	}
	public static String selectDoctor() {
		String query = "select * from doctor where email = ? and password = ? ";
		return query;
	}

	/*
	 * query for Treatment Table
	 */
	
	
	public static String createTreatmentTable() {
		String query = "          					CREATE TABLE treatment(\n" + 
				"                id bigint not null AUTO_INCREMENT,\n" + 
				"                patient_id bigint not null,\n" + 
				"            	doc_id varchar(10) not null ,\n" + 
				"				description varchar(200) not null,\n" + 
				"				date varchar(10) ,\n" + 
				"				\n" + 
				"                CONSTRAINT FK_doc_id FOREIGN KEY (doc_id)\n" + 
				"				REFERENCES doctor(reg_id),\n" + 
				"                CONSTRAINT FK_patient_id FOREIGN KEY (patient_id)\n" + 
				"				REFERENCES patient(id),\n" + 
				"				primary key (id)\n" + 
				"			)";
		return query;
	}
	
	public static String dropTreatmentTable() {
		String query = "DROP TABLE IF EXISTS treatment";
		return query;
	}
	
	public static String insertTreatment() {
		String query = "          	insert into treatment (patient_id, doc_id, description, date) \n" + 
				"          	values (?, ?, ?, ?)";
		return query;
	}
	
	/*
	 * query for FeedBack Table
	 */
	public static String createFeedBackTable() {
		String query = "            CREATE TABLE feedback(\n" + 
				"								feedback_id bigint not null AUTO_INCREMENT,\n" + 
				"								patient_id bigint not null,\n" + 
				"								doc_id varchar(10) not null ,\n" + 
				"								description varchar(200) not null,\n" + 
				"								CONSTRAINT FK_doc_id_feddback FOREIGN KEY (doc_id)\n" + 
				"								REFERENCES doctor(reg_id),\n" + 
				"								CONSTRAINT FK_patient_id_feddback FOREIGN KEY (patient_id) \n" + 
				"								REFERENCES patient(id),\n" + 
				"								primary key (feedback_id,patient_id,doc_id)\n" + 
				"                                )";
		return query;
	}
	public static String dropFeedBackTable() {
		String query = "DROP TABLE IF EXISTS feedback";
		return query;
	}
	public static String insertFeedBack() {
		String query = "          	insert into feedback (patient_id, doc_id, description) \n" + 
				"          	values (?, ?, ?)";
		return query;
	}
	public static String selectAllFeedback() {
		String query = "select * from feedback";
		return query;
	}
	public static String getFeedbackById() {
		String qurey ="select * from feedback where feedback.id = ?"; 
		return qurey;
	}
	



	
	

}
