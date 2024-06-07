package com.example.agent;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.agent.mqtt.MqttHandler;
import com.example.agent.retrofit.ApiService;
import com.example.agent.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

   // private static final String TOPIC = "taskTopic_7";
    private static final String BROKER_URL = "tcp://broker.emqx.io:1883";
    private static final String CLIENT_ID = "spring-boot-client";
    private static final String BASE_URL = "http://192.168.100.152:8083/";
    private RetrofitService retrofitService;
    private ApiService mqttApi ;
   private MqttHandler mqttHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mqttHandler=new MqttHandler();
        mqttHandler.connect(BROKER_URL,CLIENT_ID);
        //createTopic("newTopic"); // Appel de l'API pour créer un nouveau topic
        //publishMessage("newTopic", "Hello"); // Publication sur le nouveau topic
        retrofitService = new RetrofitService(BASE_URL);
        mqttApi = retrofitService.getRetrofit().create(ApiService.class);

        getTopic();


    }

    @Override
    protected void onDestroy() {
        mqttHandler.disconnect();
        super.onDestroy();

    }
    private void publishMessage(String topic, String message){
        Toast.makeText(this, "Publishing message: " + message, Toast.LENGTH_SHORT).show();
        mqttHandler.publish(topic,message);
    }
    private void subscribeToTopic(String topic){
        Toast.makeText(this, "Subscribing to topic "+ topic, Toast.LENGTH_SHORT).show();
        mqttHandler.subscribe(topic);
    }
    //*******************
// Callback method to handle received messages
    private void handleMessage(String message) {
        // Display the received message in your UI
        Toast.makeText(this, "Received message: " + message, Toast.LENGTH_SHORT).show();
    }
    private void getTopic() {
        Call<String> call = mqttApi.getTopic();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    String topic = response.body();
                    subscribeToTopic(topic);
                    Toast.makeText(MainActivity.this, "Received topic: " + topic, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Received topic: " + topic); // Affichez le message dans Logcat
                } else {
                    Toast.makeText(MainActivity.this, "Failed to get topic", Toast.LENGTH_SHORT).show();
                    Log.e(TAG, "Failed to get topic"); // Affichez le message d'erreur dans Logcat
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e(TAG, "Error: " + t.getMessage()); // Affichez le message d'erreur dans Logcat
            }
        });
    }

}