package net.weg.topcar.model.usuarios;

import net.weg.topcar.dao.IBanco;
import net.weg.topcar.model.automoveis.Automovel;
import net.weg.topcar.model.exceptions.AcessoNegadoException;
import net.weg.topcar.model.exceptions.ObjetoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class Gerente extends Vendedor implements IGerente{

    public Gerente(String nome, Long cpf, String senha, Long idade, double salario) {
        super(nome, cpf, senha, idade, salario);
    }

    public String menu() {
        return super.menu() +
                """
                7 - Registrar automóvel;
                8 - Remover automóvel;
                9 - Editar automóvel;
                10 - Editar preço;
                11 - Registrar usuário;
                12 - Remover usuário;
                13 - Editar usuário;
                14 - Ver vendedores;
                15 - Ver clientes;
                16 - Ver pagamentos dos vendedores;
                17 - Ver pagamento de um vendedor;
                """;
    }

    @Override
    public String editarUsuario(Cliente clieteEditado, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException {
    banco.alterar(clieteEditado.getCpf(), clieteEditado);
    return "Usuário editado!";
    }


//    @Override
//    public void venderAutomovel(Automovel automovel, Cliente cliente) {
//        cliente.adicionarProprioAutomovel(automovel);
//        this.setComissoes(automovel.getPreco() * 0.02);
//    }
    @Override
    public String registrarAutomovel(IBanco<Automovel, String> banco, Automovel automovel) {
        banco.adicionar(automovel);
        return "Automóvel registrado";
    }
    @Override
    public String removerAutomovel(IBanco<Automovel, String> banco, String codigo) throws ObjetoNaoEncontradoException, AcessoNegadoException {
        banco.remover(codigo);
        return "Automóvel removido";
    }

    /**
     * Método responsável por iniciar a ação de edição de um automóvel em nível de repositório (DAO).
     * O parametro de automóvel rece as informações editadas do automóvel, já o parametro de banco
     * recebe qual o repositório manipula objetos do tipo Automóvel.
     * O id do automóvel permanecerá o mesmo, por essse motivo é possível pegar o mesmo id presente
     * no objeto editado.
     * @param automovelEditado
     * @param banco
     * @throws ObjetoNaoEncontradoException
     */
    @Override
    public String editarAutomovel(Automovel automovelEditado, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        banco.alterar(automovelEditado.getCODIGO(), automovelEditado);
        return "Automóvel editado!";
    }

    @Override
    public String editarPreco(String codigo, double preco, IBanco<Automovel, String> banco) throws ObjetoNaoEncontradoException {
        Automovel automovel = banco.buscarUm(codigo);
        automovel.setPreco(preco);
        banco.alterar(codigo,automovel);
        return "Preço do automóvel editado!";
    }
    @Override
    public String registrarUsuario(Cliente cliente, IBanco<Cliente, Long> banco) throws AcessoNegadoException {
        if (!(cliente instanceof Gerente)){
            banco.adicionar(cliente);
            return "Usuário editado!";
        }
       throw new AcessoNegadoException("Usuario nao e um vendedor");
    }
    @Override
    public String removerUsuario(Long cpf, IBanco<Cliente, Long> banco) throws AcessoNegadoException, ObjetoNaoEncontradoException {
        Cliente cliente = banco.buscarUm(cpf);
        if (!(cliente instanceof Gerente)) {
            banco.remover(cpf);
            return "Usuário removido!";
        }
        throw new AcessoNegadoException("Usuario nao e um vendedor");
    }


//    public void editarUsuario(Usuario usuarioAntigo, Usuario usuarioNovo) {
//        usuarioAntigo.editarUsuario(usuarioNovo);
//    }
    @Override
    public List<Vendedor> verVendedores(IBanco<Cliente, Long> banco) {
//        List<Cliente> listaVendedores = banco.buscarTodos();
//        listaVendedores.removeIf(cliente -> !(cliente instanceof Vendedor));

        List<Cliente> listaClientes = banco.buscarTodos();
        List<Vendedor> listaVendedores = new ArrayList<>();

        for (Cliente cliente : listaClientes) {
            if (cliente instanceof Vendedor vendedor) {
                listaVendedores.add(vendedor);
            }
        }
        return listaVendedores;
    }
    @Override
    public List<Cliente> verClientes(IBanco<Cliente, Long> banco) {
        return banco.buscarTodos();
    }

    @Override
    public List<String>verPagamentoVendedores(IBanco<Cliente, Long> banco){
        List<String> listaPagamentos = new ArrayList<>();
        for (Vendedor vendedor: verVendedores(banco)){
            listaPagamentos.add(vendedor.verPagamentoComNome());
        }
        return listaPagamentos;
    }

    @Override
    public String verPagamentoVendedor(Long cpf, IBanco<Cliente, Long> banco) throws ObjetoNaoEncontradoException {
        Cliente cliente = banco.buscarUm(cpf);
        if(cliente instanceof Vendedor vendedor){
            return vendedor.verPagamentoComNome();
        }
        throw new RuntimeException(
                "O usuário informado não é um vendedor");
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
