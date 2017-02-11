package controlador;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

import model.Endereco;
import servico.ServicoEndereco;

@ManagedBean(name ="CEPBean")
@ViewScoped
public class ControladorCEPBean implements Serializable {


	private static final long serialVersionUID = -4818919924660193639L;
	
	private Endereco endereco;
	
	private String cep;

	private ServicoEndereco servico = new ServicoEndereco();

	public Endereco carregarEndereco() {
		endereco = new Endereco();
		Client c = Client.create();
		WebResource wr = c.resource("http://viacep.com.br/ws/" + this.getCep() + "/json/");
		this.endereco = servico.buscarEnderecoPor(wr.get(String.class));
		return endereco;

	}

	public void limpar() {
		endereco = new Endereco();
	}
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
