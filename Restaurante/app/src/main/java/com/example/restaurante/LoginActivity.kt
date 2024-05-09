// Define o pacote onde a classe está localizada.
package com.example.restaurante

// Importa as bibliotecas necessárias para a funcionalidade da classe.
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

// Declara a classe LoginActivity que herda de AppCompatActivity, proporcionando compatibilidade com versões anteriores do Android.
class LoginActivity : AppCompatActivity() {
    
//Criação da variável binding que servirá para manipular a tela.
    private lateinit var binding:ActivityLoginBinding
    
 // Sobrescreve o método onCreate da classe AppCompatActivity, que é chamado quando a atividade é inicialmente criada.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Infla o layout da atividade de login e inicializa a variável 'binding'.
        binding = ActivityLoginBinding.inflate(layoutInflater)
        
        // Define a visualização da atividade para o root do binding, que contém todos os elementos da interface de usuário do arquivo XML.
        setContentView(binding.root)

        // Define um ouvinte de clique para o botão "Entrar".
        binding.buttonEntrar.setOnClickListener {

             // Extrai o texto do campo de nome de usuário e remove espaços em branco desnecessários.
            val username = binding.editUsername.text.toString().trim()

            // Extrai o texto do campo de senha e remove espaços em branco desnecessários.
            val password = binding.editPassword.text.toString().trim()

           // Verifica se o nome de usuário e a senha correspondem a "abc" e "123", respectivamente.
            if (username.equals("abc") && password.equals("123")) {

                 // Cria uma nova intenção para iniciar MainActivity se as credenciais estiverem corretas.
                val i = Intent(this, MainActivity::class.java)

                // Adiciona o nome de usuário como um extra na intenção.
                i.putExtra("username", username)

                 // Inicia a MainActivity.
                startActivity(i)

                // Finaliza a LoginActivity para que ela não seja acessível ao pressionar o botão Voltar.
                finish()

                // Mostra um Toast (mensagem flutuante) informando que as credenciais estão incorretas.
            } else {
                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}
