package com.dominickp.lifttracker

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class WorkoutDatabaseHelper  // Constructor
    (context: Context?) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        // Create the tables
        db.execSQL(SQL_CREATE_WORKOUTS_TABLE)
        db.execSQL(SQL_CREATE_SETS_TABLE)
        db.execSQL(SQL_CREATE_CARDIO_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema upgrades here
    }

    companion object {
        private const val DATABASE_NAME = "workout.db"
        private const val DATABASE_VERSION = 1

        // SQL statements for creating tables (as you provided in your example)
        private const val SQL_CREATE_WORKOUTS_TABLE =
            "CREATE TABLE Workouts (id INTEGER PRIMARY KEY, date TEXT, type TEXT);"
        private const val SQL_CREATE_SETS_TABLE =
            "CREATE TABLE Sets (id INTEGER PRIMARY KEY, workoutId INTEGER, setNumber INTEGER, reps INTEGER, weight REAL, FOREIGN KEY(workoutId) REFERENCES Workouts(id));"
        private const val SQL_CREATE_CARDIO_TABLE =
            "CREATE TABLE Cardio (id INTEGER PRIMARY KEY, workoutId INTEGER, duration INTEGER, FOREIGN KEY(workoutId) REFERENCES Workouts(id));"
    }
}

