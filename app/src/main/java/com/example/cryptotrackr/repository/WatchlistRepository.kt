package com.example.cryptotrackr.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject

class WatchlistRepository @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val auth: FirebaseAuth
) {
    private val userId get() = auth.currentUser?.uid ?: "guest"

    fun addToWatchlist(coinId: String) {
        firestore.collection("watchlists").document(userId)
            .collection("coins").document(coinId).set(mapOf("id" to coinId))
    }

    fun removeFromWatchlist(coinId: String) {
        firestore.collection("watchlists").document(userId)
            .collection("coins").document(coinId).delete()
    }

    fun getWatchlist(onResult: (List<String>) -> Unit) {
        firestore.collection("watchlists").document(userId)
            .collection("coins").get().addOnSuccessListener { docs ->
                onResult(docs.documents.map { it.id })
            }
    }
}
