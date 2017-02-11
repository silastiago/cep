package servico;

import java.io.Serializable;

import com.google.gson.Gson;

import model.Endereco;

public class ServicoEndereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171188508122915069L;
	
	public Endereco buscarEnderecoPor(String urlJson) {
		Gson gson = new Gson();		
		Endereco retornoEndereco = gson.fromJson(urlJson, Endereco.class);		
		return retornoEndereco;
	}

}
