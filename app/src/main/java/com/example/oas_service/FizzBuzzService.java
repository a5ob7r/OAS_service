package com.example.oas_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final IFizzBuzzService.Stub binder = new IFizzBuzzService.Stub() {
        @Override
        public List<String> fizzBuzz(int n) throws RemoteException {
            ArrayList<String> fizzbuzz = new ArrayList<String>();

            for (int i = 1; i <= n; ++i) {
                if (i%3 == 0 && i%5 == 0)
                    fizzbuzz.add("FizzBuzz");
                else if (i%3 == 0)
                    fizzbuzz.add("Fizz");
                else if (i%5 == 0)
                    fizzbuzz.add("Buzz");
                else
                    fizzbuzz.add(String.valueOf(i));
            }

            return fizzbuzz;
        }
    };
}

