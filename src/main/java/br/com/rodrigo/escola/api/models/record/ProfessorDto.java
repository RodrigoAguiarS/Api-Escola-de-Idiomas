package br.com.rodrigo.escola.api.models.record;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rodrigo.escola.api.models.Professor;
import lombok.Data;

@Data
public class ProfessorDto {
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private SerieDto serie;
    private List<TurmaDto> turmas;

    public Professor toEntity() {
        Professor professor = new Professor();
        professor.setId(id);
        professor.setNome(nome);
        professor.setSerie(serie.toEntity());
        professor.setTurmas(turmas.stream().map(TurmaDto::toEntity).collect(Collectors.toList()));
        return professor;
    }

    public static ProfessorDto toDto(Professor professor) {
        ProfessorDto dto = new ProfessorDto();
        dto.setId(professor.getId());
        dto.setNome(professor.getNome());
        dto.setSerie(SerieDto.toDto(professor.getSerie()));
        dto.setTurmas(professor.getTurmas().stream().map(TurmaDto::toDto).collect(Collectors.toList()));
        return dto;
    }
}