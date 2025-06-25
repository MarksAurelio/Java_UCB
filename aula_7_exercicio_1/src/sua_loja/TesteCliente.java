package sua_loja;

public class TesteCliente {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Teste de Cadastro de Cliente ---");

        try {
            // Instanciando um cliente com forma de pagamento Visa
            Cliente cliente1 = new Cliente(
                    "Maria Araújo",
                    "Quadra 500",
                    EnumFPagamento.VISA);
            System.out.println(cliente1.toString());

            System.out.println("\n-----------------------\n");

            // Instanciando outro cliente como forma de pagamento Boleto
            Cliente cliente2 = new Cliente(
                    "João Silva",
                    "Quadra 600",
                    EnumFPagamento.BOLETO);
            System.out.println(cliente2.toString());

            System.out.println("\n-----------------------\n");

            // Exemplo de como mudar a forma de pagamento (se necessário)
            System.out.println("Alterando forma de pagamento do Cliente 1");
            cliente1.setFormaPagamento(EnumFPagamento.MASTERCARD);
            System.out.println(cliente1.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao criar cliente " + e.getMessage());
        }
    }
}
