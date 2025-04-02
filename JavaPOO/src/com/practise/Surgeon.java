package com.practise;

public class Surgeon extends Doctor{


    @Override
    public void treatPatient()
    {
        System.out.println("Treating patient as a Surgeon");
    }

    public void makeIncision()
    {
        System.out.println("Making Incision");
    }
}
