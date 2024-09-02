package com.example.base64converter;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextInput;
    private TextView textViewOutput;
    private Button buttonConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.editTextInput);
        textViewOutput = findViewById(R.id.textViewOutput);
        buttonConvert = findViewById(R.id.buttonConvert);

        buttonConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = editTextInput.getText().toString();
                String outputText = convertText(inputText);
                textViewOutput.setText(outputText);
            }
        });
    }

    private String convertText(String input) {
        try {
            // Tenta decodificar o texto como Base64
            byte[] decodedBytes = Base64.decode(input, Base64.DEFAULT);
            String decodedText = new String(decodedBytes);
            // Se a decodificação for bem-sucedida, retorna o texto decodificado
            return "Decodificado: " + decodedText;
        } catch (IllegalArgumentException e) {
            // Se a decodificação falhar, assume que o texto é normal e codifica em Base64
            String encodedText = Base64.encodeToString(input.getBytes(), Base64.DEFAULT);
            return "Codificado em Base64:\n" + encodedText.trim();
        }
    }
}
