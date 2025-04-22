package com.example.voicecalculator;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult, tvSpeechResult;
    private Button btnVoiceInput, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    private Button btnDot, btnAdd, btnSub, btnMul, btnDiv, btnEqual, btnClear, btnSqrt, btnPow, btnMod;
    private Handler handler = new Handler();
    private Runnable timeoutRunnable;
    private static final int SPEECH_TIMEOUT_MS = 10000; // 10 seconds
    private static final int REQUEST_RECORD_AUDIO_PERMISSION = 200;
    private static final int SPEECH_REQUEST_CODE = 1001;
    private String currentInput = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI components
        tvResult = findViewById(R.id.tvResult);
        tvSpeechResult = findViewById(R.id.tvSpeechResult);
        btnVoiceInput = findViewById(R.id.btnVoiceInput);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnDot = findViewById(R.id.btnDot);
        btnAdd = findViewById(R.id.btnAdd);
        btnSub = findViewById(R.id.btnSub);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnEqual = findViewById(R.id.btnEqual);
        btnClear = findViewById(R.id.btnClear);
        btnSqrt = findViewById(R.id.btnSqrt);
        btnPow = findViewById(R.id.btnPow);
        btnMod = findViewById(R.id.btnMod);

        // Check for RECORD_AUDIO permission
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{android.Manifest.permission.RECORD_AUDIO},
                    REQUEST_RECORD_AUDIO_PERMISSION);
        }

        // Button click listeners for manual input
        View.OnClickListener numberListener = v -> {
            Button b = (Button) v;
            currentInput += b.getText().toString();
            tvResult.setText(currentInput);
        };
        btn0.setOnClickListener(numberListener);
        btn1.setOnClickListener(numberListener);
        btn2.setOnClickListener(numberListener);
        btn3.setOnClickListener(numberListener);
        btn4.setOnClickListener(numberListener);
        btn5.setOnClickListener(numberListener);
        btn6.setOnClickListener(numberListener);
        btn7.setOnClickListener(numberListener);
        btn8.setOnClickListener(numberListener);
        btn9.setOnClickListener(numberListener);

        btnDot.setOnClickListener(v -> {
            if (!currentInput.contains(".")) {
                currentInput += ".";
                tvResult.setText(currentInput);
            }
        });

        View.OnClickListener operatorListener = v -> {
            Button b = (Button) v;
            currentInput += " " + b.getText().toString() + " ";
            tvResult.setText(currentInput);
        };
        btnAdd.setOnClickListener(operatorListener);
        btnSub.setOnClickListener(operatorListener);
        btnMul.setOnClickListener(operatorListener);
        btnDiv.setOnClickListener(operatorListener);
        btnMod.setOnClickListener(operatorListener);

        btnSqrt.setOnClickListener(v -> {
            try {
                double num = Double.parseDouble(currentInput);
                double result = Math.sqrt(num);
                currentInput = String.valueOf(result);
                tvResult.setText(currentInput);
            } catch (Exception e) {
                tvResult.setText("Error");
            }
        });

        btnPow.setOnClickListener(v -> {
            try {
                double num = Double.parseDouble(currentInput);
                double result = num * num;
                currentInput = String.valueOf(result);
                tvResult.setText(currentInput);
            } catch (Exception e) {
                tvResult.setText("Error");
            }
        });

        btnEqual.setOnClickListener(v -> calculateFromInput());
        btnClear.setOnClickListener(v -> {
            currentInput = "";
            tvResult.setText("0");
            tvSpeechResult.setText("Speak or use buttons");
        });

        // Button click to start Google speech recognition
        btnVoiceInput.setOnClickListener(v -> {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.RECORD_AUDIO)
                    == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "en-US");
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak now (10s timeout)");
                startTimeout();
                try {
                    startActivityForResult(intent, SPEECH_REQUEST_CODE);
                } catch (Exception e) {
                    tvSpeechResult.setText("Speech recognition not supported");
                    stopTimeout();
                }
            } else {
                tvSpeechResult.setText("Permission not granted");
            }
        });
    }

    private void startTimeout() {
        timeoutRunnable = new Runnable() {
            @Override
            public void run() {
                tvSpeechResult.setText("No voice detected, microphone off");
                // Note: Intent-based recognition can't be stopped programmatically; user must cancel
            }
        };
        handler.postDelayed(timeoutRunnable, SPEECH_TIMEOUT_MS);
    }

    private void stopTimeout() {
        handler.removeCallbacks(timeoutRunnable);
    }

    private void calculateFromInput() {
        try {
            String[] parts = currentInput.split(" ");
            if (parts.length == 3) {
                double num1 = Double.parseDouble(parts[0]);
                String operator = parts[1];
                double num2 = Double.parseDouble(parts[2]);
                double result = 0;

                switch (operator) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        if (num2 != 0) result = num1 / num2;
                        else {
                            tvResult.setText("Error: Division by zero");
                            return;
                        }
                        break;
                    case "%":
                        result = num1 % num2;
                        break;
                }
                currentInput = String.valueOf(result);
                tvResult.setText(currentInput);
            }
        } catch (Exception e) {
            tvResult.setText("Error");
        }
    }

    private void calculateFromSpeech(String speech) {
        speech = speech.toLowerCase()
                .replace("plus", "+")
                .replace("minus", "-")
                .replace("times", "*")
                .replace("divided by", "/")
                .replace("divide", "/")
                .replace("mod", "%")
                .replace("square root", "√")
                .replace("power", "x²");

        Pattern pattern = Pattern.compile("(\\d+\\.?\\d*)\\s*([+\\-*/%]|[√x²])\\s*(\\d+\\.?\\d*)?");
        Matcher matcher = pattern.matcher(speech);

        if (matcher.find()) {
            try {
                double num1 = Double.parseDouble(matcher.group(1));
                String operator = matcher.group(2);
                double num2 = matcher.group(3) != null ? Double.parseDouble(matcher.group(3)) : 0;
                double result = 0;

                if (operator.equals("√")) {
                    result = Math.sqrt(num1);
                } else if (operator.equals("x²")) {
                    result = num1 * num1;
                } else {
                    switch (operator) {
                        case "+":
                            result = num1 + num2;
                            break;
                        case "-":
                            result = num1 - num2;
                            break;
                        case "*":
                            result = num1 * num2;
                            break;
                        case "/":
                            if (num2 != 0) result = num1 / num2;
                            else {
                                tvResult.setText("Error: Division by zero");
                                return;
                            }
                            break;
                        case "%":
                            result = num1 % num2;
                            break;
                    }
                }
                currentInput = String.valueOf(result);
                tvResult.setText(currentInput);
            } catch (Exception e) {
                tvResult.setText("Error: Invalid input");
            }
        } else {
            tvResult.setText("Error: Could not parse");
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        stopTimeout();
        if (requestCode == SPEECH_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            ArrayList<String> results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            if (results != null && !results.isEmpty()) {
                String spokenText = results.get(0);
                tvSpeechResult.setText(spokenText);
                calculateFromSpeech(spokenText);
            } else {
                tvSpeechResult.setText("No speech detected");
            }
        } else if (resultCode == RecognizerIntent.RESULT_NO_MATCH) {
            tvSpeechResult.setText("No match found");
        } else if (resultCode == RecognizerIntent.RESULT_CLIENT_ERROR) {
            tvSpeechResult.setText("Client error");
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_RECORD_AUDIO_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopTimeout();
    }
}