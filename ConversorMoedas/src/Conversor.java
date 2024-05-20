import Calculo.CalculoConversao;
import Calculo.TaxaConversao;
import Conexao.ConexaoAPI;
import com.google.gson.*;
import java.io.IOException;
import java.util.Scanner;


public class Conversor {
    public static void main(String[] args) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        ConexaoAPI api = new ConexaoAPI();

        JsonObject dados = api.puxarDados();
        JsonObject valores = dados.get("conversion_rates").getAsJsonObject();
        TaxaConversao taxas = gson.fromJson(valores, TaxaConversao.class);
        CalculoConversao conversao = new CalculoConversao(taxas);

        Scanner ler = new Scanner(System.in);

        int controller = 0;

        while (controller != 7){
            System.out.println("****************************");
            System.out.println("Bem vindo ao conversor de moedas\n");
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso Argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real brasileiro");
            System.out.println("4) Real brasileiro =>> Dólar");
            System.out.println("5) Dólar =>> Peso Colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Sair");
            System.out.println("Escolha uma opção válida:");
            System.out.println("****************************");
            controller = ler.nextInt();
            double valor;

            switch (controller){
                case 1:
                    System.out.println("Digite o valor que será convertido:");
                    valor = ler.nextInt();
                    System.out.println("\n" + valor + " Dólares equivalem a " + conversao.conversaoMoeda(valor, conversao.getPesoArgentino()) + " Pesos argentinos\n");
                    break;
                case 2:
                    System.out.println("Digite o valor que será convertido:");
                    valor = ler.nextInt();
                    System.out.println("\n" + valor + " Pesos argentinos equivalem a " + conversao.conversaoDolar(valor, conversao.getPesoArgentino()) + " Dólares\n");
                    break;
                case 3:
                    System.out.println("Digite o valor que será convertido:");
                    valor = ler.nextInt();
                    System.out.println("\n" + valor + " Dólares equivalem a " + conversao.conversaoMoeda(valor, conversao.getReal()) + " Reais\n");
                    break;
                case 4:
                    System.out.println("Digite o valor que será convertido:");
                    valor = ler.nextInt();
                    System.out.println("\n" + valor + " Reais equivalem a " + conversao.conversaoDolar(valor, conversao.getReal()) + " Dólares\n");
                    break;
                case 5:
                    System.out.println("Digite o valor que será convertido:");
                    valor = ler.nextInt();
                    System.out.println("\n" + valor + " Dólares equivalem a " + conversao.conversaoMoeda(valor, conversao.getPesoColombiano()) + " Pesos colombianos\n");
                    break;
                case 6:
                    System.out.println("Digite o valor que será convertido:");
                    valor = ler.nextInt();
                    System.out.println("\n" + valor + " Pesos colombianos equivalem a " + conversao.conversaoDolar(valor, conversao.getPesoColombiano()) + " Dólares\n");
                    break;
            }

        }
        System.out.println("Programa finalizando!");
    }
}
