package Veiculos;

import Exceptions.UsuarioNaoEncotradoException;
import Exceptions.VeiculoNaoEncontradoException;
import Interface.IBanco;
import Veiculos.Veiculos;
import Usuario.Usuario;

import java.util.*;

public class BancoVeiculos implements IBanco<Veiculos, String> {
        private List<Veiculos> listaAutomoveis;

        public List<Veiculos> buscarTodos() {
            return Collections.unmodifiableList(
                    listaAutomoveis);
        }

        public Veiculos buscarUm(String codigo)
            throws UsuarioNaoEncotradoException {
            for (Veiculos automovel : listaAutomoveis) {
                if (automovel.getCodigo().equals(codigo)) {
                    return automovel;
                }
            }
            throw new UsuarioNaoEncotradoException(codigo);
        }

        public void adicionar(Veiculos automovel) {
            listaAutomoveis.add(automovel);
        }

        public void remover(String codigo)
            throws UsuarioNaoEncotradoException {
            Veiculos automovel = buscarUm(codigo);
            listaAutomoveis.remove(automovel);
        }

        public void alterar(String cpf,
                            Veiculos novoUsuario)
            throws UsuarioNaoEncotradoException {
            Veiculos automovel = buscarUm(cpf);
            listaAutomoveis.set(
                    listaAutomoveis.indexOf(automovel),
                    novoUsuario);
        }
}