package com.example.rubrica
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// Create the database
@Database(entities = [Person::class], version = 1)
abstract class PeopleDatabase : RoomDatabase() {
    abstract fun getDao(): PeopleDAO
    companion object {
        @Volatile
        private var INSTANCE: PeopleDatabase? = null
        fun getInstance(context: Context): PeopleDatabase
        {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    PeopleDatabase::class.java, "people_db"
                )
                    .build()
            }
        }

    }
}