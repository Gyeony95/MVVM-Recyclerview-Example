package com.example.mvvvm_ex2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

//액티비티의 context를 쓰면 액티비티 destroy되었을때 메모리 누수가 날 수 있음 따라서 어플리케이션의 context 사용을위해 application 인자로 받음
class ContactViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = ContactRepository(application)
    private val contacts = repository.getAll()

    fun getAll(): LiveData<List<Contact>> {
        return this.contacts
    }

    fun insert(contact: Contact) {
        repository.insert(contact)
    }

    fun delete(contact: Contact) {
        repository.delete(contact)
    }
}