package br.com.fiap.dao;
 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
 
import javax.swing.JOptionPane;
import br.com.fiap.beans.Advogado;
 
public class AdvogadoDAO extends PessoaDAO {
 
    private List<Advogado> lstAdvogados = new ArrayList<>();
 
    private Connection con;
    private Statement comando;
 
 
 
    public void gravar (Advogado a, Connection conexao ) throws Exception{
 
    	PreparedStatement strt = conexao.prepareStatement("insert into T_AAD_PESSOA "
				+ "(CD_PESSOA, NM_NOME) "
				+ "values (SQ_AM_PESSOA.nextval,?)");
    	
    	strt.setString(1, a.getNome());
    	
    	strt.execute();
    	
        PreparedStatement estrutura = conexao.prepareStatement("insert into T_AAD_ADVOGADO "
        		+ "(NR_OAB, NR_CPF, NR_RG, DS_EMAIL, DS_SENHA,CD_ADVOGADO) "
        		+ "values (?,?,?,?,?,SQ_AM_PESSOA.currval)");
 
        
        	
            estrutura.setString(1, a.getNumeroOAB());
            estrutura.setString(2, a.getCpf());
            estrutura.setString(3, a.getRg());
            estrutura.setString(4, a.getEmail());
            estrutura.setString(5, a.getSenha());
            estrutura.execute();
            estrutura.close();
 
       
 
    }
 
    public void atualizar(Advogado advogado) {    
        String com = "UPDATE advogado SET cpf = '" + advogado.getCpf()  
        + "', rg =" + advogado.getRg() + ", email = '" 
        + advogado.getEmail() + "', senha ='" + advogado.getSenha()  
        + "' WHERE  numeroOAB = '" + advogado.getNumeroOAB() + "';";  
        System.out.println("Atualizada!");  
        try {  
            comando.executeUpdate(com);  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } finally {  
            fechar();  
        }  
    }
 
    public List<Advogado> getLista(Connection conexao) throws Exception{
        List<Advogado> lstAdvogados = new ArrayList<Advogado>();
        PreparedStatement estrutura = conexao.prepareStatement("select * from T_AAD_ADVOGADO");
        java.sql.ResultSet resultadoDados = estrutura.executeQuery();
        while (resultadoDados.next()){
            Advogado advogado = new Advogado();
 
            advogado.setNumeroOAB(resultadoDados.getString("NR_OAB"));
            advogado.setCpf(resultadoDados.getString("NR_CPF"));
            advogado.setRg(resultadoDados.getString("NR_RG"));
            advogado.setEmail(resultadoDados.getString("DS_EMAIL"));
            advogado.setSenha(resultadoDados.getString("DS_SENHA"));
 
            lstAdvogados.add(advogado);
 
        }
 
        resultadoDados.close();
        estrutura.close();
        return lstAdvogados;
 
 
    }
 
    private void fechar() {  
        try {  
            comando.close();  
            con.close();  
            System.out.println("Conexão Fechada");  
        } catch (SQLException e) {  
            imprimeErro("Erro ao fechar conexão", e.getMessage());  
        }  
    }  
 
 
    private void imprimeErro(String msg, String msgErro) {  
        JOptionPane.showMessageDialog(null, msg, "Erro crítico", 0);  
        System.err.println(msg);  
        System.out.println(msgErro);  
        System.exit(0);  
    }  
 
    public String deletar (String advogado){
        for(Advogado a : lstAdvogados){
            if(a.getNome().equals(advogado)){
                lstAdvogados.remove(a);
                System.out.println("Lista atualizada!");
                System.out.println();
                return "Apagado com sucesso";
            }
        }
        return "Cargo não Encontrado";
    }
 
    public void exibir(String advogado){
        for(Advogado a : lstAdvogados){
            if(a.getNome().equals(advogado)){
                System.out.println("\n"+a.getNumeroOAB()+
                        "\n"+ a.getCpf() +
                        "\n" + a.getRg() +
                        "\n" + a.getEmail() +
                        "\n" +a.getSenha());
            }
        }
    }
 
 
}
