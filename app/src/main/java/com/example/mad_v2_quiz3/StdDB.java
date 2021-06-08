package com.example.mad_v2_quiz3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Parcelable;

public class StdDB {
public static final String KEY_ROWID="_id";
public static final String KEY_ROWNAME="_name";
public static final String KEY_ROWEMAIL="_email";
public static final String KEY_ROWCELL="_cell";
public static final String KEY_ROWPROGRAM="_program";
public static final String KEY_ROWINSTITUTE="_institute";

public static final String DATABASE_NAME="StdDB";
public static final String DATABASE_TABLE="StdTable";
public static final int DATABASE_VERSION=1;

private  DBHelper ourHelper;
private SQLiteDatabase ourDataBase;

private final Context ourContext;

public StdDB(Context context)
{
    ourContext=context;
}

private class DBHelper extends SQLiteOpenHelper
{
    public DBHelper(Context context)
    {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
/*


        Create TABLE Studenttable(
                _id INTEGER PRIMARY KEY AUTOINCREAMENT,
                _name TEXT NOT NULL,
                _email TEXT NOT NULL,
                _cell TEXT,
                _program TEXT,
                _institute TEXT,

        );

 */

        String sqlcode = "CREATE TABLE "+DATABASE_TABLE +"("
                +KEY_ROWID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                +KEY_ROWNAME+"TEXT NOT NULL,"
                +KEY_ROWPROGRAM+"TEXT,"
                +KEY_ROWCELL+"TEXT,"
                +KEY_ROWEMAIL+"TEXT);";
        db.execSQL(sqlcode);


    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS "+DATABASE_TABLE);


    }
}
    public void open(){
        ourHelper = new DBHelper(ourContext);
        ourDataBase = ourHelper.getWritableDatabase();

    }

    public void close(){
        ourHelper.close();
    }

    public long createEntry(String name, String email, String cellNO, String program, String institute){
        ContentValues cv = new ContentValues();
       // cv.put(KEY_ROWID, );
        cv.put(KEY_ROWNAME, name);
        cv.put(KEY_ROWPROGRAM, program);
        cv.put(KEY_ROWCELL, cellNO);
        cv.put(KEY_ROWEMAIL, email);
        cv.put(KEY_ROWINSTITUTE, institute);


       return ourDataBase.insert(DATABASE_TABLE, null, cv);

    }

    public void getData()
    {

        String []columns = new String[]{KEY_ROWID, KEY_ROWNAME, KEY_ROWPROGRAM, KEY_ROWCELL, KEY_ROWEMAIL};
        Cursor c = ourDataBase.query(DATABASE_TABLE, columns, null, null, null, null, null);

        String result = "";

        int iRowID = c.getColumnIndex(KEY_ROWID);
        int iRowName = c.getColumnIndex(KEY_ROWNAME);
        int iRowProgram = c.getColumnIndex(KEY_ROWPROGRAM);
        int iRowCell = c.getColumnIndex(KEY_ROWCELL);
        int iRowEmail = c.getColumnIndex(KEY_ROWEMAIL);
        int iRowInstitute = c.getColumnIndex(KEY_ROWINSTITUTE);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()){
            StdInfo s= new StdInfo();
            s.setId(c.getString(iRowID));
            s.setFullname(c.getString(iRowName));
            s.setEmail(c.getString(iRowEmail));
            s.setCell(c.getString(iRowCell));
            s.setProgram(c.getString(iRowProgram));
            s.setInstitute(c.getString(iRowInstitute));
            AppData.students.add(s);

        }


        c.close();
    }

    public long deleteEntry(String rowId)
    {
        return ourDataBase.delete(DATABASE_TABLE,KEY_ROWID+"=?",new String[]{rowId});
    }

    public long updateEntry(String id,String name,String email,String cellNo,String program,String institute)
    {

        ContentValues cv = new ContentValues();
        //cv.put(KEY_ROWID, );
        cv.put(KEY_ROWNAME, name);
        cv.put(KEY_ROWPROGRAM,program);
        cv.put(KEY_ROWCELL,cellNo);
        cv.put(KEY_ROWEMAIL,email);
        cv.put(KEY_ROWINSTITUTE, institute);

        return ourDataBase.update(DATABASE_TABLE,cv,KEY_ROWID+"=?",new String[]{id});

    }

}
