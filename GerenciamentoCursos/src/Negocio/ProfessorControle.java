package Negocio;

import javax.swing.JOptionPane;

import Dados.ProfessorRepositorio;
import Dados.UsuarioRepositorio;

public class ProfessorControle {
	private ProfessorRepositorio pr;
    
    public ProfessorControle() {
        pr = new ProfessorRepositorio();
    }

    public ProfessorRepositorio getProfessorRepositorio() {
        if (this.pr != null) {
            return this.pr;             
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum dado encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
		return null;
    }
    
    public void setProfessorRepositorio(ProfessorRepositorio pr) {
    	if (pr != null) {
    		this.pr = pr;
    	} else {
    		JOptionPane.showMessageDialog(null, "Parametros invalidos!", "Erro", JOptionPane.ERROR_MESSAGE);
    	}
    }
    
    public void inserirProfessor(String cpf) {
    	try {
    		if (cpf != null && cpf != "") {
    			String sql = "INSERT INTO professor (cpf) VALUES ('" + cpf + "')";
    			pr.inserirProfessor(sql);
    		} else {
    			JOptionPane.showMessageDialog(null, "Parametros invalidos!", "Erro", JOptionPane.ERROR_MESSAGE);
    		}
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }
}
