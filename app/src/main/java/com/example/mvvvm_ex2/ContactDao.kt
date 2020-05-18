package com.example.mvvvm_ex2

import androidx.lifecycle.LiveData
import androidx.room.*

// ContactDao.kt

@Dao
interface ContactDao {

    @Query("SELECT * FROM contact ORDER BY name ASC")
    fun getAll(): LiveData<List<Contact>>//라이브 데이터 반환

    @Insert(onConflict = OnConflictStrategy.REPLACE)//REPLACE라서 수정의 역할을 함
    fun insert(contact: Contact)

    @Delete
    fun delete(contact: Contact)

}