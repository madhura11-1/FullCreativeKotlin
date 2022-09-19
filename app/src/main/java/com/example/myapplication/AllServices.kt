package com.example.myapplication

import java.time.Duration

class AllServices : Service() {

    companion object{
        @JvmStatic
        val allServices : ArrayList<Service> = arrayListOf<Service>()
    }

    fun createService(name : String, cost : Int, duration: Long){
        var service = Service()
        service.setNameS(name)
        service.setCostS(cost)
        service.setIntS(duration)
        allServices.add(service)
    }

    fun getAllServicesS() : ArrayList<Service>{
        return allServices
    }

}