package br.com.tarefa.service;

import br.com.tarefa.domain.Tarefa;
import br.com.tarefa.mapper.TarefaMapper;
import br.com.tarefa.repository.TarefaRepository;
import br.com.tarefa.representation.TarefaRequest;
import br.com.tarefa.representation.TarefaResponse;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class TarefaService {

    private final TarefaRepository repository;

    @Transactional
    public void criarTarefa(TarefaRequest request){
        log.info("Cadastrando nova tarefa com o request:  {}",
                new Gson().toJson(request));

        Tarefa tarefaDomain = TarefaMapper.getTarefaDomainFromTarefaRequest(request);
        tarefaDomain.setAtivo(true);
        repository.save(tarefaDomain);

        log.info("Tarefa cadastrada com o Id: {{}}", tarefaDomain.getId());
    }

    public List<TarefaResponse> listarTarefas(){
        log.info("Listando tarefas");

        List<Tarefa> tarefas = repository.findAllByAtivoTrue();

        return tarefas.stream().map(TarefaMapper::getTarefaResponseFromTarefaDomain).collect(Collectors.toList());
    }

    
}
