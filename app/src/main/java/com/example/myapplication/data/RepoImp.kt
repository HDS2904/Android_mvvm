package com.example.myapplication.data

import android.util.Log
import com.example.myapplication.model.App
import com.example.myapplication.vo.Resource
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.tasks.await

class RepoImp: IRepo {

    @ExperimentalCoroutinesApi
    override suspend fun getAppObjRepo(): Resource<List<User>> {
        /*
        val resultData = FirebaseFirestore.getInstance()
            .collection("setting")
            .document("app")
            .get()
            .await()

        val dat3 = resultData.getLong("version")
        val dat1 = resultData.getLong("color")
        val dat2 = resultData.getString("tittle")
        val app = App(dat1!!.toInt(), dat2.toString(), dat3!!.toInt())

        return Resource.Success(app)*/
        val r1 = User(0,"usuario1","1.25")

        var res = arrayListOf<User>()

        res.add(r1)
        return Resource.Success(res)
    }

}