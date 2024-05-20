package Calculo;

public class CalculoConversao {
    private double pesoArgentino;
    private double moedaBoliviana;
    private double real;
    private double pesoChileno;
    private double pesoColombiano;
    private double dolar;

    public CalculoConversao(TaxaConversao taxaConversao){
        this.pesoArgentino = taxaConversao.ARS();
        this.moedaBoliviana = taxaConversao.BOB();
        this.real = taxaConversao.BRL();
        this.pesoChileno = taxaConversao.CLP();
        this.pesoColombiano = taxaConversao.COP();
        this.dolar = taxaConversao.USD();
    }

    public double conversaoMoeda(double valor, double taxa){
        double novoValor = valor * taxa;
        return novoValor;
    }
    public double conversaoDolar(double valor, double taxa){
        double novoValor = valor/taxa;
        return novoValor;
    }

    public double getPesoArgentino() {
        return pesoArgentino;
    }

    public double getMoedaBoliviana() {
        return moedaBoliviana;
    }

    public double getReal() {
        return real;
    }

    public double getPesoChileno() {
        return pesoChileno;
    }

    public double getPesoColombiano() {
        return pesoColombiano;
    }
}
