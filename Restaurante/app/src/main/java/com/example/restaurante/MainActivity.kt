// Define o pacote onde a classe está localizada.
package com.example.restaurante

// Importa as bibliotecas necessárias para a funcionalidade da classe.
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

// Declara a classe MainActivity que herda de AppCompatActivity, proporcionando compatibilidade com versões anteriores do Android.
class MainActivity : AppCompatActivity() {
    
    // Declara uma variável 'binding' de forma tardia para vinculação da interface de usuário, será inicializada mais tarde.
    private lateinit var binding:ActivityMainBinding
    
     // Sobrescreve o método onCreate da classe AppCompatActivity, que é chamado quando a atividade é inicialmente criada.
    override fun onCreate(savedInstanceState: Bundle?) {

        // Infla o layout da atividade principal e inicializa a variável 'binding'.
        binding = ActivityMainBinding.inflate(layoutInflater)
        
        // Chama o método onCreate da classe base (AppCompatActivity) para completar a criação da atividade. 
        super.onCreate(savedInstanceState)

         // Define a visualização da atividade para o root do binding, que contém todos os elementos da interface de usuário do arquivo XML.
        setContentView(binding.root)

       // Tenta recuperar o nome de usuário passado pela LoginActivity.
        val username = intent.extras?.getString("username")

        // Verifica se o nome de usuário não é nulo ou vazio e atualiza o texto de boas-vindas.
        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }

        // Define um ouvinte de clique para o botão "Fechar", que finaliza todas as atividades da pilha de atividades.
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }

        // Define um ouvinte de clique para o botão "Pedir".
        binding.buttonPedir.setOnClickListener {

            // Cria uma nova intenção para iniciar a SplashActivity.
            val i = Intent(this, SplashActivity::class.java)

            // Adiciona as quantidades de pizza, salada e hambúrguer como extras na intenção.
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())

            // Inicia a SplashActivity.
            startActivity(i)

            // Finaliza a MainActivity.
            finish()
        }


        // Define um ouvinte de clique para o checkbox de pizza.
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){

                // Se estiver marcado, define a quantidade de pizza como 1 e mostra o preço.
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{

                // Se não estiver marcado, define a quantidade de pizza como 0 e oculta o preço.
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }

        // Define um ouvinte de clique para o checkbox de salada.
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){

                 // Se estiver marcado, define a quantidade de salada como 1 e mostra o preço.
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{

           // Se não estiver marcado, define a quantidade de salada como 0 e oculta o preço.
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }

         // Define um ouvinte de clique para o checkbox de hamburguer.
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){

                 // Se estiver marcado, define a quantidade de hamburguer como 1 e mostra o preço.
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{

               // Se não estiver marcado, define a quantidade de hamburguer como 0 e oculta o preço.
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}
