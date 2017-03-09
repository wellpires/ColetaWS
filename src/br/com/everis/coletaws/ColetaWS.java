package br.com.everis.coletaws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.everis.coletaws.amostrador.model.Amostrador;
import br.com.everis.coletaws.amostrador.services.IAmostradorService;
import br.com.everis.coletaws.amostradoreslojasunidades.service.IAmostradoresLojasUnidadesService;
import br.com.everis.coletaws.atividade.service.IAtividadeService;
import br.com.everis.coletaws.coletaAmostra.service.IColetaAmostraService;
import br.com.everis.coletaws.funcionario.services.IFuncionarioService;
import br.com.everis.coletaws.loja.service.ILojaService;
import br.com.everis.coletaws.lojaprodutoatividade.service.ILojaProdutoAtividadePKService;
import br.com.everis.coletaws.produto.service.IProdutoService;
import br.com.everis.coletaws.unidade.service.IUnidadeService;

/**
 *
 * @author Wellington Gonçalves Pires
 */
@RestController
public class ColetaWS {

	@Autowired
	private IAmostradorService amostradorService = null;

	private ILojaService lojaService = null;
	private IUnidadeService unidadeService = null;
	private IFuncionarioService funcionarioService = null;
	private IProdutoService produtoService = null;
	private IColetaAmostraService coletaAmostraService = null;
	private IAtividadeService atividadeService = null;
	private ILojaProdutoAtividadePKService lojaProdutoAtividadePKService = null;
	private IAmostradoresLojasUnidadesService amostradoresLojasUnidadesService = null;

	@RequestMapping(value = "/buscarAmostradores", produces = { MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.GET)
	public String buscarAmostrador() {
		List<Amostrador> lstAmostradores = null;
		try {
			lstAmostradores = amostradorService.buscarAmostradores();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new Gson().toJson(lstAmostradores);
	}

//	@GET
//	@Path("/buscarLojas")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarLojas() {
//		try {
//			lojaService = new LojaServiceImpl();
//			List<Loja> lstLoja = lojaService.buscarLojas();
//			return Response.ok(new Gson().toJson(lstLoja)).build();
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//	}
//
//	@GET
//	@Path("/buscarUnidades")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarUnidades() {
//		try {
//			unidadeService = new UnidadeServiceImpl();
//			List<Unidade> lstUnidades = unidadeService.buscarUnidades();
//			return Response.ok(new Gson().toJson(lstUnidades)).build();
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//
//	}
//
//	@GET
//	@Path("/buscarFuncionarios")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarFuncionarios() {
//
//		try {
//			funcionarioService = new FuncionarioServiceImpl();
//			List<Funcionario> lstUnidade = funcionarioService.buscarFuncionarios();
//			return Response.ok(new Gson().toJson(lstUnidade)).build();
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//
//	}
//
//	@GET
//	@Path("/buscarProdutos")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarProdutos() {
//		try {
//			produtoService = new ProdutoServiceImpl();
//			List<Produto> lstProdutos = produtoService.buscarProdutos();
//
//			return Response.ok(new Gson().toJson(lstProdutos)).build();
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//	}
//
//	@GET
//	@Path("/buscarAtividades")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarAtividades() {
//		try {
//			atividadeService = new AtividadeServiceImpl();
//			List<Atividade> lstAtividades = atividadeService.buscarAtividades();
//			return Response.ok(new Gson().toJson(lstAtividades)).build();
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//	}
//
//	@GET
//	@Path("/buscarLojasProdutosAtividades")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarLojasProdutosAtividades() {
//		try {
//			lojaProdutoAtividadePKService = new LojaProdutoAtividadePKServiceImpl();
//			List<LojaProdutosAtividade> lstLojaProdutoAtividades = lojaProdutoAtividadePKService
//					.buscarLojaProdutoAtividade();
//
//			String jsonString = new Gson().toJson(lstLojaProdutoAtividades);
//			return Response.ok(jsonString).build();
//		} catch (Exception e) {
//			return Response.status(Response.Status.SERVICE_UNAVAILABLE).entity(e.getMessage())
//					.type(MediaType.TEXT_PLAIN).build();
//		}
//	}
//
//	@GET
//	@Path("/buscarAmostradoresLojasUnidades")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.TEXT_PLAIN)
//	public Response buscarAmostradoresLojasUnidades() {
//		try {
//
//			amostradoresLojasUnidadesService = new AmostradoresLojasUnidadesServiceImpl();
//			List<AmostradoresLojasUnidades> lstAmostradoresLojasUnidades = amostradoresLojasUnidadesService
//					.buscarAmostradoresLojasUnidades();
//			String jsonString = new Gson().toJson(lstAmostradoresLojasUnidades);
//			return Response.ok(jsonString).build();
//
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//	}
//
//	@POST
//	@Path("/gravarColeta")
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes({ MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN })
//	public Response gravarColeta(String coleta) {
//		try {
//			coletaAmostraService = new ColetaAmostraServiceImpl();
//			JSONArray json = (JSONArray) new JSONParser().parse(coleta);
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Locale("pt", "BR"));
//			SimpleDateFormat sdfHora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", new Locale("pt", "BR"));
//
//			for (Object object : json) {
//				ColetaAmostra coletaAmostra = new ColetaAmostra();
//				JSONObject jsonObject = ((JSONObject) object);
//				coletaAmostra.setAmostrador(jsonObject.get("amostrador").toString());
//				coletaAmostra.setLoja(jsonObject.get("loja").toString());
//				coletaAmostra.setUnidade(jsonObject.get("unidade").toString());
//				coletaAmostra.setDataColeta(sdf.parse(jsonObject.get("dataColeta").toString()));
//				coletaAmostra.setHoraColeta(sdfHora.parse(jsonObject.get("horaColeta").toString()));
//				coletaAmostra.setHoraReal(sdfHora.parse(jsonObject.get("horaReal").toString()));
//				coletaAmostra.setProduto(jsonObject.get("produto").toString());
//				coletaAmostra.setAtividade(jsonObject.get("atividade").toString());
//				coletaAmostra.setStatusAmostra("OK");
//				if (jsonObject.get("funcionario") != null) {
//					coletaAmostra.setFuncionario(jsonObject.get("funcionario").toString());
//				}
//				coletaAmostraService.gravarColeta(coletaAmostra);
//			}
//
//			return Response.ok().build();
//		} catch (JsonSyntaxException e) {
//			return Response.serverError().build();
//		} catch (Exception e) {
//			return Response.serverError().build();
//		}
//	}

}
