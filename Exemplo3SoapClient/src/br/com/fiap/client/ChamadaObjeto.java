package br.com.fiap.client;

import java.util.List;

public class ChamadaObjeto {

	public static void main(String[] args) {
		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
		List<Aluno> alunos;
		
		try {
			ListarResponse  resposta = port.listar(new Listar(), "fabio", "123");
			alunos = resposta.getReturn();
			
			for(Aluno a : alunos) {
				System.out.println(a.getNome());
			}
			
		} catch (Exception_Exception e) {
			// TODO: handle exception
		}
	}

}
