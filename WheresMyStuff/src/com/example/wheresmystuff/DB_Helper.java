package com.example.wheresmystuff;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 *  Class that opens up and closes the connection to the database. 
 *   
 * 
 */
public class DB_Helper extends SQLiteOpenHelper {
	
	public static final String KEY_ROW_ID = "id";
	public static final String KEY_ADMIN = "admin_status";
	public static final String KEY_NAME = "id_name";
	public static final String KEY_ZIP = "zip";
	public static final String KEY_STREET = "street";
	public static final String KEY_EMAIL = "email";
	public static final String KEY_PHONE = "phone";
	public static final String KEY_PASSWORD = "id_password";
	public static final String KEY_LOGIN_ATTEMPTS = "login_attempts";
	public static final String DATABASE_TABLE_USERS = "reg_users_table";
	private static final String DATABASE_NAME = "users_info_db";
	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_CREATE = "CREATE TABLE "
		      + DATABASE_TABLE_USERS + "(" + KEY_ROW_ID + 
		     " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_NAME
		      + " TEXT NOT NULL," + KEY_PASSWORD + " TEXT NOT NULL," + KEY_LOGIN_ATTEMPTS + " INTEGER NOT NULL," + KEY_ZIP + " TEXT," +
		      KEY_STREET + " TEXT," + KEY_EMAIL + " TEXT NOT NULL," + KEY_PHONE + " TEXT," + KEY_ADMIN + " INTEGER NOT NULL);" ;
	
	public static final String ITEM_NAME = "item_name";
	public static final String ITEM_STATUS = "item_status";
	public static final String ITEM_DESCRIPTION = "item_description";
	public static final	String ITEM_ROW_ID = "row_id";
	public static final String ITEM_TABLE = "table_of_items";
	public static final String ITEM_ZIP = "item_zip";
	public static final String ITEM_STREET = "item_street";
	public static final String ITEM_CATEGORY = "item_category";
	public static final String ITEM_DATE = "item_date";
	public static final String ITEM_KEEPSAKE = "item_keepsakes";
	public static final String ITEM_HEIRLOOM = "item_heirloom";
	public static final String ITEM_MISC = "item_misc";
	public static final String CREATE_ITEM_DB = "CREATE TABLE "
		      + ITEM_TABLE + "(" + ITEM_ROW_ID + 
		     " INTEGER PRIMARY KEY AUTOINCREMENT," + ITEM_NAME
		      + " TEXT NOT NULL," + ITEM_STATUS + " TEXT NOT NULL," + ITEM_DESCRIPTION + " TEXT," + ITEM_CATEGORY + " TEXT NOT NULL," +
		      KEY_NAME + " TEXT NOT NULL," + ITEM_ZIP + " TEXT NOT NULL," + ITEM_STREET + " TEXT NOT NULL,"+ ITEM_DATE + " TEXT NOT NULL," 
		      + ITEM_KEEPSAKE + " INTEGER NOT NULL," + ITEM_HEIRLOOM + " INTEGER NOT NULL," + ITEM_MISC + " INTEGER NOT NULL);";
	
	
	
	public DB_Helper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
		// TODO Auto-generated constructor stub
	}


	@Override
	public void onCreate(SQLiteDatabase db) {
		
		db.execSQL(DATABASE_CREATE);
		db.execSQL(CREATE_ITEM_DB);
		
		
	}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DB_Helper.class.getName(),
		        "Upgrading database from version " + oldVersion + " to "
		            + newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_USERS);
		db.execSQL("DROP TABLE IF EXISTS " + CREATE_ITEM_DB);
	    onCreate(db);
		
	}
	
	

	
	
	

}
