package lista7.cone;

public class Cone {
    public static final double PI = 3.14;       
    public static final double REND_LITROS_POR_M2 = 3.45; 
    public static final double LATA_LITROS = 18.0;   

    public static final double PRECO_TIPO_1 = 238.90;
    public static final double PRECO_TIPO_2 = 467.98;
    public static final double PRECO_TIPO_3 = 758.34;

    private double raio;  
    private double altura; 
    private int nivel;     

    public Cone() {
        this(0.0, 0.0, 1);
    }

    public Cone(double raio, double altura) {
        this(raio, altura, 1);
    }

    public Cone(double raio, double altura, int nivel) {
        setRaio(raio);
        setAltura(altura);
        setNivel(nivel);
    }

    public Cone(Cone outro) {
        this(outro.raio, outro.altura, outro.nivel);
    }

    public double getRaio() { return raio; }
    public double getAltura() { return altura; }
    public int getNivel() { return nivel; }

    public void setRaio(double raio) {
        if (raio < 0) throw new IllegalArgumentException("Raio não pode ser negativo.");
        this.raio = raio;
    }

    public void setAltura(double altura) {
        if (altura < 0) throw new IllegalArgumentException("Altura não pode ser negativa.");
        this.altura = altura;
    }

    public void setNivel(int nivel) {
        if (nivel < 1 || nivel > 3) throw new IllegalArgumentException("Nível deve ser 1, 2 ou 3.");
        this.nivel = nivel;
    }
    public double geratriz() {
        return Math.sqrt(raio * raio + altura * altura);
    }

    public double areaFundo() {
        return PI * raio * raio;
    }

    public double areaLateral() {
        return PI * raio * geratriz();
    }

    public double areaTotal() {
        return areaLateral() + areaFundo();
    }

    public double litros() {
        return areaTotal() * REND_LITROS_POR_M2;
    }

    public int latas() {
        return (int) Math.ceil(litros() / LATA_LITROS);
    }

    public double precoPorNivel() {
        switch (nivel) {
            case 1: return PRECO_TIPO_1;
            case 2: return PRECO_TIPO_2;
            case 3: return PRECO_TIPO_3;
            default: throw new IllegalStateException("Nível inválido: " + nivel);
        }
    }

    public double precoTotal() {
        return latas() * precoPorNivel();
    }

    @Override
    public String toString() {
        String sep = "—————————–";
        StringBuilder sb = new StringBuilder();
        sb.append("– Cone\n");
        sb.append("Raio: ").append(raio).append('\n');
        sb.append("Altura: ").append(altura).append('\n');
        sb.append("Nível: ").append(nivel).append('\n');
        sb.append(sep).append('\n');
        sb.append("Geratriz: ").append(geratriz()).append('\n');
        sb.append(sep).append('\n');
        sb.append("Área do Fundo: ").append(areaFundo()).append('\n');
        sb.append("Área Lateral Cone: ").append(areaLateral()).append('\n');
        sb.append("Área Total: ").append(areaTotal()).append('\n');
        sb.append(sep).append('\n');
        sb.append("Litros: ").append(litros()).append('\n');
        sb.append("Latas: ").append(latas()).append('\n');
        sb.append(sep).append('\n');
        sb.append("Preço Total: ").append(precoTotal()).append('\n');
        return sb.toString();
    }
}
