package com.example.agent.mqtt;
import android.util.Log;
import android.widget.Toast;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttHandler {

    private MqttClient client;

    public void connect(String brokerUrl, String clientId) {
        try {
            // Set up the persistence layer
            MemoryPersistence persistence = new MemoryPersistence();

            // Initialize the MQTT client
            client = new MqttClient(brokerUrl, clientId, persistence);

            // Set up the connection options
            MqttConnectOptions connectOptions = new MqttConnectOptions();
            connectOptions.setCleanSession(true);

            // Connect to the broker
            client.connect(connectOptions);

            // Log successful connection
            Log.d("MQTT", "Connected to broker: " + brokerUrl);
        } catch (MqttException e) {
            e.printStackTrace();
            // Log connection error
            Log.e("MQTT", "Failed to connect to broker: " + brokerUrl);
        }
    }

    public void disconnect() {
        try {
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publish(String topic, String message) {
        try {
            MqttMessage mqttMessage = new MqttMessage(message.getBytes());
            client.publish(topic, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(String topic) {
        try {
            client.subscribe("notfound", (t, msg) -> {
                String payload = new String(msg.getPayload());
                // Call the callback method to handle the received message
                handleMessage(payload);
                System.out.println("Message received from topic: " + t + " - " + payload);
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

// Callback method to handle received messages
    private void handleMessage(String message) {
        Log.d("MQTT", "Received message: " + message);
    }

}
