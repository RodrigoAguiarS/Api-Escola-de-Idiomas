package br.com.rodrigo.escola.api.models.record;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rodrigo.escola.api.models.Turma;
import lombok.Data;

@Data
public class TurmaDto {
    private Long id;
    private String nome;
    private ProfessorDto professor;
    private List<AlunoDto> alunos;

    public Turma toEntity() {
        Turma turma = new Turma();
        turma.setId(id);
        turma.setNome(nome);
        turma.setProfessor(professor.toEntity());
        turma.setAlunos(alunos.stream().map(AlunoDto::toEntity).collect(Collectors.toList()));
        return turma;
    }

    public static TurmaDto toDto(Turma turma) {
        TurmaDto dto = new TurmaDto();
        dto.setId(turma.getId());
        dto.setNome(turma.getNome());
        dto.setProfessor(ProfessorDto.toDto(turma.getProfessor()));
        dto.setAlunos(turma.getAlunos().stream().map(AlunoDto::toDto).collect(Collectors.toList()));
        return dto;
    }
}



