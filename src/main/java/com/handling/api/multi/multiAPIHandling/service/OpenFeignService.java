package com.handling.api.multi.multiAPIHandling.service;

import com.handling.api.multi.multiAPIHandling.openFeignInterface.OpenFeignCountry;
import com.handling.api.multi.multiAPIHandling.openFeignInterface.OpenFeignGNA;
import com.handling.api.multi.multiAPIHandling.openFeignInterface.OpenFeignStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpenFeignService {

    final private OpenFeignGNA openFeignGNA;
    final private OpenFeignCountry openFeignCountry;
    final private OpenFeignStorage openFeignStorage;

    @Autowired
    public OpenFeignService(OpenFeignGNA gna,OpenFeignCountry country,OpenFeignStorage storage){
        openFeignGNA = gna; openFeignCountry = country; openFeignStorage = storage;
    }

    public String getAllInfoOfGAN(){
        return openFeignGNA.gnaService();
    }

    public String getAllInfoOfCountry() {
        return openFeignCountry.countryService();
    }

    public String getAllInfoOfStorage() {
        return openFeignStorage.storageService();
    }
}
