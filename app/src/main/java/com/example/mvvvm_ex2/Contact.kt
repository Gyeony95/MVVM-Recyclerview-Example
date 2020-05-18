package com.example.mvvvm_ex2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contact")//이거도 클래스명과 같으면 생략가능
data class Contact(
    @PrimaryKey(autoGenerate = true)//null일경우 자동을 들어가게 ㅇㅇ
    var id: Long?,

    @ColumnInfo(name = "name")//변수명 똑같이쓰면 생략가능
    var name: String,

    @ColumnInfo(name = "number")
    var number: String,

    @ColumnInfo(name = "initial")
    var initial: Char
) {
    constructor() : this(null, "", "", '\u0000')
}