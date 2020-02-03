package com.unasat.sr.editablelistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Date;







    /**
     * Created by Dairfa on 2/16/2019.
     *
     */

    public class DatabaseHelper extends SQLiteOpenHelper {
        private static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "mylist.db";

        //public static final String TABLE_NAME = "mylist_data";
        //public static final String COL1 = "ID";
       // public static final String COL2 = "ITEM1";
//colums for table users


        public static final String TABLE_USERS = "user_data";
        public static final String COLUMN_USERS_ID = "User_id";
        public static final String COLUMN_USERS_USERNAME = "username";
        public static final String COLUMN_USERS_PASSWORD = "password";
        public static final String COLUMN_USERS_GEBOORTE_DATUM = "geboorte_datum";
        public static final String COLUMN_USERS_ADRES = "adres";
        public static final String COLUMN_USERS_TRANSPORT = "transport";

        //colums for table uren_registratie
        public static final String TABLE_UREN = "uren_registratie";
        public static final String COLUMN_UREN_REG_ID = "Uren_reg_id";
        public static final String COLUMN_UREN_USER_ID= "user_id";
        public static final String COLUMN_UREN_REG_DATUM = "reg_datum";
        public static final String COLUMN_UREN_SYSDATE = "sysdate";
        public static final String COLUMN_UREN_START_TIME = "start_time";
        public static final String COLUMN_UREN_ENDTIME = "end_time";
        public static final String COLUMN_UREN_LOKATIE = "lokatie";

        private static final String CREATE_TABLE_UREN = String.format(
                "create table %s(%s INT PRIMARY KEY, %s VARCHAR(150) NULL ,%s VARCHAR(150) NULL ,%s VARCHAR(150) NULL ,%s VARCHAR(150) NULL ,%s VARCHAR(150) NULL ,%s VARCHAR(150) NULL );",
              TABLE_UREN, COLUMN_UREN_REG_ID,  COLUMN_UREN_USER_ID,COLUMN_UREN_REG_DATUM,COLUMN_UREN_SYSDATE,COLUMN_UREN_START_TIME,COLUMN_UREN_ENDTIME,COLUMN_UREN_LOKATIE);

               private static final String CREATE_TABLE_USERS = String.format(
                "create table %s(%s INT PRIMARY KEY, %s VARCHAR(100) NOT NULL ,%s VARCHAR(8) NOT NULL ,%s VARCHAR(6) NOT NULL ,%s VARCHAR(150) NOT NULL , %s VARCHAR(20) NOT NULL);",
                TABLE_USERS, COLUMN_USERS_ID,COLUMN_USERS_USERNAME,COLUMN_USERS_PASSWORD,COLUMN_USERS_GEBOORTE_DATUM,COLUMN_USERS_ADRES,COLUMN_USERS_TRANSPORT);

        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_UREN);
            db.execSQL(CREATE_TABLE_USERS);
        }
            /*
            String createUsers = "CREATE TABLE " + TABLE_USERS + " ("+ COLUMN_USERS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + COLUMN_USERS_USERNAME + "TEXT NOT NULL,"
                    + COLUMN_USERS_PASSWORD + "TEXT NOT NULL,"
                    + COLUMN_USERS_GEBOORTE_DATUM+ "TEXT NOT NULL,"
                    +COLUMN_USERS_ADRES + "TEXT NOT NULL,"
                    +COLUMN_USERS_TRANSPORT + "TEXT"
           +");";

            String createUren = "CREATE TABLE " + TABLE_UREN + " ("+ COLUMN_UREN_REG_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COLUMN_UREN_USER_ID+ " INTEGER NOT NULL,"
                    +COLUMN_UREN_REG_DATUM+ "TEXT NOT NULL,"
                    +COLUMN_UREN_SYSDATE+ "TEXT NOT NULL,"
                    +COLUMN_UREN_START_TIME+ "TEXT NOT NULL,"
                    +COLUMN_UREN_ENDTIME+ "TEXT NOT NULL,"
                    +COLUMN_UREN_LOKATIE+ "TEXT NOT NULL"
                    +");";
*/
            //db.execSQL(createUsers);
           // db.execSQL(createUren);
           // db.execSQL(createTable);




        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_UREN);
            onCreate(db);
        }

      //  public boolean addData(String item1) {
        //    SQLiteDatabase db = this.getWritableDatabase();
         //   ContentValues contentValues = new ContentValues();
          //  contentValues.put(COL2, item1);

            public boolean insertData(String reg_datum,String start_time,String sys_date,String end_time, String lokatie) {
                SQLiteDatabase db = this.getWritableDatabase();
                ContentValues contentValues = new ContentValues();
                contentValues.put(COLUMN_UREN_REG_DATUM, reg_datum);
                contentValues.put(COLUMN_UREN_START_TIME, start_time);
                contentValues.put(COLUMN_UREN_ENDTIME, end_time);
                contentValues.put(COLUMN_UREN_LOKATIE, lokatie);
                contentValues.put(COLUMN_UREN_SYSDATE, sys_date);

//vervolgens aangezien we als resultaat voor addUren hebben dat het eem boolean is. Gaan we variable "result" gebruiken om de waatde op te slaan
                long result = db.insert(TABLE_UREN, null, contentValues);
// db.insert gaat me een result geven die gelijk gesteld is aan -1 als er een error is bij insertion. Dus we checken als het goed is gegaan met het volgende
                if (result == -1) {
                    return false;
                } else {
                    return true;

                }
        }

                public Cursor getListContents() {
                    SQLiteDatabase db = this.getWritableDatabase();
                    Cursor data = db.rawQuery("SELECT * FROM " + TABLE_UREN, null);
                    return data;
                }
                public long insertOneRecord (String TABLE_UREN, ContentValues contentValues){
                    SQLiteDatabase db = getWritableDatabase();
                    long rowId = db.insert(TABLE_UREN, null, contentValues);
                    db.close();
                return rowId;}

                public Cursor getAllData(){
                    SQLiteDatabase db = this.getReadableDatabase();
                    Cursor res = db.rawQuery("SELECT * FROM " + TABLE_UREN, null);
                    return res;

                }
            }
