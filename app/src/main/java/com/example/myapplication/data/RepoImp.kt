package com.example.myapplication.data

import com.example.myapplication.vo.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class RepoImp: IRepo {
    override suspend fun getVersionAppRepo(): Resource<Int> {

        val resultData = FirebaseFirestore.getInstance()
            .collection("setting")
            .document("app")
            .get()
            .await()

        val versionApp= resultData.getLong("version")

        return Resource.Success(versionApp!!.toInt())
    }

}