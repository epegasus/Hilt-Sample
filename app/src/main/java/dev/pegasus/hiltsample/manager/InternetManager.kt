package dev.pegasus.hiltsample.manager

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.util.Log
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by: Sohaib Ahmed
 * Date: 2/11/2025
 *
 * Links:
 * - LinkedIn: https://linkedin.com/in/epegasus
 * - GitHub: https://github.com/epegasus
 */

@Singleton
class InternetManager @Inject constructor(@ApplicationContext context: Context) {

    private val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    val isInternetConnected: Boolean
        get() {
            try {
                val network = connectivityManager.activeNetwork ?: return false
                val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false
                return when {
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN) -> true
                    else -> false
                }
            } catch (ex: Exception) {
                Log.e(TAG, "isInternetConnected: ", ex)
                return false
            }
        }

    companion object {
        const val TAG = "InternetManager"
    }
}