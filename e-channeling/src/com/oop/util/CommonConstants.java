package com.oop.util;


public class CommonConstants {
	
	/** Constant for config.properties key for query file path */
	public static final String QUERY_XML = "queryFilePath";

	/** Constant for file path of config.properties */
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for query tag in PatientQuery.xml */
	public static final String TAG_NAME = "query";

	/** Constant for query id in patientQuery.xml */
	public static final String ATTRIB_ID = "id";
	
	/** Constant for patient id prefix */
	//public static final String patient_ID_PREFIX = "E300";

	/** Constant for comma */
	public static final String COMMA = ",";

	/** Constant for url key of MySQL database in config.properties */
	public static final String URL = "url";

	/** Constant for user name key of MySQL database in config.properties */
	public static final String USERNAME = "userName";

	/** Constant for password key of MySQL database in config.properties */
	public static final String PASSWORD = "password";

	/** Constant for driver name key of MySQL database in config.properties */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for query id of drop_table in patientQuery.xml */
	public static final String QUERY_ID_DROP_TABLE = "drop_table";

	/** Constant for query id of create_table in patientQuery.xml */
	public static final String QUERY_ID_CREATE_TABLE = "create_patient_table";

	/** Constant for query id of insert patients in patientQuery.xml */
	public static final String QUERY_ID_INSERT_PATIENT = "insert_patient";

	/** Constant for query id of get an patients in patientQuery.xml */
	public static final String QUERY_ID_GET_PATIENT = "patients";

	/** Constant for query id of get all patients in patientQuery.xml */
	public static final String QUERY_ID_ALL_PATIENT = "all_patient";

	/** Constant for query id of remove a patient in patientQuery.xml */
	public static final String QUERY_ID_REMOVE_PATIENT = "remove_patient";

	/** Constant for query id of update a patient in patientQuery.xml */
	public static final String QUERY_ID_UPDATE_PATIENT = "update_patient";

	/** Constant for query id of get all patient ids in patientQuery.xml */
	public static final String QUERY_ID_GET_PATIENT_IDS = "patient_ids";
	
	public static final String QUEARY_VALIDATE_LOGIN = "patient_by_email_and_password";
	
	public static final String QUEARY_ALL_SPECILIZATION = "get_all_specilitaion";
	
	public static final String QUEARY_ALL_HOSPITAL = "get_all_hospital";
	
	public static final String QUEARY_ALL_DOCTOR = "get_all_doctor";
	
	public static final String QUEARY_GET_AVALABILITY = "get_availability";
	
	public static final String QUEARY_GET_OTHER_AVALABILITY = "get_other_availability";
	
	public static final String QUEARY_DOCTOR_BY_ID = "get_doctor_by_id";
	
	public static final String QUEARY_HOSPITAL_BY_ID = "get_hospital_by_id";
	
	public static final String QUEARY_SPECILIZATION_BY_ID = "get_specilization_by_id";
	
	public static final String QUEARY_UPDATE_SCHEDULE_STATUS = "update_schedule_status";
	
	public static final String QUEARY_GET_PATIENT_ID_BY_USERID = "get_patient_id_by_user_id";
	
	public static final String QUERY_ID_INSERT_APPOINMENT = "add_appointment";
	
	public static final String QUERY_APPOINTMENT_BY_PATIENT_ID = "find_appointment_by_patientId";
	
	public static final String QUERY_SCHEDULE_BY_ID = "find_schedule_by_id";
	
	public static final String QUERY_CANCEL_APPOINTMENT_BY_PATIENT_ID = "find_appointment_status_booked_and_pending_by_patientId";
	
	public static final String QUEARY_DOCTOR_BY_NAME = "get_doctor_by_name";
	
	public static final String QUEARY_UPDATE_CANCEL_DETAILS = "update_cancel_details";
	
	public static final String QUEARY_DOCTOR_SPECILIZATION_BY_DOCTOR_ID = "get_doctor_specilization_by_doctor_id";
	
	public static final String QUERY_INSERT_FEEDBACK = "insert_feedback"; 
	
	public static final String QUERY_ID_INSERT_DOCTOR = "create_doctor";
	
	public static final String QUEARY_DOCTOR_BY_USER_ID = "get_doctor_by_user_id";
	
	public static final String QUEARY_DOCTOR_LOGIN_VALIDATE = "doctor_login_validate"; 
	
	public static final String QUERY_ID_INSERT_SCHEDULE = "add_schedule";
	
	public static final String QUERY_GET_APPROVAL_PENDING = "approve_or_reject_appointment";
	
	public static final String QUERY_GET_APPOIMENT_BY_SCHEDULE_ID = "get_appointment_by_schedule_id";
	
	public static final String QUEARY_UPDATE_APPOIMENT_STATUS = "update_appoiment_status";
	
	public static final String QUEARY_FEEDBACK_BY_DOCTOR_ID = "get_feedback_by_doctor_id";
	
	public static final String QUEARY_GET_ALL_AVAILABLE_SCHEDULE = "get_all_avilable_schedule";
	
	public static final String QUEARY_REMOVE_SCHEDULE = "remove_schedule";
	
	public static final String QUEARY_UPDATE_SCHEDULE = "update_schedule";
	
	public static final String QUEARY_GET_ALL_APPOINTMENT = "all_appointment_relevent_doctor";
	
	public static final String QUERY_GET_ALL_APPOIMENT_BY_SCHEDULE_ID = "get_all_appointment_by_schedule_id";
	
	public static final String QUERY_ID_INSERT_TREATMENT = "insert_treatment";
	
	public static final String QUERY_CURRENT_DAY_APPOINTMENT_PATIENT = "get_current_day_appintment_patient";
	
	public static final String QUERY_CURRENT_DAY_SCHEDULE_BY_DOCTOR = "get_current_day_schedule_by_doctor";
	
	public static final String QUERY_UPDATE_APPOINTMENT_STATUS_BY_SCHEDULE_ID = "update_appoiment_status_by_schedule_id";
	
	public static final String QUERY_FIND_PATIENT_PROFILE_PICTURE = "get_patient_profile_pic_by_id";
	
	
	/** Constant for Column index one */
	public static final int COLUMN_INDEX_ONE = 1;
	
	/** Constant for Column index two */
	public static final int COLUMN_INDEX_TWO = 2;
	
	/** Constant for Column index three */
	public static final int COLUMN_INDEX_THREE = 3;
	
	/** Constant for Column index four */
	public static final int COLUMN_INDEX_FOUR = 4;
	
	/** Constant for Column index five */
	public static final int COLUMN_INDEX_FIVE = 5;
	
	/** Constant for Column index six */
	public static final int COLUMN_INDEX_SIX = 6;
	
	/** Constant for Column index seven */
	public static final int COLUMN_INDEX_SEVEN = 7;
	
	/** Constant for Column index eight */
	public static final int COLUMN_INDEX_EIGHT = 8;
	
	/** Constant for Column index nine */
	public static final int COLUMN_INDEX_NINIE = 9;
	
	public static final int COLUMN_INDEX_TEN = 10;
	
	public static final int COLUMN_INDEX_ELEVEN = 11;
	
	public static final int COLUMN_INDEX_TWELVE = 12;
}
