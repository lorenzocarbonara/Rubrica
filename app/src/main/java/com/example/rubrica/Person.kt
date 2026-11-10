package com.example.rubrica
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "People")
data class Person(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "surname") val surname: String?,
    @ColumnInfo(name = "number") val tel: String?
)
