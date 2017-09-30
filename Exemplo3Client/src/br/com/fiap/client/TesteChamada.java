package br.com.fiap.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;

public class TesteChamada {

	public static void main(String[] args) {
		
			
		AlunoWeb port = new AlunoWebService().getAlunoWebPort();
		
		Map<String, Object> req_ctx = ((BindingProvider)port).getRequestContext();
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		
		headers.put("Username", Collections.singletonList("fabio"));
		headers.put("Senha", Collections.singletonList("123"));
		
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS	, headers);
		
		List<Aluno> alunos = new ArrayList<Aluno>();
		try {
			alunos = port.listar();
			
			for(Aluno a : alunos) {
				System.out.println("Nome: " + a.getNome());
			}
			
		} catch (Exception_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}