package br.com.tarefa.domain;

import br.com.tarefa.domain.enums.StatusEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
public class Tarefa {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;

    private boolean ativo;
}
