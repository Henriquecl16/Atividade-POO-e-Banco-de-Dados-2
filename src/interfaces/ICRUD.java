package interfaces;

import java.util.List;

public interface ICRUD<T> {

    T salvar(T objeto);

    void deletar(int id);

    void alterar(T objeto);

    T consultar(int id);

    List<T> consultar();

}