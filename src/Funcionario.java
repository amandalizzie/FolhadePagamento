abstract class Funcionario {
    public static final double SALARIO_BASE = 2000.00;
    private String nome;
    private String matricula;

    public Funcionario(String nome, String matricula) {
        this.nome = (nome.isBlank()) ? null : nome;
        this.matricula = (matricula.isBlank()) ? null : matricula;
    }

    public String mostrarNome() {
        return (nome == null) ? "Não informado" : nome;
    }

    public String mostrarMatricula() {
        return (matricula == null) ? "Não informada" : matricula;
    }

    public abstract double calcularSalario();
    public abstract String mostrarDados();
}

class FuncionarioPadrao extends Funcionario {
    public FuncionarioPadrao(String nome, String matricula) {
        super(nome, matricula);
    }

    @Override
    public double calcularSalario() {
        return SALARIO_BASE;
    }

    @Override
    public String mostrarDados() {
        return "----------------------------------\n" +
                "Nome: " + mostrarNome() + "\n" +
                "Matrícula: " + mostrarMatricula() + "\n" +
                "Salário Base: R$ " + String.format("%.2f", SALARIO_BASE) + "\n" +
                "Tipo: Funcionário Padrão\n" +
                "Salário Final: R$ " + String.format("%.2f", calcularSalario()) + "\n";
    }
}

class FuncionarioComissionado extends Funcionario {
    private Double vendas;
    private Double percentual;

    public FuncionarioComissionado(String nome, String matricula, Double vendas, Double percentual) {
        super(nome, matricula);
        this.vendas = vendas;
        this.percentual = percentual;
    }

    public double calcularComissao() {
        double v = (vendas == null) ? 0 : vendas;
        double p = (percentual == null) ? 0 : percentual;
        return v * p / 100;
    }

    @Override
    public double calcularSalario() {
        return SALARIO_BASE + calcularComissao();
    }

    public String mostrarVendas() {
        return (vendas == null) ? "Não informado" : "R$ " + String.format("%.2f", vendas);
    }

    public String mostrarPercentual() {
        return (percentual == null) ? "Não informado" : percentual + "%";
    }

    @Override
    public String mostrarDados() {
        return "----------------------------------\n" +
                "Nome: " + mostrarNome() + "\n" +
                "Matrícula: " + mostrarMatricula() + "\n" +
                "Salário Base: R$ " + String.format("%.2f", SALARIO_BASE) + "\n" +
                "Tipo: Funcionário Comissionado\n" +
                "Vendas: " + mostrarVendas() + "\n" +
                "Percentual: " + mostrarPercentual() + "\n" +
                "Comissão: R$ " + String.format("%.2f", calcularComissao()) + "\n" +
                "Salário Final: R$ " + String.format("%.2f", calcularSalario()) + "\n";
    }
}

class FuncionarioProducao extends Funcionario {
    private Double valorPeca;
    private Integer quantidade;

    public FuncionarioProducao(String nome, String matricula, Double valorPeca, Integer quantidade) {
        super(nome, matricula);
        this.valorPeca = valorPeca;
        this.quantidade = quantidade;
    }

    public double calcularBonus() {
        double v = (valorPeca == null) ? 0 : valorPeca;
        int q = (quantidade == null) ? 0 : quantidade;
        return v * q;
    }

    @Override
    public double calcularSalario() {
        return SALARIO_BASE + calcularBonus();
    }

    public String mostrarValorPeca() {
        return (valorPeca == null) ? "Não informado" : "R$ " + String.format("%.2f", valorPeca);
    }

    public String mostrarQuantidade() {
        return (quantidade == null) ? "Não informado" : quantidade + "";
    }

    @Override
    public String mostrarDados() {
        return "----------------------------------\n" +
                "Nome: " + mostrarNome() + "\n" +
                "Matrícula: " + mostrarMatricula() + "\n" +
                "Salário Base: R$ " + String.format("%.2f", SALARIO_BASE) + "\n" +
                "Tipo: Funcionário Produção\n" +
                "Valor por Peça: " + mostrarValorPeca() + "\n" +
                "Quantidade: " + mostrarQuantidade() + "\n" +
                "Bônus: R$ " + String.format("%.2f", calcularBonus()) + "\n" +
                "Salário Final: R$ " + String.format("%.2f", calcularSalario()) + "\n";
    }
}