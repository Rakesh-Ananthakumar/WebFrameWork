package com.example.day5cy1.service;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.day5cy1.model.Shirt;
import com.example.day5cy1.repository.ShirtRepo;

@Service
public class ShirtService {
    private ShirtRepo shirtRepo;

    public ShirtService(ShirtRepo shirtRepo) {
        this.shirtRepo = shirtRepo;
    }

    public boolean saveShirt(Shirt shirt)
    {
        try
        {
            shirtRepo.save(shirt);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean updateDetails(int id,Shirt shirt)
    {
        if(this.getShirtById(id)==null)
        {
            return false;
        }
        try{
            shirtRepo.save(shirt);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public boolean deleteShirt(int id)
    {
        if(this.getShirtById(id) == null)
        {
            return false;
        }
        shirtRepo.deleteById(id);
        return true;
    }
    public Shirt getShirtById(int id)
    {
        return shirtRepo.findById(id).orElse(null);
    }
    public List<Shirt> getListShirt()
    {
        return shirtRepo.findAll();
    }
}