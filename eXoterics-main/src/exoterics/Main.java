/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exoterics;

/**
 *
 * @author vdpom
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void menu() {
        System.out.println("\n");
        System.out.println("1 - Listar Usuarios");
        System.out.println("2 - Listar Especialistas");
        System.out.println("3 - Listar Produtos");
        System.out.println("4 - Cadastrar Usuario");
        System.out.println("5 - Cadastrar Especialista");
        System.out.println("6 - Cadastrar Produto");
        System.out.println("7 - Alterar Usuario");
        System.out.println("8 - Alterar Especialista");
        System.out.println("9 - Alterar Produto");
        System.out.println("10 - Excluir Usuario");
        System.out.println("11 - Excluir Especialista");
        System.out.println("12 - Excluir Produto");
        System.out.println("13 - Buscar Usuario");
        System.out.println("14 - Buscar Especialista");
        System.out.println("15 - Buscar Produto");
        System.out.println("16 - Agregar produto ao Especialista");
        System.out.println("17 - Agregar compra ao Usuario");
        System.out.println("18 - Mostrar compras");
        System.out.println("19 - Comprar produto");
        System.out.println("20 - Devolver produto");
        System.out.println("0 - Sair");
        System.out.println("\n");
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        String nome;
        String sobrenome;
        int id, idade;
        String signo;
        String especialidade;
        String temp;
        int opcao;
        double valor;

        UsuariosDAO usDao = new UsuariosDAO();
        EspecialistaDAO esDao = new EspecialistaDAO();
        ProdutoDAO prDao = new ProdutoDAO();
        CompraDAO cpDao = new CompraDAO();

        do {
            menu();
            temp = teclado.nextLine();
            opcao = Integer.parseInt(temp);
            switch (opcao){
                case 0 -> {
                    System.out.println("Obrigado por utilizar nosso sistema!");
                    break;
                }
                case 1 ->{
                    System.out.println("\n ------> MOSTRAR USUARIOS <------");
                    ArrayList<Usuarios> listaUsuarios = usDao.list();
                    for(int i = 0; i < listaUsuarios.size(); i++){

                        Usuarios u = listaUsuarios.get(i);

                        System.out.println("Codigo do usuario: " + u.getId());
                        System.out.println("Nome do usuario: " + u.getNome());
                        System.out.println("Sobrenome do usuario: " + u.getSobrenome());
                        System.out.println("Idade do usuario: " + u.getIdade());
                        System.out.println("Signo do usuario: " + u.getSigno());
                        System.out.println("Codigo do Produto comprado: " + u.getAtCompra());
                        System.out.println("---------------------------------------");
                    }
                    break;
                }
                case 2 ->{
                    System.out.println("\n ------> MOSTRAR ESPECIALISTAS <------");
                    ArrayList<Especialista> listaEspecialista = esDao.listEspecialista();
                    for(int i = 0; i < listaEspecialista.size(); i++){

                        Especialista e = listaEspecialista.get(i);

                        System.out.println("Codigo do especialista: " + e.getId());
                        System.out.println("Nome do especialista: " + e.getNome());
                        System.out.println("Sobrenome do especialista: " + e.getSobrenome());
                        System.out.println("Idade do especialista: " + e.getIdade());
                        System.out.println("Especialidade do especialista: " + e.getEspecialidade());
                        System.out.println("---------------------------------------");
                    }
                    break;
                }
                case 3 ->{
                    System.out.println("\n ------> MOSTRAR PRODUTO <------");
                    ArrayList<Produto> listaProduto = prDao.listProduto();
                    for(int i = 0; i < listaProduto.size(); i++){
                        Produto p = listaProduto.get(i);
                        
                        System.out.println("Codigo do produto: " + p.getId());
                        System.out.println("Nome do produto: " + p.getNome());
                        System.out.println("Valor do produto: R$" + p.getValor());  
                        System.out.println("Codigo do especialista que atende o produto: " + p.getAtEspecialista());
                        System.out.println("----------------------------------------");
                    }
                    break;
                }
                case 4 ->{
                    System.out.println("\n ------> CADASTRAR USUARIOS <------");
                    System.out.println("Digite o nome do usuario: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome do usuario: ");
                    sobrenome = teclado.nextLine();
                    System.out.println("Digite o signo do usuario: ");
                    signo = teclado.nextLine();
                    System.out.println("Digite a idade do usuario: ");
                    temp = teclado.nextLine();
                    idade = Integer.parseInt(temp);
                    


                    Usuarios novo = new Usuarios(nome, sobrenome, signo, idade);

                    if (usDao.insert(novo) > 0) {
                        System.out.println("\n Novo usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("\n Não foi possível cadastrar o usuário!");
                    }
                    break;
                }
                case 5 ->{
                    System.out.println("\n ------> CADASTRAR ESPECIALISTAS <------");
                    System.out.println("Digite o nome do especialista: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite o sobrenome do especialista: ");
                    sobrenome = teclado.nextLine();
                    System.out.println("Digite a idade do especialista: ");
                    temp = teclado.nextLine();
                    idade = Integer.parseInt(temp);
                    System.out.println("Digite a especialidade do especialista: ");
                    especialidade = teclado.nextLine();

                    Especialista novo = new Especialista(nome, sobrenome, especialidade, idade);

                    if (esDao.insertEspecialista(novo) > 0) {
                        System.out.println("\n Novo especialista com sucesso!");
                    } else {
                        System.out.println("\n Não foi possível cadastrar um novo especialista!");
                    }
                    break;
                }
                case 6 ->{
                    System.out.println("\n ------> CADASTRAR PRODUTO <------");
                    System.out.println("Digite o nome do produto: ");
                    nome = teclado.nextLine();
                    System.out.println("Digite o valor do produto: ");
                    temp = teclado.nextLine();
                    valor = Double.parseDouble(temp);
                    
                    Produto novo = new Produto(nome, valor);
                    
                    if(prDao.insertProduto(novo) > 0){
                        System.out.println("\n Novo produto cadastrado com sucesso!");
                    } else {
                        System.out.println("\n Não foi possível cadastrar um novo produto!");
                    }
                    break;   
                }
                case 7 ->{
                    System.out.println("\n ------> ALTERAR USUARIOS <------");
                    System.out.println("Digite o código do usuário que deseja alterar: ");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);
                    Usuarios u2 = usDao.read(cod);

                    if(u2 == null){
                        System.out.println("\n Usu2ário não localizado!");
                    } else {
                        System.out.println("\n Você deseja alterar os dados do usuário? 1-Sim 2-Não");
                        temp = teclado.nextLine();
                        int resp = Integer.parseInt(temp);

                        if (resp == 1){
                            System.out.println("Digite o novo nome do usuario: ");
                            nome = teclado.nextLine();
                            u2.setNome(nome);
                            System.out.println("Digite o novo sobrenome do usuario: ");
                            sobrenome = teclado.nextLine();
                            u2.setSobrenome(sobrenome);
                            System.out.println("Digite a nova idade do usuario: ");
                            temp = teclado.nextLine();
                            idade = Integer.parseInt(temp);
                            u2.setIdade(idade);
                            System.out.println("Digite o novo signo do usuario: ");
                            signo = teclado.nextLine();
                            u2.setSigno(signo);
                        }
                        if (usDao.update(u2) > 0){
                            System.out.println("\n Os dados do usuário foram alterados com sucesso!");
                        } else {
                            System.out.println("\n Usuário não alterado.");
                        }
                    }
                    break;
                }
                case 8 ->{
                    System.out.println("\n ------> ALTERAR ESPECIALISTAS <------");
                    System.out.println("Digite o código do especialista que deseja alterar: ");
                    temp = teclado.nextLine();
                    id = Integer.parseInt(temp);
                    Especialista e2 = esDao.readEspecialista(id);

                    if(e2 == null){
                        System.out.println("\n Especialista não localizado!");
                    } else {
                        System.out.println("\n Você deseja alterar os dados do especialista? 1-Sim 2-Não");
                        temp = teclado.nextLine();
                        int resp = Integer.parseInt(temp);

                        if (resp == 1){
                            System.out.println("Digite o novo nome do especialista: ");
                            nome = teclado.nextLine();
                            e2.setNome(nome);
                            System.out.println("Digite o novo sobrenome do especialista: ");
                            sobrenome = teclado.nextLine();
                            e2.setSobrenome(sobrenome);
                            System.out.println("Digite a nova idade do especialista: ");
                            temp = teclado.nextLine();
                            idade = Integer.parseInt(temp);
                            e2.setIdade(idade);
                            System.out.println("Digite a nova especialidade do especialista: ");
                            especialidade = teclado.nextLine();
                            e2.setEspecialidade(especialidade);
                        }
                        if (esDao.updateEspecialista(e2) > 0){
                            System.out.println("\n Os dados do especialista foram alterados com sucesso!");
                        } else {
                            System.out.println("\n Especialista não alterado.");
                        }
                    }
                    break;
                }
                case 9 ->{
                    System.out.println("\n ------> ALTERAR PRODUTO <------");
                    System.out.println("Digite o código do produto que deseja alterar: ");
                    temp = teclado.nextLine();
                    id = Integer.parseInt(temp);
                    Produto p2 = prDao.readProduto(id);

                    if(p2 == null){
                        System.out.println("\n Produto não localizado!");
                    } else {
                        System.out.println("\n Você deseja alterar os dados do produto? 1-Sim 2-Não");
                        temp = teclado.nextLine();
                        int resp = Integer.parseInt(temp);

                        if (resp == 1){
                            System.out.println("Digite o novo nome do produto: ");
                            nome = teclado.nextLine();
                            p2.setNome(nome);
                            System.out.println("Digite o novo valor do produto: ");
                            temp = teclado.nextLine();
                            valor = Double.parseDouble(temp);
                            p2.setValor(valor);
                        }
                        if (prDao.updateProduto(p2) > 0){
                            System.out.println("\n Os dados do produto foram alterados com sucesso!");
                        } else {
                            System.out.println("\n Produto não alterado.");
                        }
                    }
                    break;
                }
                case 10 ->{
                    System.out.println("\n ------> EXCLUIR USUARIOS <------");
                    System.out.println("Digite o código do usuario que desejas excluir");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);

                    if(usDao.delete(cod) > 0){
                        System.out.println("\n Usuário excluído com sucesso!");
                    }else{
                        System.out.println("\n Não foi possível excluir o usuário.");
                    }
                    break;
                }
                case 11 ->{
                    System.out.println("\n ------> EXCLUIR ESPECIALISTAS <------");
                    System.out.println("Digite o código do especialista que desejas excluir");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);

                    if(esDao.deleteEspecialista(cod) > 0){
                        System.out.println("\n Especialista excluido com sucesso!");
                    }else{
                        System.out.println("\n Não foi possível excluir o especialista.");
                    }
                    break;
                }
                case 12 ->{
                    System.out.println("\n ------> EXCLUIR PRODUTO <------");
                    System.out.println("Digite o código do produto que desejas excluir");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);

                    if(prDao.deleteProduto(cod) > 0){
                        System.out.println("\n Produto excluido com sucesso!");
                    }else{
                        System.out.println("\n Não foi possível excluir o produto.");
                    }
                    break;
                }
                case 13 ->{
                    System.out.println("\n ------> BUSCAR USUARIO <------");
                    System.out.println("Digite o código do usuario que deseja buscar: ");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);
                    Usuarios u = usDao.read(cod);

                    if (u != null){
                        System.out.println("\n ------> USUARIO ENCONTRADO <------");
                        System.out.println("Codigo do usuario: " + u.getId());
                        System.out.println("Nome do usuario: " + u.getNome());
                        System.out.println("Sobrenome do usuario: " + u.getSobrenome());
                        System.out.println("Idade do usuario: " + u.getIdade());
                        System.out.println("Signo do usuario: " + u.getSigno());
                        System.out.println("------------------------------------------");
                    } else{
                        System.out.println("\n ------> USUARIO NÃO ENCONTRADO <------");
                    }
                    break;
                }
                case 14 ->{
                    System.out.println("\n ------> BUSCAR ESPECIALISTA <------");
                    System.out.println("Digite o codigo do especialista que deseja buscar: ");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);
                    Especialista e = esDao.readEspecialista(cod);

                    if (e != null){
                        System.out.println("\n ------> ESPECIALISTA ENCONTRADO <------");
                        System.out.println("Codigo do especialista: " + e.getId());
                        System.out.println("Nome do especialista: " + e.getNome());
                        System.out.println("Sobrenome do especialista: " + e.getSobrenome());
                        System.out.println("Idade do especialista: " + e.getIdade());
                        System.out.println("Especialidade do especialista: " + e.getEspecialidade());
                        System.out.println("------------------------------------------");
                    } else{
                        System.out.println("\n ------> ESPECIALISTA NAO ENCONTRADO <------");
                    }
                    break;
                }
                case 15 ->{
                    System.out.println("\n ------> BUSCAR PRODUTO <------");
                    System.out.println("Digite o codigo do produto que deseja buscar: ");
                    temp = teclado.nextLine();
                    int cod = Integer.parseInt(temp);
                    Produto p = prDao.readProduto(cod);

                    if (p != null){
                        System.out.println("\n ------> ESPECIALISTA ENCONTRADO <------");
                        System.out.println("Codigo do produto: " + p.getId());
                        System.out.println("Nome do produto: " + p.getNome());
                        System.out.println("Valor do produto: R$" + p.getValor());
                        System.out.println("------------------------------------------");
                    } else{
                        System.out.println("\n ------> PRODUTO NAO ENCONTRADO <------");
                    }
                    break;
                    
                }
                case 16 ->{
                    System.out.println("\n ------> AGREGAR PRODUTO AO ESPECIALISTA <------");
                    System.out.println("Ola, seja bem vindo. Gostaria de vincular um produto a um especialista? 1-Sim 2-Nao");
                    temp = teclado.nextLine();
                    int opt = Integer.parseInt(temp);
                    
                    if(opt == 1){
                        System.out.println("Estes sao nossos especialistas disponiveis: ");
                        ArrayList<Especialista> listaEspecialista = esDao.listEspecialista();
                        for(int i = 0; i < listaEspecialista.size(); i++){

                            Especialista e = listaEspecialista.get(i);

                            System.out.println("Codigo do especialista: " + e.getId());
                            System.out.println("Nome do especialista: " + e.getNome());
                            System.out.println("Sobrenome do especialista: " + e.getSobrenome());
                            System.out.println("Idade do especialista: " + e.getIdade());
                            System.out.println("Especialidade do especialista: " + e.getEspecialidade());
                            System.out.println("---------------------------------------");
                        }
                        System.out.println("Estes sao nossos produtos disponiveis: ");
                        ArrayList<Produto> listaProduto = prDao.listProduto();
                        for(int i = 0; i < listaProduto.size(); i++){
                            Produto p = listaProduto.get(i);
                        
                            System.out.println("Codigo do produto: " + p.getId());
                            System.out.println("Nome do produto: " + p.getNome());
                            System.out.println("Valor do produto: R$" + p.getValor());
                            System.out.println("----------------------------------------");
                        }
                        
                        System.out.println("Voce deseja vincular um produto a um especialista? 1-Sim 2-Nao");
                        temp = teclado.nextLine();
                        int opt2 = Integer.parseInt(temp);
                        
                        if(opt2 == 1){
                            System.out.println("Digite o codigo do produto: ");
                            temp = teclado.nextLine();
                            id = Integer.parseInt(temp);
                            Produto p2 = prDao.readProduto(id);
                            System.out.println("Digite o codigo do especialista: ");
                            temp = teclado.nextLine();
                            int codE = Integer.parseInt(temp);
                            p2.setAtEspecialista(codE);

                            if (prDao.associarProdutoComEspecialista(p2) > 0){
                                System.out.println("\n Associacao concluida!");
                            } else {
                                System.out.println("\n Produto nao associado.");
                            }
                        }
                    } else{
                        System.out.println("Ok, ate a proxima!");
                    }
                    break;
                }
                case 17 ->{
                    System.out.println("\n ------> AGREGAR COMPRA AO USUARIO <------");
                    System.out.println("Ola, seja bem vindo. Gostaria de vincular uma compra a um usuario? 1-Sim 2-Nao");
                    temp = teclado.nextLine();
                    int opt = Integer.parseInt(temp);
                    
                    if(opt == 1){
                        System.out.println("Estes sao nossos usuarios disponiveis: ");
                        ArrayList<Usuarios> listaUsuarios = usDao.list();
                        for(int i = 0; i < listaUsuarios.size(); i++){

                            Usuarios u = listaUsuarios.get(i);

                            System.out.println("Codigo do usuario: " + u.getId());
                            System.out.println("Nome do usuario: " + u.getNome());
                            System.out.println("Sobrenome do usuario: " + u.getSobrenome());
                            System.out.println("Idade do usuario: " + u.getIdade());
                            System.out.println("Signo do usuario: " + u.getSigno());
                            System.out.println("---------------------------------------");
                        }
                        System.out.println("Estes sao nossos produtos disponiveis: ");
                        ArrayList<Compra> listaCompra = cpDao.listCompra();
                        for(int i = 0; i < listaCompra.size(); i++){
                            Compra c = listaCompra.get(i);
                        
                            System.out.println("Codigo da compra: " + c.getId());
                            System.out.println("Codigo do produto: " + c.getAtProduto());
                            System.out.println("----------------------------------------");
                        }
                        
                        System.out.println("Voce deseja vincular uma compra a um usuario? 1-Sim 2-Nao");
                        temp = teclado.nextLine();
                        int opt2 = Integer.parseInt(temp);
                        
                        if(opt2 == 1){
                            System.out.println("Digite o codigo da compra: ");
                            temp = teclado.nextLine();
                            id = Integer.parseInt(temp);
                            Usuarios u2 = usDao.read(id);
                            System.out.println("Digite o codigo do usuario: ");
                            temp = teclado.nextLine();
                            int codC = Integer.parseInt(temp);
                            u2.setAtCompra(codC);

                            if (usDao.associarCompraComUsuario(u2) > 0){
                                System.out.println("\n Associacao concluida!");
                            } else {
                                System.out.println("\n Compra nao associado.");
                            }
                        }
                    } else{
                        System.out.println("Ok, ate a proxima!");
                    }
                    break;
                }
                case 18 ->{
                    System.out.println("\n ------> MOSTRAR COMPRAS <------");
                    ArrayList<Compra> listaCompra = cpDao.listCompra();
                        for(int i = 0; i < listaCompra.size(); i++){
                            Compra c = listaCompra.get(i);
                        
                            System.out.println("Codigo da compra: " + c.getId());
                            System.out.println("Codigo do comprador: " + c.getAtUsuario());
                            System.out.println("Codigo do produto: " + c.getAtProduto());
                            System.out.println("----------------------------------------");
                        }
                break;
            }
                case 19 ->{
                    System.out.println("\n ------> COMPRAR PRODUTO <------");
                    System.out.println("Ola, seja bem vindo. Gostaria de olhar nosso catalogo de produtos? 1-Sim 2-Nao");
                    temp = teclado.nextLine();
                    int opt = Integer.parseInt(temp);
                    
                    if(opt == 1){
                        ArrayList<Produto> listaProduto = prDao.listProduto();
                        ArrayList<Especialista> listaEspecialista = esDao.listEspecialista();
                        for(int i = 0; i < listaProduto.size(); i++){
                            Produto p = listaProduto.get(i);
                            Especialista e = listaEspecialista.get(i);
                        
                            System.out.println("Codigo do produto: " + p.getId());
                            System.out.println("Nome do produto: " + p.getNome());
                            System.out.println("Valor do produto: R$" + p.getValor());
                            //System.out.println("Especialista que trabalha com este produto: " + e.getNome());
                            System.out.println("----------------------------------------");
                            }
                            System.out.println("Agora que voce viu nossos produtos, gostaria de comprar algum? 1-Sim 2-Nao");
                            temp = teclado.nextLine();
                            int opt2 = Integer.parseInt(temp);
                            
                            if(opt2 == 1){
                                System.out.println("Digite seu codigo de usuario: ");
                                temp = teclado.nextLine();
                                int cod = Integer.parseInt(temp);
                                System.out.println("Digite o codigo do produto que deseja comprar: ");
                                temp = teclado.nextLine();
                                int codP = Integer.parseInt(temp);
                                cpDao.associarUsuarioProduto(cod, codP);
                            } else if(opt2 == 2){
                                System.out.println("Ok, ate a proxima");
                            }
                        
                    } else if(opt == 2){
                        System.out.println("Ok, ate a proxima!");
                    }
                    break;
                }
                case 20 ->{
                    System.out.println("\n ------> DEVOLVER PRODUTO <------");
                    System.out.println("Ola, seja bem vindo. Voce gostaria de devolver algum produto? 1-Sim 2-Nao");
                    temp = teclado.nextLine();
                    int opt = Integer.parseInt(temp);
                    
                    if(opt == 1){
                        System.out.println("Digite seu codigo de usuario: ");
                        temp = teclado.nextLine();
                        int cod = Integer.parseInt(temp);
                        System.out.println("Digite o codigo do produto que deseja devolver: ");
                        temp = teclado.nextLine();
                        int codP = Integer.parseInt(temp);
                        cpDao.desassociarUsuarioProduto(cod, codP);
                        
                        System.out.println("Produto devolvido com sucesso!");
                    } else{
                        System.out.println("Ok, ate a proxima");
                    }
                    break;
                }
            }
        }while (opcao != 0);
    }
}
