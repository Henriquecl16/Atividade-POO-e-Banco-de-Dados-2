import java.util.List;
import java.util.Scanner;
import dao.ProdutoDao;
import modelos.Produto;

public class Main {

    public static void main(String[] args) {

        ProdutoDao dao = new ProdutoDao();
        Scanner teclado = new Scanner(System.in);
        int opcao = 0;
        int opcaoProduto;
        
        do {
        	System.out.println("\n===== MENU =====");
        	System.out.println("1 - Produtos");
        	System.out.println("2 - Clientes");
        	System.out.println("3 - Pedidos");
        	System.out.println("0 - Sair");
        	System.out.print("Escolha uma opção: ");
        	opcao = teclado.nextInt();
        	switch (opcao) {

        	case 1:
        		    System.out.println("\n===== PRODUTOS =====");
        		    System.out.println("1 - Cadastrar Produto");
        		    System.out.println("2 - Listar Produtos");
        		    System.out.println("3 - Consultar Produto");
        		    System.out.println("4 - Alterar Produto");
        		    System.out.println("5 - Excluir Produto");
        		    System.out.println("0 - Voltar");
        		    System.out.print("Escolha uma opção: ");
        		    
        		    opcaoProduto = teclado.nextInt();
        		    
        		    switch (opcaoProduto) {
        		    case 1:
        		    	teclado.nextLine();

        		    	System.out.print("Descrição: ");
        		    	String descricao = teclado.nextLine();

        		    	System.out.print("Preço: ");
        		    	double preco = teclado.nextDouble();

        		    	Produto produto = new Produto(descricao, preco);

        		    	dao.salvar(produto);

        		    	System.out.println("Produto cadastrado com sucesso!");
        		        break;

        		    case 2:
        		       List<Produto> produtos = dao.consultar();
        		       
        		       for (Produto p : produtos) {
        		    	   System.out.println("----------------");
        		           System.out.println("ID: " + p.getId());
        		           System.out.println("Descrição: " + p.getDescricao());
        		           System.out.println("Preço: " + p.getPreco());
        		       }
        		        break;

        		    case 3:

        		        System.out.print("Digite o ID do produto: ");
        		        int id = teclado.nextInt();

        		        Produto produtoConsultado = dao.consultar(id);

        		        if (produtoConsultado != null) {

        		            System.out.println("----------------");
        		            System.out.println("ID: " + produtoConsultado.getId());
        		            System.out.println("Descrição: " + produtoConsultado.getDescricao());
        		            System.out.println("Preço: " + produtoConsultado.getPreco());

        		        } else {
        		            System.out.println("Produto não encontrado!");
        		        }
        		        break;

        		    case 4:
        		    	  System.out.print("Digite o ID do produto: ");
        		    	    int idAlterar = teclado.nextInt();

        		    	    Produto produtoAlterar = dao.consultar(idAlterar);

        		    	    if (produtoAlterar != null) {

        		    	        teclado.nextLine();

        		    	        System.out.print("Nova descrição: ");
        		    	        String descricaoNova = teclado.nextLine();

        		    	        System.out.print("Novo preço: ");
        		    	        double precoNovo = teclado.nextDouble();

        		    	        produtoAlterar.setDescricao(descricaoNova);
        		    	        produtoAlterar.setPreco(precoNovo);

        		    	        dao.alterar(produtoAlterar);

        		    	        System.out.println("Produto alterado com sucesso!");

        		    	    } else {
        		    	        System.out.println("Produto não encontrado!");
        		    	    }

        		        break;

        		    case 5:
        		    	 System.out.print("Digite o ID do produto: ");
        		    	    int idExcluir = teclado.nextInt();

        		    	    Produto produtoExcluir = dao.consultar(idExcluir);

        		    	    if (produtoExcluir != null) {

        		    	        dao.deletar(idExcluir);

        		    	        System.out.println("Produto excluído com sucesso!");

        		    	    } else {

        		    	        System.out.println("Produto não encontrado!");

        		    	    }
        		        break;

        		    case 0:
        		        System.out.println("Voltando...");
        		        break;

        		    default:
        		        System.out.println("Opção inválida!");
        		    	
        		    }
        	    break;
        	    

        	case 2:
        	    System.out.println("Menu de Clientes");
        	    break;

        	case 3:
        	    System.out.println("Menu de Pedidos");
        	    break;

        	case 0:
        	    System.out.println("Encerrando o sistema...");
        	    break;

        	default:
        	    System.out.println("Opção inválida!");
        	}
        		
        }while(opcao !=0);
        	
        

    }

}
		
	
		
	




//CÓDIGOS ANTIGOS//

/*dao.deletar(3);
Produto p = dao.consultar(3);
if(p != null) {
	System.out.println(p.getId() + " " + p.getDescricao() + " " + p.getPreco());
}else {
	System.out.println("Produto não encontrado");*/



/*Produto retorno = dao.salvar(p1);
System.out.println(retorno.getId() + " " + retorno.getDescricao());*/
/*List<Produto> lista = dao.consultar();
for (Produto p : lista ) {
	System.out.println(p.getId() + " " + p.getDescricao() + " " + p.getPreco());	
}*/

/*Produto p = dao.consultar(4);
System.out.println(p.getId() + " " + p.getDescricao() + " " + p.getPreco());

p.setDescricao("Alcatra");
p.setPreco(39.99);
dao.alterar(p);

Produto alterado = dao.consultar(4);
System.out.println(alterado.getId() + " " + alterado.getDescricao() + " " + alterado.getPreco());*/