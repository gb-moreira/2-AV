// Define o pacote onde a classe está localizada.
package com.example.restaurante

// Importa as bibliotecas necessárias para a funcionalidade da classe.
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

// Declara a classe PedidoActivity que herda de AppCompatActivity, oferecendo funcionalidades básicas de compatibilidade.
class PedidoActivity : AppCompatActivity() {
    
    // Declara uma variável 'binding' para vinculação de interface de usuário com inicialização tardia.
    private lateinit var binding: ActivityPedidoBinding

    // Sobrescreve o método onCreate, chamado quando a atividade é inicialmente criada.
    override fun onCreate(savedInstanceState: Bundle?) {

        // Inicializa o objeto de vinculação com o layout da atividade de pedidos.
        binding = ActivityPedidoBinding.inflate(layoutInflater)

         // Chama o método onCreate da classe base para completar a criação da atividade.
        super.onCreate(savedInstanceState)

        // Define a visualização da atividade para o root do objeto de vinculação.
        setContentView(binding.root)

        // Recebe a intenção que iniciou esta atividade.
        val i = intent

        // Recupera o valor da quantidade de pizza da intenção e converte para inteiro.
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()

         // Recupera o valor da quantidade de salada da intenção e converte para inteiro.
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()

        // Recupera o valor da quantidade de hambúrguer da intenção e converte para inteiro.
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()

        // Constrói uma string que resume o pedido, incluindo quantidade e preço calculado.
        val texto = "Resumo do Pedido\n" +
                "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
                "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
                "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"

        // Atribui a string construída ao componente TextView na interface de usuário para exibir o resumo do pedido.
        binding.textResumo.text = texto

    }
}
