package ar.edu.untref.lp4.formulario;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private EditText nombre;
    private EditText apellido;

    private RadioGroup sexo;
    private RadioButton femenino;
    private RadioButton masculino;
    private int sexoSeleccionado;

    private EditText nacionalidad;
    private EditText provincia;
    private EditText localidad;

    private Button botonRegistrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializarCampos();

        botonRegistrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                seleccionarSexo();
                registrar();
            }
        });
    }

    private void inicializarCampos() {

        nombre = (EditText) findViewById(R.id.nombre);
        apellido = (EditText) findViewById(R.id.apellido);
        nacionalidad = (EditText) findViewById(R.id.pais);
        provincia = (EditText) findViewById(R.id.provincia);
        localidad = (EditText) findViewById(R.id.localidad);
        sexo = (RadioGroup) findViewById(R.id.radio_group_sexo);
        femenino = (RadioButton) findViewById(R.id.femenino);
        masculino = (RadioButton) findViewById(R.id.masculino);
        botonRegistrar = (Button) findViewById(R.id.registrar);
    }

    private void seleccionarSexo() {

        femenino.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sexoSeleccionado = 0;
                Log.e("Sexo seleccionado ---> ", "Femenino");
            }
        });

        masculino.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                sexoSeleccionado = 1;
                Log.e("Sexo seleccionado ---> ", "Masculino");
            }
        });
    }

    private boolean validarCampos() {

        boolean nombreValido = !nombre.getText().toString().equals("");
        boolean apellidoValido = !apellido.getText().toString().equals("");
        boolean nacionalidadValida = !nacionalidad.getText().toString().equals("");
        boolean provinciaValida = !provincia.getText().toString().equals("");
        boolean localidadValida = !localidad.getText().toString().equals("");

        Log.e("SEXO SELECCIONADO ----> ", "" + sexoSeleccionado);
        boolean sexoElegido = (sexoSeleccionado == 1 || sexoSeleccionado == 0);


        if (sexoElegido && nombreValido && apellidoValido && nacionalidadValida && provinciaValida && localidadValida) {

            return true;

        } else {

            return false;
        }
    }

    private void registrar() {

        boolean camposValidos = validarCampos();

        if (camposValidos) {

            Intent intent = new Intent(this, RegistroCompleto.class);
            startActivity(intent);
            finish();

        } else {

            Toast.makeText(getApplicationContext(), "Debe completar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}
