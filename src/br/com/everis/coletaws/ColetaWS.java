package br.com.everis.coletaws;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.amostrador.services.IAmostradorService;
import br.com.everis.coletaws.amostradoreslojasunidades.model.AmostradoresLojasUnidades;
import br.com.everis.coletaws.amostradoreslojasunidades.service.IAmostradoresLojasUnidadesService;
import br.com.everis.coletaws.atividade.model.Atividade;
import br.com.everis.coletaws.atividade.service.IAtividadeService;
import br.com.everis.coletaws.coletaAmostra.model.ColetaAmostra;
import br.com.everis.coletaws.coletaAmostra.service.IColetaAmostraService;
import br.com.everis.coletaws.exceptions.ErrorResponse;
import br.com.everis.coletaws.exceptions.ResponseException;
import br.com.everis.coletaws.funcionario.model.Funcionario;
import br.com.everis.coletaws.funcionario.services.IFuncionarioService;
import br.com.everis.coletaws.loja.model.Loja;
import br.com.everis.coletaws.loja.service.ILojaService;
import br.com.everis.coletaws.lojaprodutoatividade.model.LojaProdutosAtividade;
import br.com.everis.coletaws.lojaprodutoatividade.service.ILojaProdutoAtividadePKService;
import br.com.everis.coletaws.produto.model.Produto;
import br.com.everis.coletaws.produto.service.IProdutoService;
import br.com.everis.coletaws.unidade.model.Unidade;
import br.com.everis.coletaws.unidade.service.IUnidadeService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@RestController
public class ColetaWS {

	@Autowired
	private IAmostradorService amostradorService = null;

	@Autowired
	private ILojaService lojaService = null;

	@Autowired
	private IUnidadeService unidadeService = null;

	@Autowired
	private IFuncionarioService funcionarioService = null;

	@Autowired
	private IProdutoService produtoService = null;

	@Autowired
	private IColetaAmostraService coletaAmostraService = null;

	@Autowired
	private IAtividadeService atividadeService = null;

	@Autowired
	private ILojaProdutoAtividadePKService lojaProdutoAtividadePKService = null;

	@Autowired
	private IAmostradoresLojasUnidadesService amostradoresLojasUnidadesService = null;

	@RequestMapping(value = "/buscarAmostradores", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarAmostrador() throws ResponseException {
		try {
			List<Amostrador> lstAmostradores = amostradorService.buscarAmostradores();
			return ResponseEntity.ok().body(new Gson().toJson(lstAmostradores));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	@RequestMapping(value = "/buscarLojas", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarLojas() throws ResponseException {
		try {
			List<Loja> lstLoja = lojaService.buscarLojas();
			return ResponseEntity.ok().body(new Gson().toJson(lstLoja));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	@RequestMapping(value = "/buscarUnidades", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarUnidades() throws ResponseException {
		try {
			List<Unidade> lstUnidades = unidadeService.buscarUnidades();
			return ResponseEntity.ok().body(new Gson().toJson(lstUnidades));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}

	}

	@RequestMapping(value = "/buscarFuncionarios", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarFuncionarios() throws ResponseException {
		try {
			List<Funcionario> lstFuncionarios = funcionarioService.buscarFuncionarios();
			return ResponseEntity.ok().body(new Gson().toJson(lstFuncionarios));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}

	}

	@RequestMapping(value = "/buscarProdutos", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarProdutos() throws ResponseException {
		try {
			List<Produto> lstProdutos = produtoService.buscarProdutos();
			return ResponseEntity.ok().body(new Gson().toJson(lstProdutos));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	@RequestMapping(value = "/buscarAtividades", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarAtividades() throws ResponseException {
		try {
			List<Atividade> lstAtividades = atividadeService.buscarAtividades();
			return ResponseEntity.ok().body(new Gson().toJson(lstAtividades));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	@RequestMapping(value = "/buscarLojasProdutosAtividades", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarLojasProdutosAtividades() throws ResponseException {
		try {
			List<LojaProdutosAtividade> lstLojaProdutoAtividades = lojaProdutoAtividadePKService
					.buscarLojaProdutoAtividade();
			return ResponseEntity.ok().body(new Gson().toJson(lstLojaProdutoAtividades));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	@RequestMapping(value = "/buscarAmostradoresLojasUnidades", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.GET)
	public ResponseEntity<String> buscarAmostradoresLojasUnidades() throws ResponseException {
		try {
			List<AmostradoresLojasUnidades> lstAmostradoresLojasUnidades = amostradoresLojasUnidadesService
					.buscarAmostradoresLojasUnidades();
			return ResponseEntity.ok().body(new Gson().toJson(lstAmostradoresLojasUnidades));
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			throw new ResponseException(e.getMessage());
		}
	}

	@RequestMapping(value = "/gravarColeta", produces = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, consumes = { MediaType.APPLICATION_JSON_VALUE + "; charset=utf-8" }, method = RequestMethod.POST)
	public ResponseEntity<?> gravarColeta(@RequestBody String coleta) throws ResponseException {
		try {
			JSONArray json = (JSONArray) new JSONParser().parse(coleta);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Locale("pt", "BR"));

			for (Object object : json) {
				ColetaAmostra coletaAmostra = new ColetaAmostra();
				JSONObject jsonObject = ((JSONObject) object);
				coletaAmostra.setAmostrador(jsonObject.get("amostrador").toString());
				coletaAmostra.setLoja(jsonObject.get("loja").toString());
				coletaAmostra.setUnidade(jsonObject.get("unidade").toString());
				coletaAmostra.setDataColeta(sdf.parse(jsonObject.get("dataColeta").toString()));
				coletaAmostra.setHoraColeta(sdf.parse(jsonObject.get("horaColeta").toString()));
				coletaAmostra.setHoraReal(sdf.parse(jsonObject.get("horaReal").toString()));
				coletaAmostra.setProduto(jsonObject.get("produto").toString());
				coletaAmostra.setAtividade(jsonObject.get("atividade").toString());
				coletaAmostra.setStatusAmostra("OK");
				coletaAmostra.setFuncionario(jsonObject.get("funcionario").toString());
				coletaAmostraService.gravarColeta(coletaAmostra);
			}

			return ResponseEntity.ok().build();
		} catch (JsonSyntaxException e) {
			throw new ResponseException(e.getMessage());
		} catch (NullPointerException npe) {
			throw new NullPointerException(npe.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseException(e.getMessage());
		}
	}

	@ExceptionHandler(ResponseException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(ex.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}

	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> nullPointerException(NullPointerException npe) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessage(npe.getMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.OK);
	}
	
}
