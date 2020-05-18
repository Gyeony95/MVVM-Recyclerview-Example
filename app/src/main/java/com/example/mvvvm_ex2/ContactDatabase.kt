package com.example.mvvvm_ex2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

// ContactDatabase.kt

//RoomDatabase를 상속하는 추상클래스
@Database(entities = [Contact::class], version = 1)//엔티티와 sqlite버전 정의해줌
abstract class ContactDatabase: RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {//database 인스턴스를 싱글톤으로 만들기 위함
        private var INSTANCE: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase? {
            if (INSTANCE == null) {
                synchronized(ContactDatabase::class) {//synchronized는 여러 스레드가 접근하지 못하게 해줌 -> 동기화??
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        ContactDatabase::class.java, "contact")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE//여기서 만들어진 인스턴스는 Repogitory에서 호출해서 사용할것임
        }
    }

}