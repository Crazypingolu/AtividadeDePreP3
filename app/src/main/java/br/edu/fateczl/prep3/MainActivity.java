package br.edu.fateczl.prep3;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Variáveis:
    private EditText etQntTermos;
    private TextView tvAvisos;
    private TextView tvValorH;
    private Button btnValidar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // variáveis + interface:
        etQntTermos = findViewById(R.id.etQntTermos);
        etQntTermos.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvAvisos = findViewById(R.id.tvAviso);
        tvAvisos.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        tvValorH = findViewById(R.id.tvValorH);
        tvValorH.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        btnValidar = findViewById(R.id.btnValidar);
        btnValidar.setTextAlignment(TextView.TEXT_ALIGNMENT_CENTER);
        // Aciona o botão:
        btnValidar.setOnClickListener(click -> validar());
    }
    // Verifica o valor de termos
    public void validar() {
        float n = Float.parseFloat(etQntTermos.getText().toString());
        tvAvisos.setText(" ");
        tvValorH.setText(" ");
        String aviso;
        String totalH;
        if (n > 0 && n < 20){
            float h = calcH(n);
            totalH = getString(R.string.valorH) + " " + h;
            tvValorH.setText(totalH);
        } else {
            aviso = getString(R.string.aviso) + " NÚMERO INVÁLIDO, DIGITE NOVAMENTE.";
            tvAvisos.setText(aviso);
        }
    }
    // Calcula o valor de H
    public float calcH(float n) {
        float totalH = 3;
        for (int cto = 2; cto <= n; cto++){
            if((cto % 2) == 0){
                totalH = (cto + 1) * totalH;
            } else {
                totalH = (cto + 2) * totalH;
            }
        }
        return totalH;
    }
}