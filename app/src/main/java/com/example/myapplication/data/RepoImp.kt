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
    override suspend fun getAppObjRepo(): Flow<Resource<App>> = callbackFlow{
        /* código de anterior commit
        val resultData = FirebaseFirestore.getInstance()
            .collection("setting")
            .document("app")
            .get()
            .await()

        val dat3 = resultData.getLong("version")
        val dat1 = resultData.getLong("color")
        val dat2 = resultData.getString("tittle")
        val app = App(dat1!!.toInt(),dat2.toString(),dat3!!.toInt())

        return Resource.Success(app)*/
        /* //en este caso  aplicar Flow<Resource<App>> = flow {    nose podria ya que emit() estaria dentro de .addSnapshotListener {
        var version: Int? = null
        val resultData = FirebaseFirestore.getInstance()
            .collection("setting")
            .document("app")
            .addSnapshotListener { documentSnapshot, firebaseFirestoreException ->
                version = documentSnapshot!!.getLong("version")!!.toInt()
                val app = App(2,"hola1",version!!)
                emit(Resource.Success(app))
            }*/

        val resultado = FirebaseFirestore.getInstance()
            .collection("setting")
            .document("app")
            .addSnapshotListener { snapshot, exception ->
            if(snapshot!!.exists()){
                val dat3 = snapshot.getLong("version")
                val dat1 = snapshot.getLong("color")
                val dat2 = snapshot.getString("tittle")
                val app = App(dat1!!.toInt(),dat2.toString(),dat3!!.toInt())
                offer(Resource.Success(app))
            }
        }

        awaitClose { resultado.remove() }

    }

}