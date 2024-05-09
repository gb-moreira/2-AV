// Define o pacote onde a classe está localizada.
package com.example.restaurante

// Importa as bibliotecas necessárias para a funcionalidade da classe.
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

// Declara a classe SplashActivity que herda de AppCompatActivity.
class SplashActivity : AppCompatActivity() {

    // Sobrescreve o método onCreate da classe base AppCompatActivity, que é chamado quando a atividade é inicialmente criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o layout da atividade usando o arquivo XML correspondente.
        setContentView(R.layout.activity_splash)

        // Cria um Handler que posta um Runnable para ser executado após um delay.
        Handler(Looper.getMainLooper()).postDelayed({

            / Recupera a intenção que iniciou esta atividade.
            val i = intent

            // Cria uma nova intenção para iniciar a PedidoActivity.
            val j = Intent(this,PedidoActivity::class.java)

            // Copia todos os extras da intenção inicial para a nova intenção.
            j.putExtras(i)

            // Inicia a PedidoActivity.
            startActivity(j)
            
        },2000)// Define o delay de 2 segundos antes de iniciar a atividade.

    }
}
