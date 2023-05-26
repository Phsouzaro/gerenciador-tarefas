package br.com.tarefa.rest.controller;

import br.com.tarefa.api.TarefaApi;
import br.com.tarefa.representation.TarefaRequest;
import br.com.tarefa.representation.TarefaResponse;
import br.com.tarefa.service.TarefaService;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TarefaController implements TarefaApi {

    private final TarefaService service;

    @Override
    public ResponseEntity<Void> criarTarefa(TarefaRequest body) {
        log.info("Request que chegou no controller:  {{}}", new Gson().toJson(body));
        try {
            service.criarTarefa(body);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro Sistêmico", e);
        }
    }

    @Override
    public ResponseEntity<List<TarefaResponse>> listarTarefas() {
        try {
            return ResponseEntity.ok(service.listarTarefas());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro Sistêmico", e);
        }
    }
}
