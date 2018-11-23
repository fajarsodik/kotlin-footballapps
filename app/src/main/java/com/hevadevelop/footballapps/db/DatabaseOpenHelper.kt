package com.hevadevelop.footballapps.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DatabaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FootballApps.db", null, 1) {

    companion object {
        private var instance: DatabaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DatabaseOpenHelper {
            if (instance == null) {
                instance = DatabaseOpenHelper(ctx.applicationContext)
            }
            return instance as DatabaseOpenHelper
        }
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true,
                FavoriteMatch.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                FavoriteMatch.MATCH_ID to TEXT + UNIQUE, FavoriteMatch.DATE_MATCH to TEXT,
                FavoriteMatch.TEAM_HOME_ID to TEXT, FavoriteMatch.TEAM_AWAY_ID to TEXT,
                FavoriteMatch.TEAM_HOME_NAME to TEXT, FavoriteMatch.TEAM_AWAY_NAME to TEXT,
                FavoriteMatch.TEAM_HOME_SCORE to TEXT, FavoriteMatch.TEAM_AWAY_SCORE to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(FavoriteMatch.TABLE_FAVORITE_MATCH, true)
    }
}

val Context.database: DatabaseOpenHelper
    get() = DatabaseOpenHelper.getInstance(applicationContext)