/*


    public class DatabaseHelper  extends SQLiteOpenHelper {
        private static final String DB_NAME = "mylist.db";
        private static final int DB_VERSION = 1;
        private static final String TABLE_WI_INFO_NAME = "weight_watcher";
        private static final String TABLE_ID = "id";
        private static final String TABLE_WI_INFO_WEIGHT = "weight";
        private static final String TABLE_WI_INFO_DATE = "date";

        private static final String CREATE_TABLE_WI_INFO = String.format(
                "create table %s(%s INT PRIMARY KEY, %s VARCHAR(255) NOT NUL , %s VARCHAR(255) NOT NULL UNIQUE);",
                TABLE_WI_INFO_NAME, TABLE_ID, TABLE_WI_INFO_WEIGHT, TABLE_WI_INFO_DATE);

        public WeightDAO(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CREATE_TABLE_WI_INFO);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }


        public long insertOneRecord(String tableName, ContentValues contentValues) {
            SQLiteDatabase db = getWritableDatabase();
            long rowId = db.insert(tableName, null, contentValues);
            db.close();
            //return the row ID of the newly inserted row, or -1 if an error occurred
            return rowId;
        }

/*    public Cursor findRecordsRAW(String weight, String date) {
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = null;
        String sql = String.format("select * from %s where %s = ? OR %s = ?", TABLE_WI_INFO_NAME, TABLE_WI_INFO_WEIGHT, TABLE_WI_INFO_DATE);
        String[] whereArgs =  {weight, date};
        cursor = db.rawQuery(sql, whereArgs);
        return cursor;
    }*/
/*
        public Cursor findRecords(String weight, String date) {
            SQLiteDatabase db = getReadableDatabase();
            Cursor cursor = null;
            String whereClause = String.format("%s = ? OR %s = ?", TABLE_WI_INFO_WEIGHT, TABLE_WI_INFO_DATE);
            String[] whereArgs = {weight, date};
            cursor = db.query(TABLE_WI_INFO_NAME, null, whereClause, whereArgs ,null, null, null);
            return cursor;
        }

        public int updateRecord(ContentValues contentValues, String weight, String date) {
            SQLiteDatabase db = getWritableDatabase();
            int effectedRows = 0;
            String whereClause = String.format("%s = ? OR %s = ?", TABLE_WI_INFO_WEIGHT, TABLE_WI_INFO_DATE);
            String[] whereArgs = {weight, date};
            effectedRows = db.update(TABLE_WI_INFO_NAME, contentValues, whereClause, whereArgs);
            return effectedRows;
        }


        public int deleteRecord(String weight, String date) {
            SQLiteDatabase db = getWritableDatabase();
            int effectedRows = 0;
            String whereClause = String.format("%s = ? OR %s = ?", TABLE_WI_INFO_WEIGHT, TABLE_WI_INFO_DATE);
            String[] whereArgs = {weight, date};
            effectedRows = db.delete(TABLE_WI_INFO_NAME, whereClause, whereArgs);
            return effectedRows;
        }


    }
        */