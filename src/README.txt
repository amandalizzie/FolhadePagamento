==================================================
PROJETO: SISTEMA DE FOLHA DE PAGAMENTO
==================================================

OBJETIVO
Sistema para cadastrar funcionários e calcular salário.

REGRAS
- Salário base de todos: R$ 2.000,00
- 3 tipos de funcionários:
  1. Padrão: ganha só o salário base
  2. Comissionado: salário base + (vendas * percentual / 100)
  3. Produção: salário base + (valor por peça * quantidade feita)
- ✅ TODOS OS CAMPOS PODEM SER DEIXADOS VAZIOS
  • Guarda como nulo
  • Mostra "Não informado"
  • Nos cálculos, vale 0
- Nenhum valor pode ser negativo
- Dados salvos em lista

==================================================
1. FLUXOGRAMA
==================================================

--- MENU PRINCIPAL ---

INICIO
  ↓
MOSTRAR OPÇÕES:
  1 - Cadastrar Funcionário Padrão
  2 - Cadastrar Funcionário Comissionado
  3 - Cadastrar Funcionário Produção
  4 - Listar Todos os Funcionários
  0 - Sair do Sistema
  ↓
LER OPÇÃO
  ↓
┌───┬───┬───┬───┬───┐
│ 1 │ 2 │ 3 │ 4 │ 0 │
│Cad│Cad│Cad│Lis│Sai│
│Pad│Com│Pro│   │   │
└───┴───┴───┴───┴───┘
  ↓
VOLTA PRO MENU

--- CADASTRAR FUNCIONÁRIO PADRÃO ---

INICIO
  ↓
LER NOME → PODE VAZIO
  ↓
LER MATRÍCULA → PODE VAZIO
  ↓
SALVAR NA LISTA
  ↓
FUNCIONÁRIO CADASTRADO COM SUCESSO
  ↓
VOLTA PRO MENU

--- CADASTRAR FUNCIONÁRIO COMISSIONADO ---

INICIO
  ↓
LER NOME → PODE VAZIO
  ↓
LER MATRÍCULA → PODE VAZIO
  ↓
LER VALOR DAS VENDAS → PODE VAZIO
  ↓
SE DIGITOU: É NÚMERO E NÃO É NEGATIVO?
→ NÃO: avisa e pede de novo
→ SIM OU VAZIO: continua
  ↓
LER PERCENTUAL → PODE VAZIO
  ↓
SE DIGITOU: É NÚMERO E NÃO É NEGATIVO?
→ NÃO: avisa e pede de novo
→ SIM OU VAZIO: continua
  ↓
SALVAR NA LISTA
  ↓
FUNCIONÁRIO CADASTRADO COM SUCESSO
  ↓
VOLTA PRO MENU

--- CADASTRAR FUNCIONÁRIO PRODUÇÃO ---

INICIO
  ↓
LER NOME → PODE VAZIO
  ↓
LER MATRÍCULA → PODE VAZIO
  ↓
LER VALOR POR PEÇA → PODE VAZIO
  ↓
SE DIGITOU: É NÚMERO E NÃO É NEGATIVO?
→ NÃO: avisa e pede de novo
→ SIM OU VAZIO: continua
  ↓
LER QUANTIDADE FEITA → PODE VAZIO
  ↓
SE DIGITOU: É NÚMERO E NÃO É NEGATIVO?
→ NÃO: avisa e pede de novo
→ SIM OU VAZIO: continua
  ↓
SALVAR NA LISTA
  ↓
FUNCIONÁRIO CADASTRADO COM SUCESSO
  ↓
VOLTA PRO MENU

--- LISTAR FUNCIONÁRIOS ---

INICIO
  ↓
LISTA ESTÁ VAZIA?
→ SIM: avisa que não tem ninguém cadastrado
→ NÃO: mostra todos os dados UM ABAIXO DO OUTRO
   • Vazios aparecem como "Não informado"
   • Mostra salário de cada um
  ↓
MOSTRA O TOTAL DE TODOS OS SALÁRIOS
  ↓
VOLTA PRO MENU

==================================================
2. VALIDAÇÕES FEITAS
==================================================

✔ NÃO DEIXA USAR NÚMERO NEGATIVO
Se digitar valor menor que zero, mostra aviso e pede para digitar certo.

✔ SÓ ACEITA NÚMERO QUANDO DEVE SER NÚMERO
Se digitar letra no lugar de número, avisa e pede de novo.

✔ ACEITA VÍRGULA OU PONTO
Pode digitar R$ 1500,50 ou R$ 1500.50 que o sistema entende os dois.

✔ SÓ ACEITA OPÇÕES DO MENU
Só deixa escolher de 0 a 4, qualquer outro número é erro.

✔ ACEITA DEIXAR CAMPO VAZIO
Aperta ENTER e segue normalmente, não dá erro.

==================================================
3. COMO OS DADOS SÃO GUARDADOS
==================================================

Usamos uma lista (ArrayList) para guardar todos os funcionários.
Assim pode cadastrar quantos precisar, sem limite.

• Guarda: funcionarios.add( funcionario );
• Lê: passa um por um da lista para calcular e mostrar

• Campos vazios ficam como NULL
• Nos cálculos, valores nulos valem 0

==================================================
4. ARQUIVOS DO PROJETO
==================================================

Funcionario.java
- Classe geral e os 3 tipos de funcionário
- Tem o salário base de R$ 2000,00
- Tem as contas de cada salário
- Trata valores nulos

FolhaPagamento.java
- Organização do projeto

Main.java
- Menu principal
- Entrada e saída de dados
- Verificações
- Guarda e mostra os dados
- Mostra lista um abaixo do outro