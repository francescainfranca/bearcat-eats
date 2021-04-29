package com.example.bearcateats.retrofit;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit;
    private static final String BASE_URL = "https://francescainfranca.github.io/menuJSON/?fbclid=IwAR0JmLY2QlGeffdMJmXDX_Lj2tEiX-9YdNrsnJwTWyQOjHRGTkx8Z0zQmYe";

    public static Retrofit getRetrofitInstance(){

        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                 .build();

        }
        return retrofit;
    }

}
