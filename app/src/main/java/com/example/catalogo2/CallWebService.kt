package com.example.catalogo2

import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

class CallWebService {
    fun callApi(methodName: String, input1: String?): String { // Cambiar por parametros del tester (4 parametros)
        //fun callApi(methodName: String, input1: Int?, input2: Int?): String {  --> WSLocal Calculadora
        var result = ""
        val SOAP_ACTION = Utils.SOAP_NAMESPACE + methodName
        val soapObject = SoapObject(Utils.SOAP_NAMESPACE, methodName)
        //soapObject.addProperty("numero1", input1)
        //soapObject.addProperty("j", input2)

        soapObject.addProperty("id", input1)
        //soapObject.addProperty("consulta", input2)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = false //Esto va a false cuando el servicio es de Java y true a .net
        val httpTransportSE = HttpTransportSE(Utils.SOAP_URL)

        try {
            httpTransportSE.call(SOAP_ACTION, envelope)
            val soapPrimitive = envelope.response
            result = soapPrimitive.toString()
            //result = soapPrimitive.toString()
        } catch (e: Exception) {
            e.printStackTrace()
        }


        return result
    }
}