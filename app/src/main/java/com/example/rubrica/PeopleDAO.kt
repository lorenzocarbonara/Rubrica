package com.example.rubrica
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PeopleDAO {
    @Query("SELECT * FROM People")
    fun getAll(): Array<Person>

    @Insert
    fun insert(vararg p: Person)

    @Update
    fun update(p: Person)

    @Delete
    fun delete(p: Person)

    @Query("SELECT * FROM People WHERE surname = :lastname")
    fun getFromSurname(lastname: String): Array<Person>
}