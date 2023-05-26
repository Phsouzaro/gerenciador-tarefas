package br.com.tarefa.mapper;

import br.com.tarefa.domain.Tarefa;
import br.com.tarefa.domain.enums.StatusEnum;
import br.com.tarefa.representation.TarefaRequest;
import br.com.tarefa.representation.TarefaResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TarefaMapper {

    public static Tarefa getTarefaDomainFromTarefaRequest(TarefaRequest request) {
        var domain = new ObjectMapper().convertValue(request, Tarefa.class);
        domain.setStatus(StatusEnum.fromValue(request.getStatus().name()));

        return domain;
    }

    public static TarefaResponse getTarefaResponseFromTarefaDomain(Tarefa tarefa) {
        var response = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .convertValue(tarefa, TarefaResponse.class);

        response.setStatus(br.com.tarefa.representation.TarefaResponse.StatusEnum.valueOf(tarefa.getStatus().getValue()));

        return response;
    }
}
