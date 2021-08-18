package com.example.catalogo2

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

class Utils {
    companion object {

        //WSLocal & BD Remota
        val SOAP_URL =
            "http://192.168.0.2:8080/WSPr1P2/WSBdDatos?wsld"  //--- ip de mi maquina (localhost.......)
        val SOAP_NAMESPACE = "http://pkgServicio/"  //--- nombre de mi servicio
        val METHOD_CONS = "WSConsulta"  //--- nombre de mi metodo
        //val METHOD_DEL = "WSEliminar"  //--- nombre de mi metodo

        @SuppressLint("ServiceCast")

        fun isConnected(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as
                    ConnectivityManager
            val activeNetwork = cm.activeNetworkInfo
            return activeNetwork != null && activeNetwork.isConnectedOrConnecting

        }
    }
}